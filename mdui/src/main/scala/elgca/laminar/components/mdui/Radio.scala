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
  * 单选框组件。需配合 `<mdui-radio-group>` 组件使用
  * 
  * ```html
  * <mdui-radio-group value="chinese">
  * ..<mdui-radio value="chinese">Chinese</mdui-radio>
  * ..<mdui-radio value="english">English</mdui-radio>
  * </mdui-radio-group>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Radio.scala Radio.scala source code]]
  */
object Radio extends WebComponent("mdui-radio") {

  @JSImport("mdui/components/radio.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Radio.type

  type Ref = RadioComponent & dom.HTMLElement


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  /** 选中该单选项时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

  /** 当前单选项的值 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /** 是否禁用当前单选项 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /** 当前单选项是否已选中 */
  lazy val defaultChecked: HtmlAttr[Boolean] = boolAttr("checked")

  /** 未选中状态的 Material Icons 图标名。也可以通过 `slot="unchecked-icon"` 设置 */
  lazy val uncheckedIcon: HtmlAttr[String] = stringAttr("unchecked-icon")

  /** 选中状态的 Material Icons 图标名。也可以通过 `slot="checked-icon"` 设置 */
  lazy val checkedIcon: HtmlAttr[String] = stringAttr("checked-icon")

  lazy val groupDisabled: HtmlAttr[Boolean] = boolAttr("group-disabled")

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

  /** 当前单选项的值 */
  lazy val value: HtmlProp[String, ?] = L.value

  /** 当前单选项是否已选中 */
  lazy val checked: HtmlProp[Boolean, ?] = L.checked


  // -- Slots --

  object slots {

    /** 文本内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 未选中状态的图标 */
    lazy val uncheckedIcon: Slot = Slot("unchecked-icon")

    /** 选中状态的图标 */
    lazy val checkedIcon: Slot = Slot("checked-icon")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 左侧图标容器 */
    lazy val control: String = "control"

    /** 未选中状态的图标 */
    lazy val uncheckedIcon: String = "unchecked-icon"

    /** 选中状态的图标 */
    lazy val checkedIcon: String = "checked-icon"

    /** 文本内容 */
    lazy val label: String = "label"
  }


  // -- Element type -- 

  @js.native trait RadioComponent extends js.Object { this: dom.HTMLElement => 

    /** 当前单选项的值 */
    var value: String

    /** 是否禁用当前单选项 */
    var disabled: Boolean

    /** 当前单选项是否已选中 */
    var checked: Boolean

    /** 未选中状态的 Material Icons 图标名。也可以通过 `slot="unchecked-icon"` 设置 */
    var uncheckedIcon: String | Unit

    /** 选中状态的 Material Icons 图标名。也可以通过 `slot="checked-icon"` 设置 */
    var checkedIcon: String | Unit

    /** 是否在页面加载完成后自动获取焦点 */
    var autofocus: Boolean

    /** 元素在使用 Tab 键切换焦点时的顺序 */
    var tabIndex: Int
  }
}
