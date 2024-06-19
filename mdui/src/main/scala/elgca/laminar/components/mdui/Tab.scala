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
  * 选项卡导航项组件。需配合 `<mdui-tabs>` 和 `<mdui-tab-panel>` 组件使用
  * 
  * ```html
  * <mdui-tabs value="tab-1">
  * ..<mdui-tab value="tab-1">Tab 1</mdui-tab>
  * ..<mdui-tab value="tab-2">Tab 2</mdui-tab>
  * ..<mdui-tab value="tab-3">Tab 3</mdui-tab>
  * 
  * ..<mdui-tab-panel slot="panel" value="tab-1">Panel 1</mdui-tab-panel>
  * ..<mdui-tab-panel slot="panel" value="tab-2">Panel 2</mdui-tab-panel>
  * ..<mdui-tab-panel slot="panel" value="tab-3">Panel 3</mdui-tab-panel>
  * </mdui-tabs>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Tab.scala Tab.scala source code]]
  */
object Tab extends WebComponent("mdui-tab") {

  @JSImport("mdui/components/tab.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Tab.type

  type Ref = TabComponent & dom.HTMLElement


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

  /** 选项卡导航项的值 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /** Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
  lazy val icon: HtmlAttr[String] = stringAttr("icon")

  /** 是否把图标和文本水平排列 */
  lazy val inline: HtmlAttr[Boolean] = boolAttr("inline")

  /** 是否为激活状态，由 `<mdui-tabs>` 组件控制该参数 */
  lazy val active: HtmlAttr[Boolean] = boolAttr("active")

  /** 是否在页面加载完成后自动获取焦点 */
  lazy val autoFocus: HtmlAttr[Boolean] = boolAttr("autofocus")

  /**
    * 是否获得了焦点，不管是鼠标点击，还是键盘切换获得的焦点，都会添加该属性
    * 添加到 :host 元素上，供 CSS 选择器添加样式
    */
  lazy val focused: HtmlAttr[Boolean] = boolAttr("focused")

  /**
    * 是否通过键盘切换获得了焦点
    * 添加到 :host 元素上，供 CSS 选择器添加样式
    */
  lazy val focusVisible: HtmlAttr[Boolean] = boolAttr("focus-visible")

  /** 元素在使用 Tab 键切换焦点时的顺序 */
  lazy val tabIndex: HtmlAttr[Int] = intAttr("tabindex")


  // -- Props --

  /** 选项卡导航项的值 */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** 选项卡导航项的文本内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 选项卡导航项中的图标 */
    lazy val icon: Slot = Slot("icon")

    /** 徽标 */
    lazy val badge: Slot = Slot("badge")

    /** 自定义整个选项卡导航项中的内容 */
    lazy val custom: Slot = Slot("custom")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 选项卡导航项容器 */
    lazy val container: String = "container"

    /** 选项卡导航项中的图标 */
    lazy val icon: String = "icon"

    /** 选项卡导航项的文本 */
    lazy val label: String = "label"
  }


  // -- Element type -- 

  @js.native trait TabComponent extends js.Object { this: dom.HTMLElement => 

    /** 选项卡导航项的值 */
    var value: String | Unit

    /** Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
    var icon: String | Unit

    /** 是否把图标和文本水平排列 */
    var inline: Boolean

    /** 是否在页面加载完成后自动获取焦点 */
    var autofocus: Boolean

    /** 元素在使用 Tab 键切换焦点时的顺序 */
    var tabIndex: Int
  }
}
