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
  * 键盘快捷键：
  * * `Arrow Up` / `Arrow Down` - 使焦点在 `<mdui-menu-item>` 之间向上/向下切换
  * * `Home` / `End` - 使焦点跳转到第一个/最后一个 `<mdui-menu-item>` 元素上
  * * `Space` - 可选中时，选中/取消选中一项
  * * `Enter` - 包含子菜单时，打开子菜单；为链接时，跳转链接
  * * `Escape` - 子菜单已打开时，关闭子菜单
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Menu.scala Menu.scala source code]]
  */
object Menu extends WebComponent("mdui-menu") {

  @JSImport("mdui/components/menu.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Menu.type

  type Ref = MenuComponent & dom.HTMLElement


  // -- Events --

  /** 菜单项选中状态变化时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")


  // -- Attributes --

  /**
    * 菜单项的可选状态。默认不可选。可选值包括：
    * 
    * * `single`：单选
    * * `multiple`：多选
    */
  lazy val selects: HtmlAttr[String] = stringAttr("selects")

  /** 菜单项是否使用紧凑布局 */
  lazy val dense: HtmlAttr[Boolean] = boolAttr("dense")

  /**
    * 子菜单的触发方式，支持多个值，用空格分隔。可选值包括：
    * 
    * * `click`：点击菜单项时打开子菜单
    * * `hover`：鼠标悬浮到菜单项上时打开子菜单
    * * `focus`：聚焦到菜单项上时打开子菜单
    * * `manual`：仅能通过编程方式打开和关闭子菜单，不能再指定其他触发方式
    */
  lazy val submenuTrigger: HtmlAttr[String] = stringAttr("submenu-trigger")

  /** 鼠标悬浮触发子菜单打开的延时，单位毫秒 */
  lazy val submenuOpenDelay: HtmlAttr[Int] = intAttr("submenu-open-delay")

  /** 鼠标悬浮触发子菜单关闭的延时，单位毫秒 */
  lazy val submenuCloseDelay: HtmlAttr[Int] = intAttr("submenu-close-delay")


  // -- Props --

  /**
    * 当前选中的 `<mdui-menu-item>` 的值。
    * 
    * **Note**：该属性的 HTML 属性始终为字符串，仅在 `selects="single"` 时可通过 HTML 属性设置初始值；该属性的 JavaScript 属性值在 `selects="single"` 时为字符串，在 `selects="multiple"` 时为字符串数组。因此，在 `selects="multiple"` 时，若要修改该值，只能通过修改 JavaScript 属性值实现。
    */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** 子菜单项（`<mdui-menu-item>`）、分割线（[`<mdui-divider>`](/docs/2/components/divider)）等元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait MenuComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 菜单项的可选状态。默认不可选。可选值包括：
      * 
      * * `single`：单选
      * * `multiple`：多选
      */
    var selects: String | Unit

    /**
      * 当前选中的 `<mdui-menu-item>` 的值。
      * 
      * **Note**：该属性的 HTML 属性始终为字符串，仅在 `selects="single"` 时可通过 HTML 属性设置初始值；该属性的 JavaScript 属性值在 `selects="single"` 时为字符串，在 `selects="multiple"` 时为字符串数组。因此，在 `selects="multiple"` 时，若要修改该值，只能通过修改 JavaScript 属性值实现。
      */
    var value: String | Unit

    /** 菜单项是否使用紧凑布局 */
    var dense: Boolean

    /**
      * 子菜单的触发方式，支持多个值，用空格分隔。可选值包括：
      * 
      * * `click`：点击菜单项时打开子菜单
      * * `hover`：鼠标悬浮到菜单项上时打开子菜单
      * * `focus`：聚焦到菜单项上时打开子菜单
      * * `manual`：仅能通过编程方式打开和关闭子菜单，不能再指定其他触发方式
      */
    var submenuTrigger: String

    /** 鼠标悬浮触发子菜单打开的延时，单位毫秒 */
    var submenuOpenDelay: Int

    /** 鼠标悬浮触发子菜单关闭的延时，单位毫秒 */
    var submenuCloseDelay: Int
  }
}
