package elgca.laminar.components

import elgca.laminar.components.WebComponentsDef.{JsBooleanType, JsStringType}
import com.raquo.domtypes.common.{AttrDef, PropDef, ReflectedHtmlAttrDef}

import scala.util.matching.Regex

class WebComponentsTranslator(
  val manifest: CustomElementsManifest,
  val uiLibPropDefs: List[PropDef],
  val uiLibAttrDefs: List[AttrDef],
  val uiLibReflectedAttrDefs: List[ReflectedHtmlAttrDef],
  val forceScalaAttrNames: List[(String, String)],
  val jsImportBasePath: String,
) {

  import WebComponentsTranslator.Def

  val M: CustomElementsManifest.type = CustomElementsManifest

  /** Returns scalajs-dom type for the component's base element type */
  def elementBaseType(tagName: String): String =
    // #TODO
    tagName match {
      // case "mdui-button" => "HTMLButtonElement" // This can be a link too... Ugh..
      case "mdui-input"    => "HTMLInputElement"
      case "mdui-textarea" => "HTMLTextAreaElement"
      // case "mdui-select" => "HTMLSelectElement" // Does not seem to be the case...
      case _ => "HTMLElement"
    }

  def isInputElement(tagName: String): Boolean =
    tagName match {
      case "mdui-button"       => true
      case "mdui-checkbox"     => true
      case "mdui-color-picker" => true
      case "mdui-input"        => true
      case "mdui-radio-group"  => true
      case "mdui-range"        => true
      case "mdui-select"       => true
      case "mdui-switch"       => true
      case "mdui-textarea"     => true
      case _                   => false
    }

  /**
   * Some HTML props we want to reference in the UI library instead of creating new instances. This is mostly relevant to controlled inputs functionality where reference equality of props / attrs matters.
   *
   * Return the UI library's scalaName for the prop, or None.
   */
  def useUiLibraryProp(
    tagName: String,
    propDomName: String,
    jsTypes: List[Def.JsType],
  ): Option[String] =
    (tagName, propDomName, jsTypes) match {
      case (_, "value", List(JsStringType))    => Some("value")
      case (_, "checked", List(JsBooleanType)) => Some("checked")
      case _                                   => None
    }

  /**
   * Laminar needs to know which keys are allowed in `controlled` blocks. Web components often have their own name, e.g. Shoelace uses `mdui-input` instead of `input` for onInput events.
   *
   * Return (propScalaName, eventPropScalaName, initialValueRepr)
   */
  def allowControlKeys(tagName: String): Option[(String, String, String)] = {
    val falseRepr       = "false"
    val emptyStringRepr = "\"\""
    tagName match {
      case "mdui-checkbox" =>
        Some(("checked", "onInput", falseRepr)) // or onChange?
      case "mdui-color-picker" => Some(("value", "onInput", emptyStringRepr))
      case "mdui-input"        => Some(("value", "onInput", emptyStringRepr))
      case "mdui-radio-group" =>
        Some(("value", "onInput", emptyStringRepr)) // or onChange?
      // case "mdui-range" => ??? // #TODO
      case "mdui-select" =>
        // 这里变更为onChange
        Some(("value", "onChange", emptyStringRepr)) // or onChange? #TODO
      case "mdui-switch" =>
        Some(("checked", "onInput", falseRepr)) // or onChange?
      case "mdui-textarea" => Some(("value", "onInput", emptyStringRepr))
      case _               => None
    }
  }

  // #nc We probably want a shared trait with these, because mdui-select for example is not an actual select element, but its API is made to match it.
  val sharedInputElementReadonlyProps: List[String] = List(
    "validity",
    "validationMessage",
  )

  val baseEventType: String = "dom.Event"

  /**
   * Fields that are already defined on the element base type in scalajs-dom. Does not have to be exhaustive, can just include what is also defined in Shoelace, to avoid conflicts or duplication
   *
   * scalajs-dom element type -> fieldName
   */
  val builtInFields: List[(String, List[String])] = {
    val validityKeys = List("validity", "validationMessage")
    List(
      // HTMLElement is a special key that is applied to all types
      // "HTMLElement" -> List(),
      // "HTMLButtonElement" -> validityKeys,
      // "HTMLInputElement" -> validityKeys,
      // "HTMLSelectElement" -> validityKeys,
      // "HTMLTextAreaElement" -> validityKeys
    )
  }

  // Can be found in lib.dom.d.ts in Typescript:
  // https://github.com/microsoft/TypeScript/blob/main/src/lib/dom.generated.d.ts
  val stringConstantsCustomTypes: Map[String, List[String]] = Map(
    "FillMode" -> List("auto", "backwards", "both", "forwards", "none"),
    "PlaybackDirection" -> List(
      "alternate",
      "alternate-reverse",
      "normal",
      "reverse",
    ),
  )

  // Fix types that are missing or incorrect in Shoelace manifest
  def fixTypes(
    tagName: String,
    attrNameOrPropName: String,
    jsTypes: List[Def.JsType],
  ): List[Def.JsType] =
    (tagName, attrNameOrPropName) match {
      case ("mdui-alert", "duration") =>
        List(Def.JsNumberType) // Double or Infinity
      case ("mdui-animation", "iterations") =>
        List(Def.JsNumberType) // Int or Infinity
      case _ => jsTypes
    }

  // Return Some(attrName, aliases) if you want to skip scalifyAttrName logic and provide your own names.
  def maybeRenameAttr(
    tagName: String,
    attrNameOrPropName: String,
  ): Option[(String, List[String])] =
    (tagName, attrNameOrPropName) match {
      case ("mdui-alert", "duration") => Some(("durationMs", Nil))
      case _                          => None
    }

  /** Pretend that these fields don't exist in the manifest at all. */
  def shouldIgnoreField(
    tagName: String,
    propName: String,
    jsTypes: List[Def.JsType],
  ): Boolean =
    return (tagName, propName, jsTypes) match {
//      case (_, "defaultValue" | "defaultChecked", _) => true
      case _ => false
    }
    // I think in Shoelace a lot of these would be covered by a
    // "member has no documentation string" rule, but I haven't
    // checked for false positives.
    (tagName, propName, jsTypes) match {
      // #nc #nc #nc vvvvvv TODO
      case ("mdui-color-picker", "swatches", _) =>
        true // Composite List[String] separated by ; IF used as an attribute. Property is an array, but not reflected.
      case ("mdui-format-date" | "mdui-relative-time", "date", _) =>
        true // Date | String - convert date with `date.toISOString()` - For MVP, just make an attribute, and a codec for date?
      // case ("mdui-select", "value" | "defaultValue", _) => true // String | String[]. Space-delimited string in html attr. Use `value` vs `values`?
      // #nc #nc #nc ^^^^^ TODO
      // Don't want those props, we have (non-reflected) attributes for them.
      case (_, "defaultValue" | "defaultChecked", _) => true
      // Don't need this
      case (_, "dependencies", _) => true
      // Unlike other slot props, this one returns a js.Promise of an element, not even an element
      case ("mdui-animation", "defaultSlot", _) => true
      // Exposed as read-write, but I think this is for internal use
      case ("mdui-button-group", "disableRole", _) => true
      // Read-write fields accepting an element, or a list of elements
      // #TODO Not sure how to encode it right, do it later
      case ("mdui-popup", p, _) if p.endsWith("Boundary") => true
      // Hell if I know what this is.
      case ("mdui-select", "displayLabel", _) => true
      // Hell if I know what this is.
      case ("mdui-progress-ring", "indicatorOffset", _) => true
      // Callback JsCustomType((value: number) => string) #TODO encode this
      case ("mdui-range", "tooltipFormatter", _) => true
      // Callback JsCustomType((value: number) => string) #TODO encode this
      case ("mdui-rating", "getSymbol", _) => true
      // Not sure what these are, I guess readonly, but we probably need Laminar methods for these anyway
      case ("mdui-input", "valueAsDate" | "valueAsNumber", _) => true
      // Various callbacks
      // #TODO we probably need to handle them somehow, might need special integration
      case (_, p, _) if p.startsWith("handle") => true
      // Modal field exposes the underlying modal for focus trapping. It has no type in Shoelace manifest.
      // #TODO It could be useful but need to read about its type and test it out.
      case ("mdui-dialog" | "mdui-drawer", "modal", _) => true
      // These are (should be) read-only references to various important elements in many components
      // #TODO expose them some time later if that's actually needed
      case (_, p, types) if types.exists {
            case Def.JsCustomType(str) if str.endsWith("Element") =>
              true // regular elements & slots
            case Def.JsCustomType(str) if str.startsWith("Sl") =>
              true // custom element types
            case _ => false
          } =>
        true
      case _ => false
    }

  /** Force our logic to consider certain properties non-reflected. */
  def forceNonReflectedProperty(tagName: String, propName: String): Boolean =
    (tagName, propName) match {
      // `value` property and `value` attribute are named similarly, but are not reflected.
      case (_, "value") => true
      // `checked` property and `checked` attribute are named similarly, but are not reflected.
      case (_, "checked") => true
      case _              => false
    }

  /** These should have been marked read-only in Shoelace config */
  def forceReadonlyField(
    tagName: String,
    propName: String,
    jsTypes: List[Def.JsType],
  ): Boolean =
    (tagName, propName, jsTypes) match {
      case ("mdui-animated-image", "frozenFrame", _) => true
      case ("mdui-animated-image", "isLoaded", _)    => true
      case ("mdui-carousel", "activeSlide", _)       => true
      case ("mdui-button", "invalid", _)             => true
      case ("mdui-option", "current" | "selected" | "hasHover", _) =>
        true // #TODO check if `selected` is writable, it's not documented...
      case ("mdui-copy-button", "isCopying", _)       => true
      case ("mdui-modal" | "mdui-drawer", "modal", _) => true
      case (
            "mdui-tree-item",
            "indeterminate" | "isLeaf" | "loading" | "selectable",
            _,
          ) =>
        true
      case _ => false
    }

  /**
   * Manually sourced from https://github.com/shoelace-style/shoelace/tree/next/src/events because custom-elements.json does not seem to contain this data.
   */
  lazy val customEventTypes: List[Def.CustomEventType] = Nil
  List(
    CustomEventType("SlCopyEvent")(
      "value" -> "string",
    ),
    CustomEventType("SlErrorEvent")(
      "status" -> "number | undefined",
    ),
    CustomEventType("SlHoverEvent")(
      "phase" -> "'start' | 'move' | 'end'",
      "value" -> "number",
    ),
    CustomEventType("SlMutationEvent")(
      "mutationList" -> "MutationRecord[]",
    ),
    CustomEventType("SlRequestCloseEvent")(
      "source" -> "'close-button' | 'keyboard' | 'overlay'",
    ),
    CustomEventType("SlResizeEvent")(
      "entries" -> "ResizeObserverEntry[]",
    ),
    CustomEventType("SlSelectEvent")(
      "item" -> "SlMenuItem",
    ),
    CustomEventType("SlSelectionChangeEvent")(
      "selection" -> "SlTreeItem[]",
    ),
    CustomEventType("SlSlideChangeEvent")(
      "index" -> "number",
      "slide" -> "SlCarouselItem",
    ),
    CustomEventType("SlTabHideEvent")(
      "name" -> "string",
    ),
    CustomEventType("SlTabShowEvent")(
      "name" -> "string",
    ),
  )

  private val cssPropTypes = List(
    // Length
    CssPropTypePattern("width$"   -> Def.CssLengthType),
    CssPropTypePattern("height$"  -> Def.CssLengthType),
    CssPropTypePattern("size$"    -> Def.CssLengthType),
    CssPropTypePattern("offset$"  -> Def.CssLengthType),
    CssPropTypePattern("spacing$" -> Def.CssLengthType),
    CssPropTypePattern(
      "border-radius$" -> Def.CssLengthType,
    ), // potentially composite value
    CssPropTypePattern(
      "padding$" -> Def.CssLengthType,
    ), // potentially composite value
    CssPropTypePattern("mdui-carousel")(
      "^slide-gap|scroll-hint$" -> Def.CssLengthType,
    ),
    CssPropTypePattern("mdui-split-panel")(
      "^divider-hit-area|min|max$" -> Def.CssLengthType,
    ),
    // Color
    CssPropTypePattern("color$" -> Def.CssColorType),
    CssPropTypePattern(
      "^(track|symbol)-color-(active|inactive)$" -> Def.CssColorType,
    ),
    // Duration
    CssPropTypePattern("mdui-spinner")("^speed$" -> Def.CssTimeType),
    CssPropTypePattern("mdui-progress-ring")(
      "^indicator-transition-duration$" -> Def.CssTimeType,
    ),
    CssPropTypePattern("mdui-tooltip")("-delay$" -> Def.CssTimeType),
    // Number
    CssPropTypePattern("ratio$" -> Def.CssNumberType),
    // Line type
    CssPropTypePattern("mdui-tree")("^indent-guide-style$" -> Def.CssLineType),

    // 这里添加
    CssPropTypePattern("shape-corner$"           -> Def.CssLengthType),
    CssPropTypePattern("z-index$"                -> Def.CssLengthType),
    CssPropTypePattern("shape-corner-small$"     -> Def.CssLengthType),
    CssPropTypePattern("shape-corner-normal$"    -> Def.CssLengthType),
    CssPropTypePattern("shape-corner-large$"     -> Def.CssLengthType),
    CssPropTypePattern("shape-corner-rounded$"   -> Def.CssLengthType),
    CssPropTypePattern("shape-corner-indicator$" -> Def.CssLengthType),
    CssPropTypePattern("shape-corner-plain$"     -> Def.CssLengthType),
    CssPropTypePattern("shape-corner-thumb$"     -> Def.CssLengthType),
    CssPropTypePattern("shape-corner-rich$"      -> Def.CssLengthType),
  )

  def cssPropertyType(
    cssPropName: String,
    cssPropDescription: String,
    elementTagName: String,
  ): Def.CssType = {
    val propNameWithoutPrefix = withoutPrefix("--", cssPropName)
    val maybeType = cssPropTypes.collectFirst {
      case CssPropTypePattern(maybeTagName, propNameRegex, cssType)
          if maybeTagName.forall(_ == elementTagName) && propNameRegex
            .findFirstMatchIn(propNameWithoutPrefix)
            .nonEmpty =>
        cssType
    }
    maybeType.getOrElse(
      throw new Exception(
        s"Unknown type of css property named `${cssPropName}` in element `${elementTagName}` (desc: `${cssPropDescription}`) ",
      ),
    )
  }

  def elements: List[Def.Element] =
    manifest.validModules.map { module =>
      if module.kind != "javascript-module" then {
        throw new Exception(
          s"Unknown module type `${module.kind}` for module `${module.path}`.",
        )
      }
      if module.validDeclarations.length != 1 then {
        throw new Exception(
          s"Expected exactly one declaration in module `${module.path}`, got ${module.validDeclarations.length}.",
        )
      }
      val declaration = module.validDeclarations.head
      if declaration.kind != "class" then {
        throw new Exception(
          s"Expected kind=class declaration in module `${module.path}`, got `${declaration.kind}` for declaration `${declaration.name}`.",
        )
      }
      if !declaration.customElement then {
        throw new Exception(
          s"Expected customElement=true declaration in module `${module.path}` for declaration `${declaration.name}`.",
        )
      }
      val props = allJsProperties(declaration)
      val attrs = attributes(declaration)
      Def.Element(
        tagName = declaration.tagName,
        // 这里添加
        scalaName = declaration.name, // withoutPrefix("Sl", declaration.name),
        importPath = importPath(declaration),
        elementBaseType = elementBaseType(declaration.tagName),
        docUrl = Some(declaration.documentation).filter(_.nonEmpty),
        description = descriptionLines(
          Some(declaration.description)
            .filter(_.nonEmpty)
            .getOrElse(declaration.summary),
        ),
        events = events(declaration),
        allJsProperties = props,
        writableNonReflectedProperties = writableNonReflectedProperties(
          declaration,
          props,
          exceptAttributes = attrs,
        ),
        attributes = attrs,
        cssProperties = cssProperties(declaration),
        cssParts = cssParts(declaration),
        slots = slots(declaration),
      )
    }

  def importPath(elementDeclaration: M.Declaration): String = {
    val moduleName = elementDeclaration.pureTagName
    s"${jsImportBasePath}/${moduleName}/${moduleName}.js"
  }

  def events(elementDeclaration: M.Declaration): List[Def.Event] =
    elementDeclaration.events.map { event =>
      Def.Event(
        description = descriptionLines(event.description),
        domName = event.name,
        scalaName = scalifyEventPropName(event.name),
        customType = customEventTypes.find(_.rawName == event.eventClass),
      )
    }

  def allJsProperties(elementDeclaration: M.Declaration): List[Def.Field] =
    // val baseElementType = elementBaseType(elementDeclaration.tagName)
    elementDeclaration.members.filter { m =>
      m.kind == "field" && m.privacy == "public" && !m.static
    }.filterNot { m =>
      isInputElement(
        elementDeclaration.tagName,
      ) && sharedInputElementReadonlyProps.contains(m.name)
    }
      // .filterNot { m =>
      //  builtInFields
      //    .collectFirst { case (`baseElementType`, fields) => fields }
      //    .getOrElse(Nil)
      //    .contains(m.name)
      // }
      // .filterNot { m =>
      //  ignoreFields.exists(_.findFirstIn(m.name).nonEmpty)
      // }
      .flatMap { m =>
        val jsTypes = parseJsTypes(elementDeclaration.tagName, m.name, m.`type`)
        if shouldIgnoreField(elementDeclaration.tagName, m.name, jsTypes) then {
          None
        } else {
          val attrName = Some(m.attribute).filter(_.nonEmpty)
          if attrName.isEmpty && m.reflects then {
            throw new Exception(
              s"Reflected prop `${m.name}` in element `${elementDeclaration.tagName}` has no attribute specified.",
            )
          }
          // In Shoelace, you can have an attribute like "label", setting which sets the property "label",
          // but updating the property does not update the attribute. So it's like a one-way binding.
          // And this is pretty common. In this scenario, I think it's more beneficial to set attributes?
          // - For one, setting an attribute make it appear in the DOM, and that means CSS selectors will work.
          // - But also, setting the attribute keeps the data in sync, whereas setting the property disconnects
          //   the attribute from the property's value. Not sure if the components update any of their own props.
          // if (attrName.nonEmpty && !m.reflects) {
          //  if (elementDeclaration.attributes.exists(_.name == m.attribute)) {
          //    println(s">> WARNING >> Prop `${m.name}` in element `${elementDeclaration.tagName}` has corresponding attribute `${m.attribute}` but is not set as reflected???")
          //  }
          // }
          Some(
            Def.Field(
              propName = m.name,
              propScalaName = scalifyPropName(m.name),
              attrName = attrName,
              reflected = m.reflects,
              readonly = isFieldReadonly(elementDeclaration, m, jsTypes),
              jsTypes = jsTypes,
              default = Some(m.default).filter(_.nonEmpty),
              description = descriptionLines(m.description),
            ),
          )
        }
      }

  def isFieldReadonly(
    element: M.Declaration,
    field: M.Member,
    jsTypes: List[Def.JsType],
  ): Boolean =
    field.readonly || forceReadonlyField(element.tagName, field.name, jsTypes)

  // def readOnlyProperties(element: M.Declaration, fields: List[Def.Field], exceptAttributes: List[Def.Attribute]): List[Def.Field] = {
  //  fields.filter { field =>
  //    isFieldReadonly(element, field) && !exceptAttributes.exists(a => field.attrName.contains(a.attrName))
  //  }
  // }

  def writableNonReflectedProperties(
    element: M.Declaration,
    allProperties: List[Def.Field],
    exceptAttributes: List[Def.Attribute],
  ): List[Def.Field] =
    allProperties.filter { field =>
      lazy val isReflected = {
        val forceUse =
          forceNonReflectedProperty(element.tagName, field.propName)
        forceUse || !exceptAttributes.exists(a =>
          field.attrName.contains(a.attrName),
        )
      }
      !field.readonly && isReflected
    }

  def attributes(elementDeclaration: M.Declaration): List[Def.Attribute] =
    elementDeclaration.attributes.flatMap { attr =>
      val tagName = elementDeclaration.tagName
      val jsTypes = parseJsTypes(tagName, attr.name, attr.`type`)
      if jsTypes.exists(t => isAttributeTypeHtmlCompatible(t).contains(false))
      then {
        // Attr contains HTML-incompatible types such as element, function, date, etc.
        // So, we must use it as a property instead.
        None
      } else {
        val (scalaName, scalaAliases) =
          maybeRenameAttr(tagName, attr.name)
            .getOrElse(scalifyAttrName(attr.name))
        Some(
          Def.Attribute(
            attrName = attr.name,
            scalaName = scalaName,
            scalaAliases = scalaAliases,
            jsTypes = jsTypes,
            default = Some(attr.default).filter(_.nonEmpty),
            description = descriptionLines(attr.description),
          ),
        )
      }
    }

  /** @return "None" means ignore this type in HTML. */
  def isAttributeTypeHtmlCompatible(jsType: Def.JsType): Option[Boolean] =
    jsType match {
      case _: Def.JsAttributeInputType => Some(true)
      case Def.JsUndefinedType         => None
      case Def.JsCustomType(_)         => Some(false)
    }

  def cssParts(elementDeclaration: M.Declaration): List[Def.CssPart] =
    elementDeclaration.cssParts.map { part =>
      val partName = if part.name == "" then {
        if elementDeclaration.tagName == "mdui-animated-image" then {
          "control-box" // #nc looks like a bug in shoelace manifest - report.
        } else {
          throw new Exception(
            s"Encountered empty CSS part name in element `${elementDeclaration.tagName}`.",
          )
        }
      } else {
        part.name
      }
      Def.CssPart(
        description = descriptionLines(part.description),
        cssName = partName,
        scalaName = scalifyName(partName),
      )
    }

  def cssProperties(
    elementDeclaration: M.Declaration,
  ): List[Def.CssProperty] =
    elementDeclaration.cssProperties.map { prop =>
      Def.CssProperty(
        description = descriptionLines(prop.description),
        cssName = prop.name,
        scalaName = scalifyPrefixedName("--", prop.name),
        cssType = cssPropertyType(
          prop.name,
          prop.description,
          elementDeclaration.tagName,
        ),
      )
    }

  def slots(elementDeclaration: M.Declaration): List[Def.Slot] =
    elementDeclaration.slots.map { slot =>
      val isDefault = slot.name == ""
      Def.Slot(
        description = descriptionLines(slot.description),
        domName = slot.name,
        scalaName = if isDefault then "default" else scalifyName(slot.name),
        isDefault = isDefault,
      )
    }

  // -- domain helpers...

  case class CssPropTypePattern(
    tagName: Option[String],
    propNameRegex: Regex,
    cssType: Def.CssType,
  )

  object CssPropTypePattern {

    def apply(propNameAndType: (String, Def.CssType)): CssPropTypePattern =
      CssPropTypePattern(None, propNameAndType._1.r, propNameAndType._2)

    def apply(
      tagName: String,
    )(propNameAndType: (String, Def.CssType)): CssPropTypePattern =
      CssPropTypePattern(
        Some(tagName),
        propNameAndType._1.r,
        propNameAndType._2,
      )
  }

  def CustomEventType(
    rawName: String,
  )(
    fields: (String, String)*,
  ): Def.CustomEventType =
    Def.CustomEventType(
      rawName = rawName,
      // 这里添加
      scalaName = rawName, // withoutPrefix("Sl", rawName),
      fields = fields.toList.map { case (domName, jsTypeStr) =>
        val jsTypes = parseJsTypes("", "", M.ValueType(jsTypeStr))
        val description =
          if jsTypes.exists(_.isInstanceOf[Def.JsStringConstantType]) then {
            List(jsTypeStr)
          } else Nil
        val context = s"event type `${rawName}`"
        Def.CustomEventTypeField(
          domName = domName,
          scalaName = scalifyName(domName),
          jsTypes = jsTypes,
          description = description,
        )
      },
    )

  def scalaAttrInputTypeStr(attr: Def.Attribute, tagName: String): String = {
    val printableTypes = attr.jsTypes.map {
      case Def.JsStringConstantType(_) => Def.JsStringType
      case other                       => other
    }.distinct.filter {
      case Def.JsUndefinedType => false
      case Def.JsCustomType("VirtualElement") =>
        false // I think it's always there together with `Element`?
      case _ => true
    }
    if printableTypes.isEmpty then {
      throw new Exception(
        s"ERROR: scalaAttrInputTypeStr: No printable types for attr `${attr.attrName}` in tag `${tagName}` (jsTypes = ${attr.jsTypes
            .mkString(", ")})",
      )
    } else if printableTypes.length == 1 then {
      printableTypes.head match {
        case Def.JsStringType  => "String"
        case Def.JsNumberType  => "Int" // #nc for now
        case Def.JsBooleanType => "Boolean"
        // case Def.JsCustomType("Element") => "elementProp" // #nc need custom codec
        // case Def.JsCustomType(c) => c
        case t =>
          println(
            s"WARNING: scalaAttrInputTypeStr: Unhandled js type `${t}` for attr `${attr.attrName}` in tag `${tagName}`.",
          )
          t.toString
      }
      // } else if (printableTypes == List(Def.JsCustomType("Element"), Def.JsCustomType("Element[]"))) {
      //  println(s"WARNING: scalaAttrInputType: Multi-element input not supported for attr `${attr.attrName}` in tag `${tagName}`.")
      //  "Element" // #nc or Element[], but how to express that...
    } else {
      if printableTypes.toSet == Set(Def.JsNumberType, Def.JsStringType) then {
        "Int" // #nc
      } else {
        throw new Exception(
          s"ERROR: scalaAttrInputTypeStr does not support multiple printable types in attr `${attr.attrName}` in tag `${tagName}`: ${printableTypes
              .mkString(", ")}",
        )
      }
    }
  }

  def scalaPropInputTypeStr(prop: Def.Field, tagName: String): String = {
    val printableTypes = prop.jsTypes.map {
      case Def.JsStringConstantType(_) => Def.JsStringType
      case Def.JsCustomType("string[]") =>
        Def.JsStringType // #nc temporary fix for mdui-select value
      case other => other
    }.distinct.filter {
      case Def.JsUndefinedType => false
      case Def.JsCustomType("VirtualElement") =>
        false // I think it's always there together with `Element`?
      case _ => true
    }
    if printableTypes.isEmpty then {
      throw new Exception(
        s"ERROR: scalaPropInputTypeStr: No printable types for prop `${prop.propName}` in tag `${tagName}` (jsTypes = ${prop.jsTypes
            .mkString(", ")})",
      )
    } else if printableTypes.length == 1 then {
      val converter = DataTypeConverter.jsTypeToScalaPartial.orElse { case t =>
        println(
          s"WARNING: scalaPropInputTypeStr: Unhandled js type `${t}` for prop `${prop.propName}` in tag `${tagName}`.",
        )
        t.toString
      }
      converter(printableTypes.head)
//      printableTypes.head match {
//        case Def.JsStringType                     => "String"
//        case Def.JsNumberType                     => "Int" // #nc for now
//        case Def.JsBooleanType                    => "Boolean"
//        case Def.JsCustomType("MutationObserver") => "dom.MutationObserver"
//        case Def.JsCustomType("Keyframe[]")       => "js.Array[js.Object]"
//        // case Def.JsCustomType("Element") => "elementProp" // #nc need custom codec
//        // case Def.JsCustomType(c) => c
//
//        // 这里添加
//        case Def.JsCustomType(i) if i.toIntOption.isDefined =>
//          "Int"
//        case Def.JsCustomType("number[]") =>
//          "js.Array[Double]"
//        case Def.JsCustomType("(value: number) => string") =>
//          "js.Function1[Double, String]"
//
//        case t =>
//          println(
//            s"WARNING: scalaPropInputTypeStr: Unhandled js type `${t}` for prop `${prop.propName}` in tag `${tagName}`.",
//          )
//          t.toString
//      }
      // } else if (printableTypes == List(Def.JsCustomType("Element"), Def.JsCustomType("Element[]"))) {
      //  println(s"WARNING: scalaAttrInputType: Multi-element input not supported for attr `${attr.attrName}` in tag `${tagName}`.")
      //  "Element" // #nc or Element[], but how to express that...
    } else if (
      // 这里添加支持多个会发生什么
      true
    ) {
      printableTypes
        .map(DataTypeConverter.jsTypeToScala)
        .map(
          _.getOrElse(
            throw new Exception(
              s"ERROR: scalaPropInputTypeStr does not support type in prop `${prop.propName}` in tag `${tagName}`: ${printableTypes
                  .mkString(", ")}",
            ),
          ),
        )
        .mkString(" | ")
    } else {

      throw new Exception(
        s"ERROR: scalaPropInputTypeStr does not support multiple printable types in prop `${prop.propName}` in tag `${tagName}`: ${printableTypes
            .mkString(", ")}",
      )
    }
  }

  def scalaPropOutputTypes(
    context: String,
    jsTypes: List[Def.JsType],
  ): List[String] = {
    val printableTypes = jsTypes.map {
      case Def.JsStringConstantType(_) => Def.JsStringType
      case Def.JsCustomType("string[]") =>
        Def.JsStringType // #nc temporary fix for mdui-select value
      case other => other
    }
      .map(scalaOutputType(context, _))
      .distinct
    if printableTypes.isEmpty then {
      throw new Exception(
        s"ERROR: scalaPropOutputTypeStr does not have any types to work with in ${context}: ${printableTypes
            .mkString(", ")}",
      )
    }
    printableTypes
  }

  def scalaPropOutputType(
    context: String,
    jsTypes: List[Def.JsType],
  ): String =
    scalaPropOutputTypes(context, jsTypes).mkString(" | ")
    // if (jsTypes.contains(Def.JsUndefinedType)) {
    //  jsTypes
    //    .filterNot(_ == Def.JsUndefinedType)
    //    .mkString("js.UndefOr[", " | ", "]")
    // } else {
    //  jsTypes.mkString(" | ")
    // }

  def scalaOutputType(context: String, jsType: Def.JsType): String =
    jsType match {
      case Def.JsUndefinedType =>
        "Unit" // yes, js.UndefOr[A] is equivalent to A | Unit. (the | is scala.scalajs.js.|, not the Scala 3 | )
      case Def.JsNumberType  => "Int" // #nc for now
      case Def.JsBooleanType => "Boolean"
      case Def.JsStringType  => "String"
      case Def.JsCustomType("Keyframe[]") =>
        "js.Array[js.Object]" // #nc not sure what the exact type should be
      case Def.JsCustomType("MutationObserver") => "dom.MutationObserver"
      case Def.JsCustomType("MutationRecord[]") =>
        "js.Array[dom.MutationRecord]"
      case Def.JsCustomType("ResizeObserverEntry[]") =>
        "js.Array[dom.ResizeObserverEntry]"
      case Def.JsCustomType(t) if t.startsWith("Sl") =>
        if t.endsWith("[]") then {
          "js.Array[" + t.substring(2, t.length - 2) + ".Ref]"
        } else {
          t.substring(2) + ".Ref"
        }

      // 这里添加
      case Def.JsCustomType("ValidityState") =>
        "org.scalajs.dom.ValidityState"
      case Def.JsCustomType(i) if i.toIntOption.isDefined =>
        "Int"
      case Def.JsCustomType("number[]") =>
        "js.Array[Double]"
      case Def.JsCustomType("(value: number) => string") =>
        "js.Function1[Double, String]"
      case Def.JsCustomType("HTMLElement") |
          Def.JsCustomType("JQ<HTMLElement>") =>
        "org.scalajs.dom.HTMLElement"
      case t =>
        throw new Exception(
          s"WARNING: scalaPropOutputTypeStr: Unhandled js type `${t}` for ${context}.",
        )
      // t.toString
    }

  // -- util helpers
  def parseJsTypes(
    tagName: String,
    propOrAttrName: String,
    value: M.ValueType,
  ): List[Def.JsType] = {
    val singleQuotedPattern = """^'([^']*)'$""".r
    val commentPattern      = """/\*.*?\*/""".r

    val clearText = commentPattern.replaceAllIn(value.text, "")
    val jsTypes = clearText.trim
      .split('|')
      .map(_.trim)
      .filter(_.nonEmpty)
      .map { str =>
        singleQuotedPattern
          .findFirstMatchIn(str)
          .map { m =>
            List(Def.JsStringConstantType(m.group(1)))
          }
          .orElse {
            stringConstantsCustomTypes
              .get(str)
              .map(_.map { const =>
                Def.JsStringConstantType(const)
              })
          }
          .getOrElse {
            str match {
              case "string"    => List(Def.JsStringType)
              case "boolean"   => List(Def.JsBooleanType)
              case "undefined" => List(Def.JsUndefinedType)
              case "number"    => List(Def.JsNumberType)
              case "CSSNumberish" =>
                List(
                  Def.JsNumberType,
                ) // #nc this is milliseconds, so it should be a double
              // 这里添加
              case number if number.toDoubleOption.isDefined =>
                List(Def.JsNumberType)
              case "JQ<HTMLElement>" =>
                List(Def.JsCustomType("HTMLElement"))
              case custom =>
                List(
                  Def.JsCustomType(custom),
                )
            }
          }
      }
      .toList
      .flatten

    fixTypes(tagName, propOrAttrName, jsTypes)
  }

  def withoutPrefix(prefix: String, str: String): String =
    if str.startsWith(prefix) then str.substring(prefix.length) else str

  /* remove prefix, convert the rest of kebab-case to camelCase (by default) or TitleCase */
  def scalifyPrefixedName(prefix: String, rawName: String): String = {
    val name = withoutPrefix(prefix = prefix, rawName)
    name
      .split("-")
      .zipWithIndex
      .map { case (word, ix) =>
        if ix > 0 then {
          word.capitalize
        } else {
          word
        }
      }
      .mkString("")
  }

  /* convert kebab-case to camelCase */
  def scalifyName(rawName: String): String = {
    val reservedScalaWords = List("lazy", "type")
    if reservedScalaWords.contains(rawName) then {
      s"`${rawName}`"
    } else {
      scalifyPrefixedName("", rawName)
    }
  }

  /**
   * Note: UI library might chose encode reflected attrs as props instead, which might have different names. Use this only for choosing canonical names.
   */
  private val allPossibleUiLibAttrs =
    uiLibAttrDefs ++ uiLibReflectedAttrDefs.map(_.toAttrDef)

  /** Returns main scala name, as well as aliases. */
  def scalifyAttrName(attrName: String): (String, List[String]) = {
    val maybeScalaAttrName = forceScalaAttrNames.collectFirst {
      case (domAttrName, scalaAttrName) if domAttrName == attrName =>
        (scalaAttrName, Nil)
    }
      .orElse(
        allPossibleUiLibAttrs
          .find(_.domName == attrName)
          .map { a =>
            val mainName = if a.scalaName.endsWith("Attr") then {
              a.scalaName.substring(0, a.scalaName.length - 4)
            } else {
              a.scalaName
            }
            (mainName, a.scalaAliases)
          },
      )
    maybeScalaAttrName.getOrElse(
      (scalifyName(attrName), Nil),
    )
  }

  def scalifyPropName(propName: String): String =
    scalifyName(propName)

  def scalifyEventPropName(eventName: String): String =
    "on" + scalifyPrefixedName("mdui-", eventName).capitalize

  def descriptionLines(description: String): List[String] =
    if description.isEmpty then {
      Nil
    } else {
      description.split("\n").toList
    }

  // --

  lazy val components: WebComponentsDef = WebComponentsDef(elements)
}

object WebComponentsTranslator {

  val Def: WebComponentsDef.type = WebComponentsDef
}
