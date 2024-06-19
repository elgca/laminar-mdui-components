package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 布局项组件
  * 
  * ```html
  * <mdui-layout>
  * ..<mdui-layout-item></mdui-layout-item>
  * ..<mdui-layout-item></mdui-layout-item>
  * ..<mdui-layout-main></mdui-layout-main>
  * </mdui-layout>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/LayoutItem.scala LayoutItem.scala source code]]
  */
object LayoutItem extends WebComponent("mdui-layout-item") {

  @JSImport("mdui/components/layout-item.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = LayoutItem.type

  type Ref = LayoutItemComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /**
    * 组件的位置。可选值包括：
    * 
    * * `top`：上方
    * * `bottom`：下方
    * * `left`：左侧
    * * `right`：右侧
    */
  lazy val placement: CommonKeys.placement.type = CommonKeys.placement

  /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
  lazy val order: HtmlAttr[Int] = intAttr("order")

  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object placement extends HtmlAttr[String]("placement", StringAsIsCodec) {

      lazy val top: HtmlAttrSetter[String] = autoCapitalize("top")

      lazy val bottom: HtmlAttrSetter[String] = autoCapitalize("bottom")

      lazy val left: HtmlAttrSetter[String] = autoCapitalize("left")

      lazy val right: HtmlAttrSetter[String] = autoCapitalize("right")
    }
  }


  // -- Props --


  // -- Slots --

  object slots {

    /** 可以包含任意内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait LayoutItemComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 组件的位置。可选值包括：
      * 
      * * `top`：上方
      * * `bottom`：下方
      * * `left`：左侧
      * * `right`：右侧
      */
    var placement: String

    /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
    var order: Int | Unit
  }
}
