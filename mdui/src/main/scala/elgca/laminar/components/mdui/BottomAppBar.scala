package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 底部应用栏组件
  * 
  * ```html
  * <mdui-bottom-app-bar>
  * ..<mdui-button-icon icon="check_box--outlined"></mdui-button-icon>
  * ..<mdui-button-icon icon="edit--outlined"></mdui-button-icon>
  * ..<mdui-button-icon icon="mic_none--outlined"></mdui-button-icon>
  * ..<mdui-button-icon icon="image--outlined"></mdui-button-icon>
  * ..<div style="flex-grow: 1"></div>
  * ..<mdui-fab icon="add"></mdui-fab>
  * </mdui-bottom-app-bar>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/BottomAppBar.scala BottomAppBar.scala source code]]
  */
object BottomAppBar extends WebComponent("mdui-bottom-app-bar") {

  @JSImport("mdui/components/bottom-app-bar.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = BottomAppBar.type

  type Ref = BottomAppBarComponent & dom.HTMLElement


  // -- Events --

  /** 开始显示时，事件被触发。可以通过调用 `event.preventDefault()` 阻止显示 */
  lazy val onShow: EventProp[dom.Event] = eventProp("show")

  /** 显示动画完成时，事件被触发 */
  lazy val onShown: EventProp[dom.Event] = eventProp("shown")

  /** 开始隐藏时，事件被触发。可以通过调用 `event.preventDefault()` 阻止隐藏 */
  lazy val onHide: EventProp[dom.Event] = eventProp("hide")

  /** 隐藏动画完成时，事件被触发 */
  lazy val onHidden: EventProp[dom.Event] = eventProp("hidden")


  // -- Attributes --

  /** 是否隐藏 */
  lazy val hide: HtmlAttr[Boolean] = boolAttr("hide")

  /** 是否让底部应用栏中的 [`<mdui-fab>`](/docs/2/components/fab) 组件脱离应用栏。如果为 `true`，则当应用栏隐藏后，[`<mdui-fab>`](/docs/2/components/fab) 仍会停留在页面上 */
  lazy val fabDetach: HtmlAttr[Boolean] = boolAttr("fab-detach")

  /**
    * 滚动行为。可选值为：
    * 
    * * `hide`：滚动时隐藏
    */
  lazy val scrollBehavior: HtmlAttr[String] = stringAttr("scroll-behavior")

  /** 在滚动多少距离之后触发滚动行为，单位为 `px` */
  lazy val scrollThreshold: HtmlAttr[Int] = intAttr("scroll-threshold")

  /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
  lazy val order: HtmlAttr[Int] = intAttr("order")


  // -- Props --

  /** 需要监听其滚动事件的元素。值可以是 CSS 选择器、DOM 元素、或 [JQ 对象](/docs/2/functions/jq)。默认监听 `window` 的滚动事件 */
  lazy val scrollTarget: HtmlProp[String | org.scalajs.dom.HTMLElement, ?] = asIsProp("scrollTarget")


  // -- Slots --

  object slots {

    /** 底部应用栏内部的元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")

  /** 组件的 CSS `z-index` 值 */
  lazy val zIndex: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--z-index")


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait BottomAppBarComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否隐藏 */
    var hide: Boolean

    /** 是否让底部应用栏中的 [`<mdui-fab>`](/docs/2/components/fab) 组件脱离应用栏。如果为 `true`，则当应用栏隐藏后，[`<mdui-fab>`](/docs/2/components/fab) 仍会停留在页面上 */
    var fabDetach: Boolean

    /**
      * 滚动行为。可选值为：
      * 
      * * `hide`：滚动时隐藏
      */
    var scrollBehavior: String | Unit

    /** 需要监听其滚动事件的元素。值可以是 CSS 选择器、DOM 元素、或 [JQ 对象](/docs/2/functions/jq)。默认监听 `window` 的滚动事件 */
    var scrollTarget: String | org.scalajs.dom.HTMLElement | Unit

    /** 在滚动多少距离之后触发滚动行为，单位为 `px` */
    var scrollThreshold: Int | Unit

    /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
    var order: Int | Unit
  }
}
