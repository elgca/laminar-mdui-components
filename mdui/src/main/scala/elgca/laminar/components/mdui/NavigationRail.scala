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
  * 侧边导航栏组件。需配合 `<mdui-navigation-rail-item>` 组件使用
  * 
  * ```html
  * <mdui-navigation-rail>
  * ..<mdui-navigation-rail-item icon="watch_later">Recent</mdui-navigation-rail-item>
  * ..<mdui-navigation-rail-item icon="image">Images</mdui-navigation-rail-item>
  * ..<mdui-navigation-rail-item icon="library_music">Library</mdui-navigation-rail-item>
  * </mdui-navigation-rail>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/NavigationRail.scala NavigationRail.scala source code]]
  */
object NavigationRail extends WebComponent("mdui-navigation-rail") {

  @JSImport("mdui/components/navigation-rail.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = NavigationRail.type

  type Ref = NavigationRailComponent & dom.HTMLElement


  // -- Events --

  /** 值变化时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")


  // -- Attributes --

  /** 当前选中的 `<mdui-navigation-rail-item>` 的值 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /**
    * 导航栏的位置。可选值包括：
    * 
    * * `left`：左侧
    * * `right`：右侧
    */
  lazy val placement: CommonKeys.placement.type = CommonKeys.placement

  /**
    * `<mdui-navigation-rail-item>` 元素的对齐方式。可选值包括：
    * 
    * * `start`：顶部对齐
    * * `center`：居中对齐
    * * `end`：底部对齐
    */
  lazy val alignment: HtmlAttr[String] = stringAttr("alignment")

  /**
    * 默认情况下，导航栏相对于 `body` 元素显示。当该参数设置为 `true` 时，导航栏将相对于其父元素显示。
    * 
    * **Note**：设置该属性时，必须在父元素上手动设置样式 `position: relative;`。
    */
  lazy val contained: HtmlAttr[Boolean] = boolAttr("contained")

  /** 是否在导航栏和页面内容之间添加分割线 */
  lazy val divider: HtmlAttr[Boolean] = boolAttr("divider")

  /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
  lazy val order: HtmlAttr[Int] = intAttr("order")


  // -- Props --

  /** 当前选中的 `<mdui-navigation-rail-item>` 的值 */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** `<mdui-navigation-rail-item>` 组件 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 顶部的元素 */
    lazy val top: Slot = Slot("top")

    /** 底部的元素 */
    lazy val bottom: Slot = Slot("bottom")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")

  /** 组件的 CSS `z-index` 值 */
  lazy val zIndex: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--z-index")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 顶部元素的容器 */
    lazy val top: String = "top"

    /** 底部元素的容器 */
    lazy val bottom: String = "bottom"

    /** `<mdui-navigation-rail-item>` 组件的容器 */
    lazy val items: String = "items"
  }


  // -- Element type -- 

  @js.native trait NavigationRailComponent extends js.Object { this: dom.HTMLElement => 

    /** 当前选中的 `<mdui-navigation-rail-item>` 的值 */
    var value: String | Unit

    /**
      * 导航栏的位置。可选值包括：
      * 
      * * `left`：左侧
      * * `right`：右侧
      */
    var placement: String

    /**
      * `<mdui-navigation-rail-item>` 元素的对齐方式。可选值包括：
      * 
      * * `start`：顶部对齐
      * * `center`：居中对齐
      * * `end`：底部对齐
      */
    var alignment: String

    /**
      * 默认情况下，导航栏相对于 `body` 元素显示。当该参数设置为 `true` 时，导航栏将相对于其父元素显示。
      * 
      * **Note**：设置该属性时，必须在父元素上手动设置样式 `position: relative;`。
      */
    var contained: Boolean

    /** 是否在导航栏和页面内容之间添加分割线 */
    var divider: Boolean

    /** 该组件在 [`<mdui-layout>`](/docs/2/components/layout) 中的布局顺序，按从小到大排序。默认为 `0` */
    var order: Int | Unit
  }
}
