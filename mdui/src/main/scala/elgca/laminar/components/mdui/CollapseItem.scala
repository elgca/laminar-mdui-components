package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 折叠面板项组件，需配合 `<mdui-collapse>` 组件使用
  * 
  * ```html
  * <mdui-collapse>
  * ..<mdui-collapse-item header="header-1">content-1</mdui-collapse-item>
  * ..<mdui-collapse-item header="header-2">content-2</mdui-collapse-item>
  * </mdui-collapse>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/CollapseItem.scala CollapseItem.scala source code]]
  */
object CollapseItem extends WebComponent("mdui-collapse-item") {

  @JSImport("mdui/components/collapse-item/collapse-item.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = CollapseItem.type

  type Ref = CollapseItemComponent & dom.HTMLElement


  // -- Events --

  /** 开始打开时，事件被触发 */
  lazy val onOpen: EventProp[dom.Event] = eventProp("open")

  /** 打开动画完成时，事件被触发 */
  lazy val onOpened: EventProp[dom.Event] = eventProp("opened")

  /** 开始关闭时，事件被触发 */
  lazy val onClose: EventProp[dom.Event] = eventProp("close")

  /** 关闭动画完成时，事件被触发 */
  lazy val onClosed: EventProp[dom.Event] = eventProp("closed")


  // -- Attributes --

  /** 此折叠面板项的值 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /** 此折叠面板项的头部文本 */
  lazy val header: HtmlAttr[String] = stringAttr("header")

  /** 是否禁用此折叠面板项 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")


  // -- Props --

  /** 此折叠面板项的值 */
  lazy val value: HtmlProp[String, ?] = stringProp("value")

  /** 点击该元素时触发折叠，值可以是 CSS 选择器、DOM 元素、或 [JQ 对象](/docs/2/functions/jq)。默认为点击整个 header 区域触发 */
  lazy val trigger: HtmlProp[String | org.scalajs.dom.HTMLElement, ?] = asIsProp("trigger")


  // -- Slots --

  object slots {

    /** 折叠面板项的正文内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 折叠面板项的头部内容 */
    lazy val header: Slot = Slot("header")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 折叠面板的头部内容 */
    lazy val header: String = "header"

    /** 折叠面板的正文内容 */
    lazy val body: String = "body"
  }


  // -- Element type -- 

  @js.native trait CollapseItemComponent extends js.Object { this: dom.HTMLElement => 

    /** 此折叠面板项的值 */
    var value: String | Unit

    /** 此折叠面板项的头部文本 */
    var header: String | Unit

    /** 是否禁用此折叠面板项 */
    var disabled: Boolean

    /** 点击该元素时触发折叠，值可以是 CSS 选择器、DOM 元素、或 [JQ 对象](/docs/2/functions/jq)。默认为点击整个 header 区域触发 */
    var trigger: String | org.scalajs.dom.HTMLElement | Unit
  }
}
