package elgca.laminar.components

import elgca.laminar.components.WebComponentsDef.{
  CustomEventType, JsUndefinedType,
}
import com.raquo.domtypes.codegen.CodeFormatting
import com.raquo.domtypes.codegen.generators.SourceGenerator
import com.raquo.domtypes.defs.attrs.HtmlAttrDefs
import com.raquo.domtypes.defs.props.PropDefs
import com.raquo.domtypes.defs.reflectedAttrs.ReflectedHtmlAttrDefs

import java.io.{File, FileOutputStream, PrintStream}
import java.nio.file.{Files, NoSuchFileException, Path}
import scala.collection.mutable

class WebComponentsGenerator(
    val config: Config, val format: CodeFormatting = CodeFormatting(),
) extends SourceGenerator(format) {

  final val Def: WebComponentsDef.type = WebComponentsDef

  /**
   * Overwrite this with directory name if you ant to output components in a
   * subdirectory
   */
  lazy val componentsPackageName: String = ""

  lazy val componentsPackagePath: String = List(
      config.baseOutputPackagePath,
      componentsPackageName,
  ).filter(_.nonEmpty).mkString(".")

  /** Package path of EventTypes file */
  lazy val eventTypesPackagePath: String = config.baseOutputPackagePath

  lazy val eventTypesObjectName: String = "EventTypes"

  /** Package path of CommonTypes, CommonKeys, WebComponent, etc. files */
  lazy val helpersPackagePath: String = config.baseOutputPackagePath

  lazy val baseCustomEventType: String = "CustomEvent"

  lazy val baseDomEventType: String = "Event"

  /**
   * If true, we'll import scala.scalajs.js.| - this is needed to support Scala
   * 2.
   */
  lazy val useScalaJsUnionType: Boolean = true

  lazy val commonStringAttrs: List[String] = List(
//    "size",
//    "target",
//    "autocapitalize",
//    "variant",
//    "placement",
//    "inputmode",
  )

  // #TODO[API] Not a fan of this very Shoelace-specific thing being here.
  //  - Should we change the variant props to have Variant or ButtonVariant types (instead of String) maybe?
  //  - Then we can process such types in the generator without deep shoelace knowledge, kinda like customEventTypes?
  def commonStringAttrScalaName(
      tagName: String, attrScalaName: String,
  ): String =
    (tagName, attrScalaName) match {
      case _ => attrScalaName
    }

  def attrImplName(scalaTypeStr: String): String =
    scalaTypeStr match {
      case "Boolean" => "boolAttr"
      case "String"  => "stringAttr"
      case "Int"     => "intAttr"
      case _ =>
        println(
            s"ATTR ...No impl defined for scala type `${scalaTypeStr}`, trying `htmlAttr` for now.",
        )
        "htmlAttr"
    }

  def propImplName: PartialFunction[String, String] = {
    case "Boolean"                                      => "boolProp"
    case "String"                                       => "stringProp"
    case "Int"                                          => "intProp"
    case "Double"                                       => "doubleProp"
    case "dom.MutationObserver" | "js.Array[js.Object]" => "asIsProp"

    // 这里添加
    case "js.Array[Double]"             => "asIsProp"
    case "js.Function1[Double, String]" => "asIsProp"
    case "org.scalajs.dom.HTMLElement"  => "asIsProp"
  }

  def cssPropType(cssType: Def.CssType): String =
    cssType match {
      case WebComponentsDef.CssLengthType =>
        "StyleProp[String] & u.Length[DSP, Int]"
      case WebComponentsDef.CssColorType =>
        "StyleProp[String] & u.Color[SS, DSP]"
      case WebComponentsDef.CssNumberType =>
        "StyleProp[Int]" // #nc not sure if it should be int or double...
      case WebComponentsDef.CssTimeType => "StyleProp[String] & u.Time[DSP]"
      case WebComponentsDef.CssLineType => "StyleProp[String] & s.Line"
    }

  def cssPropImplName(cssType: Def.CssType): String =
    cssType match {
      case WebComponentsDef.CssLengthType => "lengthStyle"
      case WebComponentsDef.CssColorType  => "colorStyle"
      case WebComponentsDef.CssNumberType => "intStyle" // #nc
      case WebComponentsDef.CssTimeType   => "timeStyle"
      case WebComponentsDef.CssLineType   => "lineStyle"
    }

  // -- Entry point & Generators --

  lazy val manifest: CustomElementsManifest =
    try {
      val fileContent = Files.readString(Path.of(config.customElementsJsonPath))
      import upickle.default.*
      read[CustomElementsManifest](fileContent)
    } catch {
      case err: NoSuchFileException =>
        throw new Exception(
            s"NoSuchFileException: ${err.getMessage} file not found. Make sure the path is correct. Make sure to npm install JS dependencies in the ./js folder.",
        )
    }

  lazy val st: WebComponentsTranslator = new WebComponentsTranslator(
      manifest = manifest,
      uiLibPropDefs = PropDefs.defs,
      uiLibAttrDefs = HtmlAttrDefs.defs,
      uiLibReflectedAttrDefs = ReflectedHtmlAttrDefs.defs,
      forceScalaAttrNames = List(
          "autocorrect" -> "autoCorrect",
      ),
      jsImportBasePath = config.jsImportBasePath,
  )

  def generate(): Unit = {
    val elements = st.components.elements

    {
      printEventTypesFile(st.customEventTypes)
      val output = getOutput()
      writeToFile(
          packagePath = eventTypesPackagePath,
          fileName = eventTypesObjectName + ".scala",
          fileContent = output,
      )
    }

    elements.foreach { el =>
      if el.writableNonReflectedProperties.nonEmpty then {
        println(el.tagName)
        println(
            el.writableNonReflectedProperties
              .map(_.propName)
              .mkString("  > ", ", ", ""),
        )
      }
    }

    elements.foreach { el =>
      val fileName = el.scalaName + ".scala"
      printElementFile(fileName, el)
      val output = getOutput()
      writeToFile(
          packagePath = componentsPackagePath,
          fileName = fileName,
          fileContent = output,
      )
    }
  }

  def printEventTypesFile(
      eventTypes: List[CustomEventType],
  ): Unit = {
    line(s"package ${eventTypesPackagePath}")
    line()
    if componentsPackagePath != eventTypesPackagePath then {
      line(s"import ${componentsPackagePath}.*")
    }
    line("import org.scalajs.dom")
    line()
    line("import scala.scalajs.js")
    if useScalaJsUnionType then {
      line("import scala.scalajs.js.|")
    }
    line()
    line(s"// This file is generated at compile-time by ${codeFileName}")
    line()
    // val objCommentLines = element.description ++ element.docUrl.map(url => s"[[$url Shoelace ${element.scalaName} docs]]").toList
    blockCommentLines(List(s"Common ${config.frameworkName} event types"))
    enter(s"object ${eventTypesObjectName} {", "}") {
      line()
      line("@js.native")
      line(s"trait ${baseCustomEventType} extends dom.${baseDomEventType}")
      line()
      eventTypes.foreach { et =>
        line()
        line("@js.native")
        enter(s"trait ${et.scalaName} extends ${baseCustomEventType} {", "}") {
          et.fields.foreach { field =>
            val scalaTypeStr = st.scalaPropOutputType(
                s"prop `${field.domName}` in event type `${et.scalaName}`",
                field.jsTypes,
            )
            line()
            blockCommentLines(field.description)
            line(s"val ${field.scalaName}: ${scalaTypeStr}")
          }
        }
        et.scalaName
      }
    }
  }

  def printElementFile(
      elementFileName: String, element: Def.Element,
  ): Unit = {

    line(s"package ${componentsPackagePath}")
    line()

    val supportsControlledInput = st.allowControlKeys(element.tagName).nonEmpty

    printComponentFileImports(element, supportsControlledInput)

    val extraTraits = List(
        if supportsControlledInput then "ControlledInput" else "",
    ).filter(_.nonEmpty).map(" with " + _).mkString(" ")

    val objCommentLines = {
      val onlineSourceUrl =
        config.onlineSourceRoot + "/" + config.baseOutputDirectoryPath + "/" + elementFileName
      val onlineSourceUrlLine =
        s"[[$onlineSourceUrl ${elementFileName} source code]]"
      val componentsDocUrl = element.docUrl
        .map(url =>
          s"[[$url ${config.frameworkName} ${element.scalaName} docs]]")
        .toList
      List(
          element.description,
          List(onlineSourceUrlLine),
          componentsDocUrl,
      ).filter(_.nonEmpty).flatMap(_ :+ "").init
    }

    blockCommentLines(objCommentLines)
    enter(
        s"object ${element.scalaName} extends WebComponent(${repr(
              element.tagName)})${extraTraits} {",
        "}",
    ) {

      printComponentRawImport(element)

      val componentTraitName = rawComponentTraitName(element)
      val elementBaseType = "dom." + st.elementBaseType(element.tagName)
      val showRawComponent = element.allJsProperties.nonEmpty

      printRefType(
          element.scalaName,
          componentTraitName,
          showRawComponent,
          elementBaseType,
      )

      printTag(st.allowControlKeys(element.tagName))

      printEventProps(element)

      printAttributes(element)

      printProps(element)

      printSlots(element)

      printCssProps(element, nestUnderObjectName = None)

      printCssParts(element)

      if showRawComponent then {
        printRawComponent(element, componentTraitName, elementBaseType)
      }
    }
  }

  def printComponentFileImports(
      element: Def.Element, supportsControlledInput: Boolean,
  ): Unit = {
    val customEventTypes = element.events.flatMap(_.customType)
    val laminarKeyTypes = List(
        if element.events.nonEmpty then "EventProp" else "",
        if element.writableNonReflectedProperties.nonEmpty then "HtmlProp"
        else "",
        if element.attributes.nonEmpty then "HtmlAttr" else "",
        if element.cssProperties.nonEmpty then "StyleProp" else "",
    ).filter(_.nonEmpty)
    if laminarKeyTypes.nonEmpty then {
      line(
          s"import com.raquo.laminar.keys.${laminarKeyTypes.mkString("{", ", ", "}")}",
      )
    }
    // line("import com.raquo.utils.JSImportSideEffect")
    if customEventTypes.nonEmpty then {
      line(s"import ${eventTypesPackagePath}.${eventTypesObjectName}.*")
    }
    if eventTypesPackagePath != componentsPackagePath then {
      // 这里修改
      // 因为修改了对应代码，我不再需要CommonKeys了
      line(s"import ${helpersPackagePath}.WebComponent")
    }
    line("import com.raquo.laminar.api.L")
    if element.cssProperties.nonEmpty then {
      line("import com.raquo.laminar.defs.styles.{traits as s, units as u}")
    }
    if element.slots.nonEmpty then {
      line("import com.raquo.laminar.nodes.Slot")
    }
    if supportsControlledInput then {
      line("import com.raquo.laminar.tags.CustomHtmlTag")
    }
    line("import org.scalajs.dom")
    line()
    line("import scala.scalajs.js")
    if useScalaJsUnionType then {
      line("import scala.scalajs.js.|")
    }
    line("import scala.scalajs.js.annotation.JSImport")
    line()
    line(
        s"// This file is generated at compile-time by ${codeFileName}",
    )
    line()
  }

  def printComponentRawImport(element: Def.Element): Unit = {
    line()
    line(s"@JSImport(${repr(element.importPath)}, JSImport.Namespace)")
    line("@js.native object RawImport extends js.Object")
  }

  def printRefType(
      componentObjectName: String, componentTraitName: String,
      showRawComponent: Boolean, elementBaseType: String,
  ): Unit = {
    line()
    line(s"type Self = ${componentObjectName}.type") // #nc #TODO Organize
    if showRawComponent then {
      line()
      line(s"type Ref = ${componentTraitName} & ${elementBaseType}")
    } else {
      line()
      line(s"type Ref = ${elementBaseType}")
    }
  }

  def printTag(allowedControlKeys: Option[(String, String, String)]): Unit =
    allowedControlKeys.foreach {
      case (propName, eventPropName, initialValueRepr) =>
        line()
        enter(s"override protected lazy val tag: CustomHtmlTag[Ref] = {", "}") {
          line(
              s"tagWithControlledInput(${propName}, initial = ${initialValueRepr}, ${eventPropName})",
          )
        }
    }

  def printEventProps(element: Def.Element): Unit = {
    line()
    line()
    line("// -- Events --")
    element.events.foreach { event =>
      val customEventTypeDef = event.customType
      val eventType =
        customEventTypeDef.map(_.scalaName).getOrElse(st.baseEventType)
      line()
      blockCommentLines(event.description)
      line(
          s"lazy val ${event.scalaName}: EventProp[${eventType}] = eventProp(${repr(event.domName)})",
      )
    }
  }

  def printAttributes(element: Def.Element): Unit = {
    // 这里添加
    // 替代来自原先手写CommonKeys,在当前组件类内部创建一个CommonKe类
    // Map[CommonKeysName,(attr.attrName,Values)]
    val commonKeys = new mutable.HashMap[String, (String, Seq[String])]
    line()
    line()
    line("// -- Attributes --")
    element.attributes.foreach { attr =>
      line()
      val needCommonKeys = attr.jsTypes.forall {
        case Def.JsStringConstantType(_) => true
        case Def.JsUndefinedType         => true
        case other                       => false
      }

      val scalaTypeStr = st.scalaAttrInputTypeStr(attr, element.tagName)
      blockCommentLines(attr.description)
      if (needCommonKeys) {
        // 增加
        val commonKeyName =
          commonStringAttrScalaName(element.tagName, attr.scalaName)

        val values = attr.jsTypes
          .map {
            case Def.JsStringConstantType(value) => value
            case Def.JsUndefinedType             => null
          }
          .filter(_ != null)
        assert(
            !commonKeys.contains(commonKeyName),
            s"Duplicate CommonKeysName:${commonKeyName} tag: ${element.tagName} before: ${commonKeys
                .get(commonKeyName)} current: ${attr.attrName} ${values}",
        )
        commonKeys.put(commonKeyName, (attr.attrName, values))
        line(
            s"lazy val ${attr.scalaName}: CommonKeys.${commonKeyName}.type = CommonKeys.${commonKeyName}",
        )
      } else if commonStringAttrs.contains(
            attr.attrName,
        ) && attr.jsTypes.forall {
          case Def.JsStringType | Def.JsStringConstantType(_) |
              Def.JsUndefinedType =>
            true
          case _ => false
        }
      then {
        val commonKeyName =
          commonStringAttrScalaName(element.tagName, attr.scalaName)
        line(
            s"lazy val ${attr.scalaName}: CommonKeys.${commonKeyName}.type = CommonKeys.${commonKeyName}",
        )
      } else {
        line(
            s"lazy val ${attr.scalaName}: HtmlAttr[${scalaTypeStr}] = ${attrImplName(
                  scalaTypeStr)}(${repr(attr.attrName)})",
        )
      }
      if attr.scalaAliases.nonEmpty then {
        attr.scalaAliases.foreach { alias =>
          line()
          line(
              s"lazy val ${alias}: HtmlAttr[${scalaTypeStr}] = ${attr.scalaName}",
          )
        }
      }
    }
    // create CommonKeys
    if (commonKeys.nonEmpty) {
      // 通过这里创建CommonKeys
      line("// -- CommonKeys --")
      enter("object CommonKeys extends CommonTypes {", "}") {
        line("import com.raquo.laminar.codecs.StringAsIsCodec")
        line("import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}")
        line("import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter")
        commonKeys.foreach { case (commonKeyName, (attrName, values)) =>
          line()
          enter(
              s"object ${commonKeyName} extends HtmlAttr[String](${repr(attrName)}, StringAsIsCodec) {",
              "}",
          ) {
            values.foreach { value =>
              val valueName = commonKeyScalifyName(value)
              line()
              line(
                  s"lazy val ${valueName}: HtmlAttrSetter[String] = ${commonKeyName}(${repr(value)})",
              )
            }
          }
        }
      }

      println(s"CommonKeys for ${element.scalaName}")
      commonKeys.foreach { case (commonKeyName, (attrName, values)) =>
        println(s"> ${commonKeyName}[${attrName}] : ${values.mkString("|")}")
      }
    }
  }

  def commonKeyScalifyName(rawName: String): String = {
    // 保留原本的字段信息
    // keep org name, used more easy
    s"`${rawName}`"
    val reservedRuler = (name: String) => {
      val reservedScalaWords = List("lazy", "type")
      val validValue = """^[a-zA-Z0-9\-_]+$""".r
      reservedScalaWords.contains(name) ||
      name.head.toString.toIntOption.isDefined ||
      !validValue.matches(name)
    }
    if reservedRuler(rawName) then {
      s"`${rawName}`"
    } else {
      st.scalifyPrefixedName("", rawName)
    }
  }

  def printProps(element: Def.Element): Unit = {
    line()
    line()
    line("// -- Props --")
    element.writableNonReflectedProperties.foreach { prop =>
      line()
      val scalaInputTypeStr = st.scalaPropInputTypeStr(prop, element.tagName)
      val propImpl = st
        .useUiLibraryProp(element.tagName, prop.propName, prop.jsTypes)
        .map(uiLibraryScalaName => s"L.$uiLibraryScalaName")
        .orElse {
          propImplName
            .lift(scalaInputTypeStr)
            .map(propMethodName => s"${propMethodName}(${repr(prop.propName)})")
        }
      blockCommentLines(prop.description)
      propImpl match
        case Some(value) =>
          line(
              s"lazy val ${prop.propName}: HtmlProp[${scalaInputTypeStr}, ?] = ${value}",
          )
        case None =>
          println(
              s"PROP ...No impl defined for scala type `${scalaInputTypeStr}`, " +
                s"tag:`${element.tagName}`, class:`${element.scalaName}`, " +
                s" trying `asIsProp` for now.",
          )
          line(
              s"lazy val ${prop.propName}: HtmlProp[${scalaInputTypeStr}, ?] = asIsProp(${repr(prop.propName)})",
          )

    }
  }

  def printSlots(element: Def.Element): Unit = {
    line()
    line()
    line("// -- Slots --")
    line()
    if element.slots.isEmpty then {
      line("/** This component has no slots - don't give it any children. */")
      line("@inline def noSlots: Unit = ()")
    } else {
      enter("object slots {", "}") {
        element.slots.map { slot =>
          line()
          val commentLines = slot.description
          if slot.isDefault then {
            val extraString =
              "Note: You can just say `_ => element` instead of `_.slots.default(element)`"
            if commentLines.length == 1 then {
              blockCommentLines(List(commentLines.head + " " + extraString))
            } else {
              blockCommentLines(commentLines :+ extraString)
            }
          } else {
            blockCommentLines(commentLines)
          }
          line(
              s"lazy val ${slot.scalaName}: Slot = Slot(${repr(slot.domName)})",
          )
        }
      }
    }
  }

  def printCssProps(
      element: Def.Element, nestUnderObjectName: Option[String],
  ): Unit = {

    def printProps(): Unit =
      element.cssProperties.foreach { cssProp =>
        line()
        val commentLines =
          cssProp.description.map(_.replace(" _(default: undefined)_", ""))
        blockCommentLines(commentLines)
        line(s"lazy val ${cssProp.scalaName}: ${cssPropType(
                  cssProp.cssType,
              )} = ${cssPropImplName(cssProp.cssType)}(${repr(cssProp.cssName)})")
      }

    line()
    line()
    line("// -- CSS Vars --")
    nestUnderObjectName.fold {
      printProps()
    } { objectName =>
      line()
      if element.cssProperties.isEmpty then {
        line("/** This component has no CSS vars / custom properties. */")
        line("@inline def noCssVars: Unit = ()")
      } else {
        enter(s"object ${objectName} {", "}") {
          printProps()
        }
      }
    }
  }

  def printCssParts(element: Def.Element): Unit = {
    line()
    line()
    line("// -- CSS Parts --")
    line()
    if element.cssParts.isEmpty then {
      line("/** This component has no CSS parts. */")
      line("@inline def noCssParts: Unit = ()")
    } else {
      line(
          "/** For documentation only. You need to style these from a CSS stylesheet. */",
      )
      enter("object cssParts {", "}") {
        element.cssParts.map { part =>
          line()
          blockCommentLines(part.description)
          line(s"lazy val ${part.scalaName}: String = ${repr(part.cssName)}")
        }
      }
    }
  }

  def printRawComponent(
      element: Def.Element, componentTraitName: String, elementBaseType: String,
  ): Unit = {
    line()
    line()
    line("// -- Element type -- ")
    line()
    enter(
        s"@js.native trait ${componentTraitName} extends js.Object { this: ${elementBaseType} => ",
        "}",
    ) {
      element.allJsProperties.foreach { prop =>
        val context =
          s"RawComponent prop `${prop.propName}` in `${element.tagName}`"
        val outputType = st.scalaPropOutputType(context, prop.jsTypes)
        val defType = if prop.readonly then "val" else "var"
        line()
        blockCommentLines(prop.description)
        line(s"${defType} ${prop.propScalaName}: ${outputType}")
      }
    }
  }

  def rawComponentTraitName(element: Def.Element): String =
    element.scalaName + "Component"

  // -- Various helpers --

  /** Helper tool to find common / popular attributes */
  def printAttrUsageAnalysis(
      elements: List[Def.Element],
  ): Unit = {
    println("-- Most popular attributes --")

    val attrs = mutable.Map[String, List[Def.Element]]()

    elements.foreach { el =>
      el.attributes.foreach { attr =>
        val key = repr(attr.attrName) + " -> " + attr.jsTypes
          .filterNot(_ == JsUndefinedType)
          .map("Def." + _.toString)
          .mkString("List(", ", ", "),")
        val els = attrs.getOrElse(key, Nil)
        attrs.update(key, els :+ el)
      }
    }

    val sortedAttrs = attrs.toList.sortBy { case (attrName, elements) =>
      -elements.length
    }

    sortedAttrs.foreach { case (key, els) =>
      println(
          s"${key} // ${els.length} usages: ${els.map(_.scalaName).mkString(", ")}",
      )
    }
    println(
        s"Total unique attr names: ${sortedAttrs.length}, and attr instances: ${sortedAttrs
            .foldLeft(0)((acc, t) => acc + t._2.length)}",
    )
    val n = 4
    val filteredAttrs = sortedAttrs.filter(_._2.length >= n)
    println(
        s"(N usages >= ${n}), Total unique attr names ${filteredAttrs.length}, and attr instances: ${filteredAttrs
            .foldLeft(0)((acc, t) => acc + t._2.length)}",
    )
  }

  // def whenNonEmpty[A](rawList: List[A])(print: List[A] => Unit): Unit = {
  //  if (rawList.nonEmpty) {
  //    print(rawList)
  //  }
  // }

  def replaceFirstPrefix(
      line: String, findReplace: List[(String, String)],
  ): String =
    findReplace
      .collectFirst {
        case (prefix, replacement) if line.startsWith(prefix) =>
          replacement + line.substring(prefix.length)
      }
      .getOrElse(line)

  def writeToFile(
      packagePath: String, fileName: String, fileContent: String,
  ): File = {
    val filePath = config.baseOutputDirectoryPath + "/" + (packagePath + ".")
      .replace(config.baseOutputPackagePath + ".", "")
      .replace(".", "/") + fileName.replaceAll(".scala$", "") + ".scala"
    val outputFile = new File(filePath)
    outputFile.getParentFile.mkdirs()

    val fileOutputStream = new FileOutputStream(outputFile)
    val outputPrintStream = new PrintStream(fileOutputStream)

    outputPrintStream.print(fileContent)
    outputPrintStream.flush()

    // Flush written file contents to disk https://stackoverflow.com/a/4072895/2601788
    fileOutputStream.flush()
    fileOutputStream.getFD.sync()

    outputPrintStream.close()

    outputFile
  }
}
