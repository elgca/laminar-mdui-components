package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 下拉组件
  * 
  * ```html
  * <mdui-dropdown>
  * ..<mdui-button slot="trigger">open dropdown</mdui-button>
  * ..<mdui-menu>
  * ....<mdui-menu-item>Item 1</mdui-menu-item>
  * ....<mdui-menu-item>Item 2</mdui-menu-item>
  * ..</mdui-menu>
  * </mdui-dropdown>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Dropdown.scala Dropdown.scala source code]]
  */
object Dropdown extends WebComponent("mdui-dropdown") {

  @JSImport("mdui/components/dropdown.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Dropdown.type

  type Ref = DropdownComponent & dom.HTMLElement


  // -- Events --

  /** 下拉组件开始打开时，事件被触发。可以通过调用 `event.preventDefault()` 阻止下拉组件打开 */
  lazy val onOpen: EventProp[dom.Event] = eventProp("open")

  /** 下拉组件打开动画完成时，事件被触发 */
  lazy val onOpened: EventProp[dom.Event] = eventProp("opened")

  /** 下拉组件开始关闭时，事件被触发。可以通过调用 `event.preventDefault()` 阻止下拉组件关闭 */
  lazy val onClose: EventProp[dom.Event] = eventProp("close")

  /** 下拉组件关闭动画完成时，事件被触发 */
  lazy val onClosed: EventProp[dom.Event] = eventProp("closed")


  // -- Attributes --

  /** 是否打开下拉组件 */
  lazy val open: HtmlAttr[Boolean] = boolAttr("open")

  /** 是否禁用下拉组件 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /**
    * 下拉组件的触发方式，支持多个值，用空格分隔。可选值包括：
    * 
    * * `click`：点击触发
    * * `hover`：鼠标悬浮触发
    * * `focus`：聚焦触发
    * * `contextmenu`：鼠标右键点击、或触摸长按触发
    * * `manual`：仅能通过编程方式打开和关闭下拉组件，不能再指定其他触发方式
    */
  lazy val trigger: HtmlAttr[String] = stringAttr("trigger")

  /**
    * 下拉组件内容的位置。可选值包括：
    * 
    * * `auto`：自动判断位置
    * * `top-start`：上方左对齐
    * * `top`：上方居中
    * * `top-end`：上方右对齐
    * * `bottom-start`：下方左对齐
    * * `bottom`：下方居中
    * * `bottom-end`：下方右对齐
    * * `left-start`：左侧顶部对齐
    * * `left`：左侧居中
    * * `left-end`：左侧底部对齐
    * * `right-start`：右侧顶部对齐
    * * `right`：右侧居中
    * * `right-end`：右侧底部对齐
    */
  lazy val placement: CommonKeys.placement.type = CommonKeys.placement

  /** 点击 [`<mdui-menu-item>`](/docs/2/components/menu#menu-item-api) 后，下拉组件是否保持打开状态 */
  lazy val stayOpenOnClick: HtmlAttr[Boolean] = boolAttr("stay-open-on-click")

  /** 鼠标悬浮触发下拉组件打开的延时，单位为毫秒 */
  lazy val openDelay: HtmlAttr[Int] = intAttr("open-delay")

  /** 鼠标悬浮触发下拉组件关闭的延时，单位为毫秒 */
  lazy val closeDelay: HtmlAttr[Int] = intAttr("close-delay")

  /** 是否在触发下拉组件的光标位置打开下拉组件，常用于打开鼠标右键菜单 */
  lazy val openOnPointer: HtmlAttr[Boolean] = boolAttr("open-on-pointer")
  // -- CommonKeys --
  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object placement extends HtmlAttr[String]("placement", StringAsIsCodec) {

      lazy val auto: HtmlAttrSetter[String] = placement("auto")

      lazy val topStart: HtmlAttrSetter[String] = placement("top-start")

      lazy val top: HtmlAttrSetter[String] = placement("top")

      lazy val topEnd: HtmlAttrSetter[String] = placement("top-end")

      lazy val bottomStart: HtmlAttrSetter[String] = placement("bottom-start")

      lazy val bottom: HtmlAttrSetter[String] = placement("bottom")

      lazy val bottomEnd: HtmlAttrSetter[String] = placement("bottom-end")

      lazy val leftStart: HtmlAttrSetter[String] = placement("left-start")

      lazy val left: HtmlAttrSetter[String] = placement("left")

      lazy val leftEnd: HtmlAttrSetter[String] = placement("left-end")

      lazy val rightStart: HtmlAttrSetter[String] = placement("right-start")

      lazy val right: HtmlAttrSetter[String] = placement("right")

      lazy val rightEnd: HtmlAttrSetter[String] = placement("right-end")
    }
  }


  // -- Props --


  // -- Slots --

  object slots {

    /** 下拉组件的内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 触发下拉组件的元素，例如 [`<mdui-button>`](/docs/2/components/button) 元素 */
    lazy val trigger: Slot = Slot("trigger")
  }


  // -- CSS Vars --

  /** 组件的 CSS `z-index` 值 */
  lazy val zIndex: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--z-index")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 触发下拉组件的元素的容器，即 `trigger` slot 的容器 */
    lazy val trigger: String = "trigger"

    /** 下拉组件内容的容器 */
    lazy val panel: String = "panel"
  }


  // -- Element type -- 

  @js.native trait DropdownComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否打开下拉组件 */
    var open: Boolean

    /** 是否禁用下拉组件 */
    var disabled: Boolean

    /**
      * 下拉组件的触发方式，支持多个值，用空格分隔。可选值包括：
      * 
      * * `click`：点击触发
      * * `hover`：鼠标悬浮触发
      * * `focus`：聚焦触发
      * * `contextmenu`：鼠标右键点击、或触摸长按触发
      * * `manual`：仅能通过编程方式打开和关闭下拉组件，不能再指定其他触发方式
      */
    var trigger: String

    /**
      * 下拉组件内容的位置。可选值包括：
      * 
      * * `auto`：自动判断位置
      * * `top-start`：上方左对齐
      * * `top`：上方居中
      * * `top-end`：上方右对齐
      * * `bottom-start`：下方左对齐
      * * `bottom`：下方居中
      * * `bottom-end`：下方右对齐
      * * `left-start`：左侧顶部对齐
      * * `left`：左侧居中
      * * `left-end`：左侧底部对齐
      * * `right-start`：右侧顶部对齐
      * * `right`：右侧居中
      * * `right-end`：右侧底部对齐
      */
    var placement: String

    /** 点击 [`<mdui-menu-item>`](/docs/2/components/menu#menu-item-api) 后，下拉组件是否保持打开状态 */
    var stayOpenOnClick: Boolean

    /** 鼠标悬浮触发下拉组件打开的延时，单位为毫秒 */
    var openDelay: Int

    /** 鼠标悬浮触发下拉组件关闭的延时，单位为毫秒 */
    var closeDelay: Int

    /** 是否在触发下拉组件的光标位置打开下拉组件，常用于打开鼠标右键菜单 */
    var openOnPointer: Boolean
  }
}
