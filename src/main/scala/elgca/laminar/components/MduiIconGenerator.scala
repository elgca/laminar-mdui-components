package elgca.laminar.components

import com.raquo.domtypes.codegen.CodeFormatting
import com.raquo.domtypes.codegen.generators.SourceGenerator

import java.io.{File, FileOutputStream, PrintStream}
import scala.collection.mutable

/**
 * for MDUI-ICON
 */
class MduiIconGenerator(
  val config: Config,
  val forceScalaName: PartialFunction[String, String] = PartialFunction.empty,
  val format: CodeFormatting = CodeFormatting(),
) extends SourceGenerator(format) {
  val npmPath = "node_modules"

  /** Overwrite this with directory name if you ant to output components in a subdirectory */
  lazy val componentsPackageName: String = ""

  lazy val componentsPackagePath: String = List(
    config.baseOutputPackagePath,
    componentsPackageName,
  ).filter(_.nonEmpty).mkString(".")

  def generate(): Unit = {
    val basePath =
      if (config.jsImportBasePath.endsWith("/"))
        config.jsImportBasePath.dropRight(1)
      else config.jsImportBasePath
    val iconPath = new File(npmPath, basePath)

    val iconJs = iconPath
      .listFiles()
      .filter(x => x.getName.endsWith(".js"))
      .map(x => {
        val tagName    = "mdui-icon-" + x.getName.dropRight(".js".length)
        val importPath = npmPath + "/" + x.getName
        val scalaName  = scalifyName("mdui-icon-", tagName)
        // (tagName, scalaName, jsPath)
        (tagName, scalaName, importPath)
      })
    // check valid
    val validIcons = iconJs
      .groupBy(_._2)
      .filter(_._2.length > 1)
    if (validIcons.nonEmpty) {
      validIcons.foreach { case (name, tags) =>
        println(s"ScalaName:${name}")
        tags.foreach { case (tagName, scalaName, importPath) =>
          println(s"> ${tagName}  ${scalaName}  import from ${importPath}")
        }
      }
      throw new Exception("Duplicate ScalaName, please Change scalifyName")
    }

    //      .map(x => x.)
    iconJs.foreach { case (tagName, scalaName, importPath) =>
      println((tagName, scalaName, importPath))
      printIcon(tagName, scalaName, importPath)
      val fileName = s"${scalaName}.scala"
      val output   = getOutput()
      writeToFile(
        packagePath = componentsPackagePath,
        fileName = fileName,
        fileContent = output,
      )
    }
  }

  def printIcon(tagName: String, scalaName: String, jsPath: String): Unit = {
    line(s"package ${componentsPackagePath}")
    line(s"package icon")
    line()
    line("import com.raquo.laminar.api.L")
//    line("import com.raquo.laminar.tags.CustomHtmlTag")
    line("import org.scalajs.dom")
    line()
    line("import scala.scalajs.js")
    line("import scala.scalajs.js.annotation.JSImport")
    line()
    line(
      s"// This file is generated at by ${codeFileName}",
    )
    line()
    enter(
      s"object ${scalaName} extends WebComponent(${repr(tagName)}) {",
      "}",
    ) {
      printComponentRawImport(jsPath)
      val componentTraitName = scalaName + "Component"
      val elementBaseType    = "dom.HTMLElement"
      val showRawComponent   = false
      printRefType(
        scalaName,
        componentTraitName,
        showRawComponent,
        elementBaseType,
      )
    }
  }

  def printComponentRawImport(importPath: String): Unit = {
    line()
    line(s"@JSImport(${repr(importPath)}, JSImport.Namespace)")
    line("@js.native object RawImport extends js.Object")
  }

  def printRefType(
    componentObjectName: String,
    componentTraitName: String,
    showRawComponent: Boolean,
    elementBaseType: String,
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

  def scalifyName(prefix: String, rawName: String): String = {
    forceScalaName.applyOrElse(
      rawName,
      _ => {
        val name =
          if (rawName.startsWith(prefix)) rawName.drop(prefix.length)
          else rawName
        "Icon" + name
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
      },
    )
  }

  def writeToFile(
    packagePath: String,
    fileName: String,
    fileContent: String,
  ): File = {
    val filePath =
      config.baseOutputDirectoryPath + "/icon" + "/" + (packagePath + ".")
        .replace(config.baseOutputPackagePath + ".", "")
        .replace(".", "/") + fileName.replaceAll(".scala$", "") + ".scala"
    val outputFile = new File(filePath)
    outputFile.getParentFile.mkdirs()

    val fileOutputStream  = new FileOutputStream(outputFile)
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
