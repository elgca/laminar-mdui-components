package elgca.laminar.components

case class Config(
  onlineSourceRoot: String,
  customElementsJsonPath: String,
  baseOutputDirectoryPath: String,
  baseOutputPackagePath: String,
)

@main def start(): Unit = {

  val config = Config(
    onlineSourceRoot =
      "https://github.com/raquo/laminar-shoelace-components/blob/master",
    customElementsJsonPath = "node_modules/mdui/custom-elements.json",
//    customElementsJsonPath = "custom-elements.json",
    baseOutputDirectoryPath =
      "sample/src/main/scala/elgca/laminar/components/mdui",
    baseOutputPackagePath = "elgca.laminar.components.mdui",
  )
  WebComponentsGenerator(config).generate()
}
