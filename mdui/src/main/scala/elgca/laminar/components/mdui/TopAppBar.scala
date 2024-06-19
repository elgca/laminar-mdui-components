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
  * 顶部应用栏组件
  * 
  * ```html
  * <mdui-top-app-bar>
  * ..<mdui-button-icon icon="menu"></mdui-button-icon>
  * ..<mdui-top-app-bar-title>Title</mdui-top-app-bar-title>
  * ..<div style="flex-grow: 1"></div>
  * ..<mdui-button-icon icon="more_vert"></mdui-button-icon>
  * </mdui-top-app-bar>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/TopAppBar.scala TopAppBar.scala source code]]
  */
object TopAppBar extends WebComponent("mdui-top-app-bar") {

  @JSImport("mdui/components/top-app-bar.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = TopAppBar.type

  type Ref = TopAppBarComponent & dom.HTMLElement


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

  /**
    * 顶部应用栏的形状。默认为 `small`。可选值包括：
    * 
    * * `center-aligned`：小型应用栏，标题居中
    * * `small`：小型应用栏
    * * `medium`：中型应用栏
    * * `large`：大型应用栏
    */
  lazy val variant: CommonKeys.variant.type = CommonKeys.variant

  /** 是否隐藏 */
  lazy val hide: HtmlAttr[Boolean] = boolAttr("hide")

  /** 是否缩小为 `variant="small"` 的样式，仅在 `variant="medium"` 或 `variant="large"` 时生效 */
  lazy val shrink: HtmlAttr[Boolean] = boolAttr("shrink")

  /**
    * 滚动行为。可同时使用多个值，用空格分隔。可选值包括：
    * 
    * * `hide`：滚动时隐藏
    * * `shrink`：在中型、大型应用栏中可使用，滚动时缩小成小型应用栏的样式
    * * `elevate`：滚动时添加阴影
    */
  lazy val scrollBehavior: HtmlAttr[String] = stringAttr("scroll-behavior")

  /** 滚动条是否不位于顶部 */
  lazy val scrolling: HtmlAttr[Boolean] = boolAttr("scrolling")

  /** 在滚动多少距离之后触发滚动行为，单位为 `px` */
  lazy val scrollThreshold: HtmlAttr[Int] = intAttr("scroll-threshold")

  /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
  lazy val order: HtmlAttr[Int] = intAttr("order")

  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object variant extends HtmlAttr[String]("variant", StringAsIsCodec) {

      lazy val centerAligned: HtmlAttrSetter[String] = autoCapitalize("center-aligned")

      lazy val small: HtmlAttrSetter[String] = autoCapitalize("small")

      lazy val medium: HtmlAttrSetter[String] = autoCapitalize("medium")

      lazy val large: HtmlAttrSetter[String] = autoCapitalize("large")
    }
  }


  // -- Props --

  /** 需要监听其滚动事件的元素。值可以是 CSS 选择器、DOM 元素、或 [JQ 对象](/docs/2/functions/jq)。默认监听 `window` 的滚动事件 */
  lazy val scrollTarget: HtmlProp[String | org.scalajs.dom.HTMLElement, ?] = asIsProp("scrollTarget")


  // -- Slots --

  object slots {

    /** 顶部应用栏内部的元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
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

  @js.native trait TopAppBarComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 顶部应用栏的形状。默认为 `small`。可选值包括：
      * 
      * * `center-aligned`：小型应用栏，标题居中
      * * `small`：小型应用栏
      * * `medium`：中型应用栏
      * * `large`：大型应用栏
      */
    var variant: String

    /** 是否隐藏 */
    var hide: Boolean

    /** 是否缩小为 `variant="small"` 的样式，仅在 `variant="medium"` 或 `variant="large"` 时生效 */
    var shrink: Boolean

    /**
      * 滚动行为。可同时使用多个值，用空格分隔。可选值包括：
      * 
      * * `hide`：滚动时隐藏
      * * `shrink`：在中型、大型应用栏中可使用，滚动时缩小成小型应用栏的样式
      * * `elevate`：滚动时添加阴影
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
