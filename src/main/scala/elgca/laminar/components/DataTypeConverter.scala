package elgca.laminar.components

object DataTypeConverter {
  val Def: WebComponentsDef.type = WebComponentsDef

  val jsTypeToScalaPartial: PartialFunction[Def.JsType, String] = {
    case Def.JsStringType                     => "String"
    case Def.JsNumberType                     => "Int" // #nc for now
    case Def.JsBooleanType                    => "Boolean"
    case Def.JsCustomType("MutationObserver") => "dom.MutationObserver"
    case Def.JsCustomType("Keyframe[]")       => "js.Array[js.Object]"

    // 这里添加
    case Def.JsCustomType(i) if i.toIntOption.isDefined =>
      "Int"
    case Def.JsCustomType("number[]") =>
      "js.Array[Double]"
    case Def.JsCustomType("(value: number) => string") =>
      "js.Function1[Double, String]"
    case Def.JsCustomType("HTMLElement") =>
      "org.scalajs.dom.HTMLElement"
  }

  inline def jsTypeToScala(jsType: Def.JsType): Option[String] = {
    jsTypeToScalaPartial.lift.apply(jsType)
  }
}
