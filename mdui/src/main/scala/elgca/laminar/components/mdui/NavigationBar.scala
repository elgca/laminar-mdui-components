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
  * 底部导航栏组件。需配合 `<mdui-navigation-bar-item>` 组件使用
  * 
  * ```html
  * <mdui-navigation-bar>
  * ..<mdui-navigation-bar-item icon="place">Item 1</mdui-navigation-bar-item>
  * ..<mdui-navigation-bar-item icon="commute">Item 2</mdui-navigation-bar-item>
  * ..<mdui-navigation-bar-item icon="people">Item 3</mdui-navigation-bar-item>
  * </mdui-navigation-bar>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/NavigationBar.scala NavigationBar.scala source code]]
  */
object NavigationBar extends WebComponent("mdui-navigation-bar") {

  @JSImport("mdui/components/navigation-bar.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = NavigationBar.type

  type Ref = NavigationBarComponent & dom.HTMLElement


  // -- Events --

  /** 值变化时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

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

  /**
    * 文本的可视状态。可选值包括：
    * 
    * * `auto`：当选项小于等于3个时，始终显示文本；当选项大于3个时，仅显示选中状态的文本
    * * `selected`：仅在选中状态显示文本
    * * `labeled`：始终显示文本
    * * `unlabeled`：始终不显示文本
    */
  lazy val labelVisibility: HtmlAttr[String] = stringAttr("label-visibility")

  /** 当前选中的 `<mdui-navigation-bar-item>` 的值 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /**
    * 滚动行为。可选值包括：
    * 
    * * `hide`：滚动时隐藏
    */
  lazy val scrollBehavior: HtmlAttr[String] = stringAttr("scroll-behavior")

  /** 在滚动多少距离之后触发滚动行为，单位为 `px` */
  lazy val scrollThreshold: HtmlAttr[Int] = intAttr("scroll-threshold")

  /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
  lazy val order: HtmlAttr[Int] = intAttr("order")


  // -- Props --

  /** 当前选中的 `<mdui-navigation-bar-item>` 的值 */
  lazy val value: HtmlProp[String, ?] = stringProp("value")

  /** 需要监听其滚动事件的元素。值可以是 CSS 选择器、DOM 元素、或 [JQ 对象](/docs/2/functions/jq)。默认监听 `window` 的滚动事件 */
  lazy val scrollTarget: HtmlProp[String | org.scalajs.dom.HTMLElement, ?] = asIsProp("scrollTarget")


  // -- Slots --

  object slots {

    /** `<mdui-navigation-bar-item>` 组件 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
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

  @js.native trait NavigationBarComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否隐藏 */
    var hide: Boolean

    /**
      * 文本的可视状态。可选值包括：
      * 
      * * `auto`：当选项小于等于3个时，始终显示文本；当选项大于3个时，仅显示选中状态的文本
      * * `selected`：仅在选中状态显示文本
      * * `labeled`：始终显示文本
      * * `unlabeled`：始终不显示文本
      */
    var labelVisibility: String

    /** 当前选中的 `<mdui-navigation-bar-item>` 的值 */
    var value: String | Unit

    /**
      * 滚动行为。可选值包括：
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
