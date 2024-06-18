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
  * 在手机端，`modal` 始终为 `true`；大于手机端时，`modal` 属性才开始生效
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/NavigationDrawer.scala NavigationDrawer.scala source code]]
  */
object NavigationDrawer extends WebComponent("mdui-navigation-drawer") {

  @JSImport("mdui/components/navigation-drawer/navigation-drawer.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = NavigationDrawer.type

  type Ref = NavigationDrawerComponent & dom.HTMLElement


  // -- Events --

  /** 抽屉栏打开之前触发。可以通过调用 `event.preventDefault()` 阻止抽屉栏打开 */
  lazy val onOpen: EventProp[dom.Event] = eventProp("open")

  /** 抽屉栏打开动画完成之后触发 */
  lazy val onOpened: EventProp[dom.Event] = eventProp("opened")

  /** 抽屉栏关闭之前触发。可以通过调用 `event.preventDefault()` 阻止抽屉栏关闭 */
  lazy val onClose: EventProp[dom.Event] = eventProp("close")

  /** 抽屉栏关闭动画完成之后触发 */
  lazy val onClosed: EventProp[dom.Event] = eventProp("closed")

  /** 点击遮罩层时触发 */
  lazy val onOverlayClick: EventProp[dom.Event] = eventProp("overlay-click")


  // -- Attributes --

  /** 是否打开抽屉栏 */
  lazy val open: HtmlAttr[Boolean] = boolAttr("open")

  /**
    * 抽屉栏打开时，是否显示遮罩层
    * 
    * 在窄屏设备上（屏幕宽度小于 [`--mdui-breakpoint-md`](/docs/2/styles/design-tokens#breakpoint)），会始终显示遮罩层，无视该参数
    */
  lazy val modal: HtmlAttr[Boolean] = boolAttr("modal")

  /** 在有遮罩层的情况下，按下 ESC 键是否关闭抽屉栏 */
  lazy val closeOnEsc: HtmlAttr[Boolean] = boolAttr("close-on-esc")

  /** 点击遮罩层时，是否关闭抽屉栏 */
  lazy val closeOnOverlayClick: HtmlAttr[Boolean] = boolAttr("close-on-overlay-click")

  /**
    * 抽屉栏的位置。可选值包括：
    * 
    * * `left`：左侧
    * * `right`：右侧
    */
  lazy val placement: CommonKeys.placement.type = CommonKeys.placement

  /**
    * 默认情况下，抽屉栏相对于 `body` 元素显示。当该参数设置为 `true` 时，抽屉栏将相对于其父元素显示。
    * 
    * **Note**：设置该属性时，必须在父元素上手动设置样式 `position: relative; overflow: hidden;`。
    */
  lazy val contained: HtmlAttr[Boolean] = boolAttr("contained")

  lazy val mobile: HtmlAttr[Boolean] = boolAttr("mobile")

  /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
  lazy val order: HtmlAttr[Int] = intAttr("order")


  // -- Props --


  // -- Slots --

  object slots {

    /** 抽屉栏中的内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
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

    /** 抽屉栏容器 */
    lazy val panel: String = "panel"
  }


  // -- Element type -- 

  @js.native trait NavigationDrawerComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否打开抽屉栏 */
    var open: Boolean

    /**
      * 抽屉栏打开时，是否显示遮罩层
      * 
      * 在窄屏设备上（屏幕宽度小于 [`--mdui-breakpoint-md`](/docs/2/styles/design-tokens#breakpoint)），会始终显示遮罩层，无视该参数
      */
    var modal: Boolean

    /** 在有遮罩层的情况下，按下 ESC 键是否关闭抽屉栏 */
    var closeOnEsc: Boolean

    /** 点击遮罩层时，是否关闭抽屉栏 */
    var closeOnOverlayClick: Boolean

    /**
      * 抽屉栏的位置。可选值包括：
      * 
      * * `left`：左侧
      * * `right`：右侧
      */
    var placement: String

    /**
      * 默认情况下，抽屉栏相对于 `body` 元素显示。当该参数设置为 `true` 时，抽屉栏将相对于其父元素显示。
      * 
      * **Note**：设置该属性时，必须在父元素上手动设置样式 `position: relative; overflow: hidden;`。
      */
    var contained: Boolean

    /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
    var order: Int | Unit
  }
}
