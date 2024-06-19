package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 徽标组件
  * 
  * ```html
  * <mdui-badge>12</mdui-badge>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Badge.scala Badge.scala source code]]
  */
object Badge extends WebComponent("mdui-badge") {

  @JSImport("mdui/components/badge.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Badge.type

  type Ref = BadgeComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /**
    * 徽标的形状。可选值包括：
    * 
    * * `small`：小型徽标，不显示文本
    * * `large`：大型徽标，会显示文本
    */
  lazy val variant: CommonKeys.variant.type = CommonKeys.variant

  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object variant extends HtmlAttr[String]("variant", StringAsIsCodec) {

      lazy val small: HtmlAttrSetter[String] = variant("small")

      lazy val large: HtmlAttrSetter[String] = variant("large")
    }
  }


  // -- Props --


  // -- Slots --

  object slots {

    /** 徽标中显示的文本 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait BadgeComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 徽标的形状。可选值包括：
      * 
      * * `small`：小型徽标，不显示文本
      * * `large`：大型徽标，会显示文本
      */
    var variant: String
  }
}
