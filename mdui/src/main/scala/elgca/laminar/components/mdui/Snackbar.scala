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
  * 消息条组件
  * 
  * ```html
  * <mdui-snackbar>message</mdui-snackbar>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Snackbar.scala Snackbar.scala source code]]
  */
object Snackbar extends WebComponent("mdui-snackbar") {

  @JSImport("mdui/components/snackbar/snackbar.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Snackbar.type

  type Ref = SnackbarComponent & dom.HTMLElement


  // -- Events --

  /** Snackbar 开始显示时，事件被触发。可以通过调用 `event.preventDefault()` 阻止 Snackbar 显示 */
  lazy val onOpen: EventProp[dom.Event] = eventProp("open")

  /** Snackbar 显示动画完成时，事件被触发 */
  lazy val onOpened: EventProp[dom.Event] = eventProp("opened")

  /** Snackbar 开始隐藏时，事件被触发。可以通过调用 `event.preventDefault()` 阻止 Snackbar 关闭 */
  lazy val onClose: EventProp[dom.Event] = eventProp("close")

  /** Snackbar 隐藏动画完成时，事件被触发 */
  lazy val onClosed: EventProp[dom.Event] = eventProp("closed")

  /** 点击操作按钮时触发 */
  lazy val onActionClick: EventProp[dom.Event] = eventProp("action-click")


  // -- Attributes --

  /** 是否显示 Snackbar */
  lazy val open: HtmlAttr[Boolean] = boolAttr("open")

  /**
    * Snackbar 的显示位置。默认为 `bottom`。可选值包括：
    * 
    * * `top`：顶部居中
    * * `top-start`：顶部左对齐
    * * `top-end`：顶部右对齐
    * * `bottom`：底部居中
    * * `bottom-start`：底部左对齐
    * * `bottom-end`：底部右对齐
    */
  lazy val placement: CommonKeys.placement.type = CommonKeys.placement

  /** 操作按钮的文本。也可以通过 `slot="action"` 设置操作按钮 */
  lazy val action: HtmlAttr[String] = stringAttr("action")

  /** 操作按钮是否处于加载中状态 */
  lazy val actionLoading: HtmlAttr[Boolean] = boolAttr("action-loading")

  /** 是否在右侧显示关闭按钮 */
  lazy val closeable: HtmlAttr[Boolean] = boolAttr("closeable")

  /** 关闭按钮的 Material Icons 图标名。也可以通过 `slot="close-icon"` 设置 */
  lazy val closeIcon: HtmlAttr[String] = stringAttr("close-icon")

  /**
    * 消息文本的最大显示行数。默认不限制。可选值包括：
    * 
    * * `1`：最多显示一行
    * * `2`：最多显示两行
    */
  lazy val messageLine: HtmlAttr[Int] = intAttr("message-line")

  /** 自动关闭的延迟时间（单位：毫秒）。设置为 `0` 则不自动关闭。默认为 5000 毫秒 */
  lazy val autoCloseDelay: HtmlAttr[Int] = intAttr("auto-close-delay")

  /** 点击或触摸 Snackbar 以外的区域时，是否关闭 Snackbar */
  lazy val closeOnOutsideClick: HtmlAttr[Boolean] = boolAttr("close-on-outside-click")


  // -- Props --


  // -- Slots --

  object slots {

    /** Snackbar 的消息文本内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 右侧的操作按钮 */
    lazy val action: Slot = Slot("action")

    /** 右侧的关闭按钮。必须设置 `closeable` 属性为 `true` 才会显示 */
    lazy val closeButton: Slot = Slot("close-button")

    /** 关闭按钮中的图标 */
    lazy val closeIcon: Slot = Slot("close-icon")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")

  /** 组件的 CSS `z-index` 值 */
  lazy val zIndex: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--z-index")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 消息文本 */
    lazy val message: String = "message"

    /** 操作按钮 */
    lazy val action: String = "action"

    /** 关闭按钮 */
    lazy val closeButton: String = "close-button"

    /** 关闭按钮中的图标 */
    lazy val closeIcon: String = "close-icon"
  }


  // -- Element type -- 

  @js.native trait SnackbarComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否显示 Snackbar */
    var open: Boolean

    /**
      * Snackbar 的显示位置。默认为 `bottom`。可选值包括：
      * 
      * * `top`：顶部居中
      * * `top-start`：顶部左对齐
      * * `top-end`：顶部右对齐
      * * `bottom`：底部居中
      * * `bottom-start`：底部左对齐
      * * `bottom-end`：底部右对齐
      */
    var placement: String

    /** 操作按钮的文本。也可以通过 `slot="action"` 设置操作按钮 */
    var action: String | Unit

    /** 操作按钮是否处于加载中状态 */
    var actionLoading: Boolean

    /** 是否在右侧显示关闭按钮 */
    var closeable: Boolean

    /** 关闭按钮的 Material Icons 图标名。也可以通过 `slot="close-icon"` 设置 */
    var closeIcon: String | Unit

    /**
      * 消息文本的最大显示行数。默认不限制。可选值包括：
      * 
      * * `1`：最多显示一行
      * * `2`：最多显示两行
      */
    var messageLine: Int | Unit

    /** 自动关闭的延迟时间（单位：毫秒）。设置为 `0` 则不自动关闭。默认为 5000 毫秒 */
    var autoCloseDelay: Int

    /** 点击或触摸 Snackbar 以外的区域时，是否关闭 Snackbar */
    var closeOnOutsideClick: Boolean
  }
}
