package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import com.raquo.laminar.tags.CustomHtmlTag
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by ShoelaceGenerator.scala

/**
  * 复选框组件
  * 
  * ```html
  * <mdui-checkbox>Checkbox</mdui-checkbox>
  * ```
  * 
  * [[https://github.com/raquo/laminar-shoelace-components/blob/master/sample/src/main/scala/elgca/laminar/components/mdui/Checkbox.scala Checkbox.scala source code]]
  */
object Checkbox extends WebComponent("mdui-checkbox") with ControlledInput {

  @JSImport("@shoelace-style/shoelace/dist/components/checkbox/checkbox.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Checkbox.type

  type Ref = CheckboxComponent & dom.HTMLElement

  override protected lazy val tag: CustomHtmlTag[Ref] = {
    tagWithControlledInput(checked, initial = false, onInput)
  }


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  /** 选中状态变更时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

  /** 选中状态变更时触发 */
  lazy val onInput: EventProp[dom.Event] = eventProp("input")

  /** 表单字段验证未通过时触发 */
  lazy val onInvalid: EventProp[dom.Event] = eventProp("invalid")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

  /** 是否为禁用状态 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /** 是否为选中状态 */
  lazy val defaultChecked: HtmlAttr[Boolean] = boolAttr("checked")

  /** 是否处于不确定状态 */
  lazy val indeterminate: HtmlAttr[Boolean] = boolAttr("indeterminate")

  /** 提交表单时，是否必须选中此复选框 */
  lazy val required: HtmlAttr[Boolean] = boolAttr("required")

  /**
    * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
    * 
    * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
    */
  lazy val formId: HtmlAttr[String] = stringAttr("form")

  /** 复选框名称，将与表单数据一起提交 */
  lazy val name: HtmlAttr[String] = stringAttr("name")

  /** 复选框的值，将于表单数据一起提交 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /** 未选中状态的 Material Icons 图标名。也可以通过 `slot="unchecked-icon"` 设置 */
  lazy val uncheckedIcon: HtmlAttr[String] = stringAttr("unchecked-icon")

  /** 选中状态的 Material Icons 图标名。也可以通过 `slot="checked-icon"` 设置 */
  lazy val checkedIcon: HtmlAttr[String] = stringAttr("checked-icon")

  /** 不确定状态的 Material Icons 图标名。也可以通过 `slot="indeterminate-icon"` 设置 */
  lazy val indeterminateIcon: HtmlAttr[String] = stringAttr("indeterminate-icon")

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

  /** 是否为选中状态 */
  lazy val checked: HtmlProp[Boolean, ?] = L.checked

  /** 复选框的值，将于表单数据一起提交 */
  lazy val value: HtmlProp[String, ?] = L.value


  // -- Slots --

  object slots {

    /** 复选框文本 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 未选中状态的图标 */
    lazy val uncheckedIcon: Slot = Slot("unchecked-icon")

    /** 选中状态的图标 */
    lazy val checkedIcon: Slot = Slot("checked-icon")

    /** 不确定状态的图标 */
    lazy val indeterminateIcon: Slot = Slot("indeterminate-icon")
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

    /** 不确定状态的图标 */
    lazy val indeterminateIcon: String = "indeterminate-icon"

    /** 复选框文本 */
    lazy val label: String = "label"
  }


  // -- Element type -- 

  @js.native trait CheckboxComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否为禁用状态 */
    var disabled: Boolean

    /** 是否为选中状态 */
    var checked: Boolean

    /** 是否处于不确定状态 */
    var indeterminate: Boolean

    /** 提交表单时，是否必须选中此复选框 */
    var required: Boolean

    /**
      * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
      * 
      * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
      */
    var form: String | Unit

    /** 复选框名称，将与表单数据一起提交 */
    var name: String

    /** 复选框的值，将于表单数据一起提交 */
    var value: String

    /** 未选中状态的 Material Icons 图标名。也可以通过 `slot="unchecked-icon"` 设置 */
    var uncheckedIcon: String | Unit

    /** 选中状态的 Material Icons 图标名。也可以通过 `slot="checked-icon"` 设置 */
    var checkedIcon: String | Unit

    /** 不确定状态的 Material Icons 图标名。也可以通过 `slot="indeterminate-icon"` 设置 */
    var indeterminateIcon: String | Unit

    /** 是否在页面加载完成后自动获取焦点 */
    var autofocus: Boolean

    /** 元素在使用 Tab 键切换焦点时的顺序 */
    var tabIndex: Int
  }
}
