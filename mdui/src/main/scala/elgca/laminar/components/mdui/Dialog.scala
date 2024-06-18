package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by ShoelaceGenerator.scala

/**
  * 对话框组件
  * 
  * ```html
  * <mdui-dialog>content</mdui-dialog>
  * ```
  * 
  * [[https://github.com/raquo/laminar-shoelace-components/blob/master/sample/src/main/scala/elgca/laminar/components/mdui/Dialog.scala Dialog.scala source code]]
  */
object Dialog extends WebComponent("mdui-dialog") {

  @JSImport("@shoelace-style/shoelace/dist/components/dialog/dialog.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Dialog.type

  type Ref = DialogComponent & dom.HTMLElement


  // -- Events --

  /** 对话框开始打开时触发。可以通过调用 `event.preventDefault()` 阻止对话框打开 */
  lazy val onOpen: EventProp[dom.Event] = eventProp("open")

  /** 对话框打开动画完成后触发 */
  lazy val onOpened: EventProp[dom.Event] = eventProp("opened")

  /** 对话框开始关闭时触发。可以通过调用 `event.preventDefault()` 阻止对话框关闭 */
  lazy val onClose: EventProp[dom.Event] = eventProp("close")

  /** 对话框关闭动画完成后触发 */
  lazy val onClosed: EventProp[dom.Event] = eventProp("closed")

  /** 点击遮罩层时触发 */
  lazy val onOverlayClick: EventProp[dom.Event] = eventProp("overlay-click")


  // -- Attributes --

  /** 顶部的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
  lazy val icon: HtmlAttr[String] = stringAttr("icon")

  /** 标题。也可以通过 `slot="headline"` 设置 */
  lazy val headline: HtmlAttr[String] = stringAttr("headline")

  /** 标题下方的文本。也可以通过 `slot="description"` 设置 */
  lazy val description: HtmlAttr[String] = stringAttr("description")

  /** 是否打开对话框 */
  lazy val open: HtmlAttr[Boolean] = boolAttr("open")

  /** 是否全屏显示对话框 */
  lazy val fullscreen: HtmlAttr[Boolean] = boolAttr("fullscreen")

  /** 是否允许按下 ESC 键关闭对话框 */
  lazy val closeOnEsc: HtmlAttr[Boolean] = boolAttr("close-on-esc")

  /** 是否允许点击遮罩层关闭对话框 */
  lazy val closeOnOverlayClick: HtmlAttr[Boolean] = boolAttr("close-on-overlay-click")

  /** 是否垂直排列底部操作按钮 */
  lazy val stackedActions: HtmlAttr[Boolean] = boolAttr("stacked-actions")


  // -- Props --


  // -- Slots --

  object slots {

    /** 顶部元素，默认包含 `icon` slot 和 `headline` slot */
    lazy val header: Slot = Slot("header")

    /** 顶部图标 */
    lazy val icon: Slot = Slot("icon")

    /** 顶部标题 */
    lazy val headline: Slot = Slot("headline")

    /** 标题下方的文本 */
    lazy val description: Slot = Slot("description")

    /** 对话框主体内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 底部操作栏中的元素 */
    lazy val action: Slot = Slot("action")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")

  /** 组件的 CSS `z-index` 值 */
  lazy val zIndex: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--z-index")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 遮罩层 */
    lazy val overlay: String = "overlay"

    /** 对话框容器 */
    lazy val panel: String = "panel"

    /** 对话框 header 部分，包含 icon 和 headline */
    lazy val header: String = "header"

    /** 顶部图标，位于 header 中 */
    lazy val icon: String = "icon"

    /** 顶部标题，位于 header 中 */
    lazy val headline: String = "headline"

    /** 对话框 body 部分 */
    lazy val body: String = "body"

    /** 副文本部分，位于 body 中 */
    lazy val description: String = "description"

    /** 底部操作按钮 */
    lazy val action: String = "action"
  }


  // -- Element type -- 

  @js.native trait DialogComponent extends js.Object { this: dom.HTMLElement => 

    /** 顶部的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
    var icon: String | Unit

    /** 标题。也可以通过 `slot="headline"` 设置 */
    var headline: String | Unit

    /** 标题下方的文本。也可以通过 `slot="description"` 设置 */
    var description: String | Unit

    /** 是否打开对话框 */
    var open: Boolean

    /** 是否全屏显示对话框 */
    var fullscreen: Boolean

    /** 是否允许按下 ESC 键关闭对话框 */
    var closeOnEsc: Boolean

    /** 是否允许点击遮罩层关闭对话框 */
    var closeOnOverlayClick: Boolean

    /** 是否垂直排列底部操作按钮 */
    var stackedActions: Boolean
  }
}
