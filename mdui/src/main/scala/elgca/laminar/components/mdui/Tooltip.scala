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
  * 工具提示组件
  * 
  * ```html
  * <mdui-tooltip content="tooltip content">
  * ..<mdui-button>button</mdui-button>
  * </mdui-tooltip>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Tooltip.scala Tooltip.scala source code]]
  */
object Tooltip extends WebComponent("mdui-tooltip") {

  @JSImport("mdui/components/tooltip.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Tooltip.type

  type Ref = TooltipComponent & dom.HTMLElement


  // -- Events --

  /** tooltip 开始显示时，事件被触发。可以通过调用 `event.preventDefault()` 阻止 tooltip 打开 */
  lazy val onOpen: EventProp[dom.Event] = eventProp("open")

  /** tooltip 显示动画完成时，事件被触发 */
  lazy val onOpened: EventProp[dom.Event] = eventProp("opened")

  /** tooltip 开始隐藏时，事件被触发。可以通过调用 `event.preventDefault()` 阻止 tooltip 关闭 */
  lazy val onClose: EventProp[dom.Event] = eventProp("close")

  /** tooltip 隐藏动画完成时，事件被触发 */
  lazy val onClosed: EventProp[dom.Event] = eventProp("closed")


  // -- Attributes --

  /**
    * tooltip 的形状。默认为 `plain`。可选值包括：
    * 
    * * `plain`：纯文本，适用于简单的单行文本
    * * `rich`：富文本，可以包含标题、正文和操作按钮
    */
  lazy val variant: CommonKeys.variant.type = CommonKeys.variant

  /**
    * tooltip 的位置。默认为 `auto`。可选值包括：
    * 
    * * `auto`：自动判断位置。`variant="plan"` 时，优先使用 `top`；`variant="rich"` 时，优先使用 `bottom-right`
    * * `top-left`：位于左上方
    * * `top-start`：位于上方，左对齐
    * * `top`：位于上方，居中对齐
    * * `top-end`：位于上方，右对齐
    * * `top-right`：位于右上方
    * * `bottom-left`：位于左下方
    * * `bottom-start`：位于下方，左对齐
    * * `bottom`：位于下方，居中对齐
    * * `bottom-end`：位于下方，右对齐
    * * `bottom-right`：位于右下方
    * * `left-start`：位于左侧，顶部对齐
    * * `left`：位于左侧，居中对齐
    * * `left-end`：位于左侧，底部对齐
    * * `right-start`：位于右侧，顶部对齐
    * * `right`：位于右侧，居中对齐
    * * `right-end`：位于右侧，底部对齐
    */
  lazy val placement: CommonKeys.placement.type = CommonKeys.placement

  /** 鼠标悬浮触发显示的延时，单位为毫秒 */
  lazy val openDelay: HtmlAttr[Int] = intAttr("open-delay")

  /** 鼠标悬浮触发隐藏的延时，单位为毫秒 */
  lazy val closeDelay: HtmlAttr[Int] = intAttr("close-delay")

  /** tooltip 的标题。仅 `variant="rich"` 时可使用。也可以通过 `slot="headline"` 设置 */
  lazy val headline: HtmlAttr[String] = stringAttr("headline")

  /** tooltip 的内容。也可以通过 `slot="content"` 设置 */
  lazy val content: HtmlAttr[String] = stringAttr("content")

  /**
    * 触发方式，支持多个值，用空格分隔。可选值包括：
    * 
    * * `click`：点击时触发
    * * `hover`：鼠标悬浮时触发
    * * `focus`：聚焦时触发
    * * `manual`：只能通过编程方式打开和关闭 tooltip，不能再指定其他触发方式
    */
  lazy val trigger: HtmlAttr[String] = stringAttr("trigger")

  /** 是否禁用 tooltip */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /** 是否显示 tooltip */
  lazy val open: HtmlAttr[Boolean] = boolAttr("open")


  // -- Props --


  // -- Slots --

  object slots {

    /** tooltip 触发的目标元素，只有 `default` slot 中的第一个元素会作为目标元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** tooltip 的标题，只有当 `variant="rich"` 时，此 slot 才有效 */
    lazy val headline: Slot = Slot("headline")

    /** tooltip 的内容，可以包含 HTML。若只包含纯文本，可以使用 `content` 属性代替 */
    lazy val content: Slot = Slot("content")

    /** tooltip 底部的按钮，只有当 `variant="rich"` 时，此 slot 才有效 */
    lazy val action: Slot = Slot("action")
  }


  // -- CSS Vars --

  /** 当 variant="plain" 时，组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCornerPlain: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner-plain")

  /** 当 variant="rich" 时，组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCornerRich: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner-rich")

  /** 组件的 CSS `z-index` 值 */
  lazy val zIndex: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--z-index")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** tooltip 的容器 */
    lazy val popup: String = "popup"

    /** 标题 */
    lazy val headline: String = "headline"

    /** 正文 */
    lazy val content: String = "content"

    /** 操作按钮 */
    lazy val action: String = "action"
  }


  // -- Element type -- 

  @js.native trait TooltipComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * tooltip 的形状。默认为 `plain`。可选值包括：
      * 
      * * `plain`：纯文本，适用于简单的单行文本
      * * `rich`：富文本，可以包含标题、正文和操作按钮
      */
    var variant: String

    /**
      * tooltip 的位置。默认为 `auto`。可选值包括：
      * 
      * * `auto`：自动判断位置。`variant="plan"` 时，优先使用 `top`；`variant="rich"` 时，优先使用 `bottom-right`
      * * `top-left`：位于左上方
      * * `top-start`：位于上方，左对齐
      * * `top`：位于上方，居中对齐
      * * `top-end`：位于上方，右对齐
      * * `top-right`：位于右上方
      * * `bottom-left`：位于左下方
      * * `bottom-start`：位于下方，左对齐
      * * `bottom`：位于下方，居中对齐
      * * `bottom-end`：位于下方，右对齐
      * * `bottom-right`：位于右下方
      * * `left-start`：位于左侧，顶部对齐
      * * `left`：位于左侧，居中对齐
      * * `left-end`：位于左侧，底部对齐
      * * `right-start`：位于右侧，顶部对齐
      * * `right`：位于右侧，居中对齐
      * * `right-end`：位于右侧，底部对齐
      */
    var placement: String

    /** 鼠标悬浮触发显示的延时，单位为毫秒 */
    var openDelay: Int

    /** 鼠标悬浮触发隐藏的延时，单位为毫秒 */
    var closeDelay: Int

    /** tooltip 的标题。仅 `variant="rich"` 时可使用。也可以通过 `slot="headline"` 设置 */
    var headline: String | Unit

    /** tooltip 的内容。也可以通过 `slot="content"` 设置 */
    var content: String | Unit

    /**
      * 触发方式，支持多个值，用空格分隔。可选值包括：
      * 
      * * `click`：点击时触发
      * * `hover`：鼠标悬浮时触发
      * * `focus`：聚焦时触发
      * * `manual`：只能通过编程方式打开和关闭 tooltip，不能再指定其他触发方式
      */
    var trigger: String

    /** 是否禁用 tooltip */
    var disabled: Boolean

    /** 是否显示 tooltip */
    var open: Boolean
  }
}
