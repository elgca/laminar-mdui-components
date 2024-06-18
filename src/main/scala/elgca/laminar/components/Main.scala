package elgca.laminar.components

case class Config(
  frameworkName: String,
  onlineSourceRoot: String,
  customElementsJsonPath: String,
  baseOutputDirectoryPath: String,
  baseOutputPackagePath: String,
  jsImportBasePath: String,
)

@main def start(): Unit = {

  val config = Config(
    frameworkName = "MDUI",
    onlineSourceRoot = "mdui/src/main/scala",
    customElementsJsonPath = "node_modules/mdui/custom-elements.json",
//    customElementsJsonPath = "custom-elements.json",
    baseOutputDirectoryPath =
      "mdui/src/main/scala/elgca/laminar/components/mdui",
    baseOutputPackagePath = "elgca.laminar.components.mdui",
    jsImportBasePath = "mdui/components",
  )
  WebComponentsGenerator(config).generate()
}
