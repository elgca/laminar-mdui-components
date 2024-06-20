package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import com.raquo.laminar.tags.CustomHtmlTag
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 选择框组件。需配合 `<mdui-menu-item>` 组件使用
  * 
  * ```html
  * <mdui-select>
  * ..<mdui-menu-item value="item-1">Item 1</mdui-menu-item>
  * ..<mdui-menu-item value="item-2">Item 2</mdui-menu-item>
  * </mdui-select>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Select.scala Select.scala source code]]
  */
object Select extends WebComponent("mdui-select") with ControlledInput {

  @JSImport("mdui/components/select.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Select.type

  type Ref = SelectComponent & dom.HTMLElement

  override protected lazy val tag: CustomHtmlTag[Ref] = {
    tagWithControlledInput(value, initial = "", onChange)
  }


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  /** 选中的值变更时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

  /** 表单字段验证未通过时触发 */
  lazy val onInvalid: EventProp[dom.Event] = eventProp("invalid")

  /** 在点击由 `clearable` 属性生成的清空按钮时触发。可以通过调用 `event.preventDefault()` 阻止清空选择框 */
  lazy val onClear: EventProp[dom.Event] = eventProp("clear")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

  /**
    * 选择框的样式。可选值包括：
    * 
    * * `filled`：带背景色的选择框，视觉效果较强
    * * `outlined`：带边框的选择框，视觉效果较弱
    */
  lazy val variant: CommonKeys.variant.type = CommonKeys.variant

  /** 是否支持多选 */
  lazy val multiple: HtmlAttr[Boolean] = boolAttr("multiple")

  /** 选择框的名称，将与表单数据一起提交 */
  lazy val name: HtmlAttr[String] = stringAttr("name")

  /** 标签文本 */
  lazy val label: HtmlAttr[String] = stringAttr("label")

  /** 占位符文本 */
  lazy val placeholder: HtmlAttr[String] = stringAttr("placeholder")

  /** 选择框底部的帮助文本。也可以通过 `slot="helper"` 设置 */
  lazy val helper: HtmlAttr[String] = stringAttr("helper")

  /** 是否可以清空选择框 */
  lazy val clearable: HtmlAttr[Boolean] = boolAttr("clearable")

  /** 当选择框可清空时，显示在选择框右侧的清空按钮的 Material Icons 图标名。也可以通过 `slot="clear-icon"` 设置 */
  lazy val clearIcon: HtmlAttr[String] = stringAttr("clear-icon")

  /**
    * 选择框的位置。可选值包括：
    * 
    * * `auto`：自动判断位置
    * * `bottom`：位于下方
    * * `top`：位于上方
    */
  lazy val placement: CommonKeys.placement.type = CommonKeys.placement

  /** 文本是否右对齐 */
  lazy val endAligned: HtmlAttr[Boolean] = boolAttr("end-aligned")

  /** 选择框的前缀文本。仅在聚焦状态，或选择框有值时才会显示。也可以通过 `slot="prefix"` 设置 */
  lazy val prefix: HtmlAttr[String] = stringAttr("prefix")

  /** 选择框的后缀文本。仅在聚焦状态，或选择框有值时才会显示。也可以通过 `slot="suffix"` 设置 */
  lazy val suffix: HtmlAttr[String] = stringAttr("suffix")

  /** 选择框的前缀图标的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
  lazy val icon: HtmlAttr[String] = stringAttr("icon")

  /** 选择框的后缀图标的 Material Icons 图标名。也可以通过 `slot="end-icon"` 设置 */
  lazy val endIcon: HtmlAttr[String] = stringAttr("end-icon")

  /** 表单字段验证失败时，显示在选择框右侧的 Material Icons 图标名。也可以通过 `slot="error-icon"` 设置 */
  lazy val errorIcon: HtmlAttr[String] = stringAttr("error-icon")

  /**
    * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
    * 
    * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
    */
  lazy val formId: HtmlAttr[String] = stringAttr("form")

  /** 是否为只读状态 */
  lazy val readOnly: HtmlAttr[Boolean] = boolAttr("readonly")

  /** 是否为禁用状态 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /** 提交表单时，是否必须填写该字段 */
  lazy val required: HtmlAttr[Boolean] = boolAttr("required")

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
  // -- CommonKeys --
  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object variant extends HtmlAttr[String]("variant", StringAsIsCodec) {

      lazy val filled: HtmlAttrSetter[String] = variant("filled")

      lazy val outlined: HtmlAttrSetter[String] = variant("outlined")
    }

    object placement extends HtmlAttr[String]("placement", StringAsIsCodec) {

      lazy val auto: HtmlAttrSetter[String] = placement("auto")

      lazy val bottom: HtmlAttrSetter[String] = placement("bottom")

      lazy val top: HtmlAttrSetter[String] = placement("top")
    }
  }


  // -- Props --

  /**
    * 选择框的值，将与表单数据一起提交。
    * 
    * 如果未指定 `multiple` 属性，该值为字符串；如果指定了 `multiple` 属性，该值为字符串数组。HTML 属性只能设置字符串值；如果需要设置数组值，请通过 JavaScript 属性设置。
    */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** `<mdui-menu-item>` 元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 左侧图标 */
    lazy val icon: Slot = Slot("icon")

    /** 右侧图标 */
    lazy val endIcon: Slot = Slot("end-icon")

    /** 验证失败状态的右侧图标 */
    lazy val errorIcon: Slot = Slot("error-icon")

    /** 左侧文本 */
    lazy val prefix: Slot = Slot("prefix")

    /** 右侧文本 */
    lazy val suffix: Slot = Slot("suffix")

    /** 清空按钮 */
    lazy val clearButton: Slot = Slot("clear-button")

    /** 清空按钮中的图标 */
    lazy val clearIcon: Slot = Slot("clear-icon")

    /** 底部的帮助文本 */
    lazy val helper: Slot = Slot("helper")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 多选时，放置选中值对应的 chip 的容器 */
    lazy val chips: String = "chips"

    /** 多选时，每一个选中的值对应的 chip */
    lazy val chip: String = "chip"

    /** chip 内部的 `<button>` 元素 */
    lazy val chip__button: String = "chip__button"

    /** chip 内部的文本 */
    lazy val chip__label: String = "chip__label"

    /** chip 内部的删除图标 */
    lazy val chip__deleteIcon: String = "chip__delete-icon"

    /** 文本框，即 [`<mdui-text-field>`](/docs/2/components/text-field) 元素 */
    lazy val textField: String = "text-field"

    /** text-field 内部的文本框容器 */
    lazy val textField__container: String = "text-field__container"

    /** text-field 内部的左侧图标 */
    lazy val textField__icon: String = "text-field__icon"

    /** text-field 内部的右侧图标 */
    lazy val textField__endIcon: String = "text-field__end-icon"

    /** text-field 内部的验证失败状态的右侧图标 */
    lazy val textField__errorIcon: String = "text-field__error-icon"

    /** text-field 内部的左侧文本 */
    lazy val textField__prefix: String = "text-field__prefix"

    /** text-field 内部的右侧文本 */
    lazy val textField__suffix: String = "text-field__suffix"

    /** text-field 内部的标签文本 */
    lazy val textField__label: String = "text-field__label"

    /** text-field 内部的 `<input>` 元素 */
    lazy val textField__input: String = "text-field__input"

    /** text-field 内部的清空按钮 */
    lazy val textField__clearButton: String = "text-field__clear-button"

    /** text-field 内部的清空按钮中的图标 */
    lazy val textField__clearIcon: String = "text-field__clear-icon"

    /** text-field 内部的底部辅助信息容器，包括 helper 和 error */
    lazy val textField__supporting: String = "text-field__supporting"

    /** text-field 内部的底部帮助文本 */
    lazy val textField__helper: String = "text-field__helper"

    /** text-field 内部的底部错误描述文本 */
    lazy val textField__error: String = "text-field__error"

    /** 下拉菜单，即 [`<mdui-menu>`](/docs/2/components/menu) 元素 */
    lazy val menu: String = "menu"
  }


  // -- Element type -- 

  @js.native trait SelectComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 选择框的样式。可选值包括：
      * 
      * * `filled`：带背景色的选择框，视觉效果较强
      * * `outlined`：带边框的选择框，视觉效果较弱
      */
    var variant: String

    /** 是否支持多选 */
    var multiple: Boolean

    /** 选择框的名称，将与表单数据一起提交 */
    var name: String

    /**
      * 选择框的值，将与表单数据一起提交。
      * 
      * 如果未指定 `multiple` 属性，该值为字符串；如果指定了 `multiple` 属性，该值为字符串数组。HTML 属性只能设置字符串值；如果需要设置数组值，请通过 JavaScript 属性设置。
      */
    var value: String

    /** 标签文本 */
    var label: String | Unit

    /** 占位符文本 */
    var placeholder: String | Unit

    /** 选择框底部的帮助文本。也可以通过 `slot="helper"` 设置 */
    var helper: String | Unit

    /** 是否可以清空选择框 */
    var clearable: Boolean

    /** 当选择框可清空时，显示在选择框右侧的清空按钮的 Material Icons 图标名。也可以通过 `slot="clear-icon"` 设置 */
    var clearIcon: String | Unit

    /**
      * 选择框的位置。可选值包括：
      * 
      * * `auto`：自动判断位置
      * * `bottom`：位于下方
      * * `top`：位于上方
      */
    var placement: String

    /** 文本是否右对齐 */
    var endAligned: Boolean

    /** 选择框的前缀文本。仅在聚焦状态，或选择框有值时才会显示。也可以通过 `slot="prefix"` 设置 */
    var prefix: String

    /** 选择框的后缀文本。仅在聚焦状态，或选择框有值时才会显示。也可以通过 `slot="suffix"` 设置 */
    var suffix: String | Unit

    /** 选择框的前缀图标的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
    var icon: String | Unit

    /** 选择框的后缀图标的 Material Icons 图标名。也可以通过 `slot="end-icon"` 设置 */
    var endIcon: String | Unit

    /** 表单字段验证失败时，显示在选择框右侧的 Material Icons 图标名。也可以通过 `slot="error-icon"` 设置 */
    var errorIcon: String | Unit

    /**
      * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
      * 
      * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
      */
    var form: String | Unit

    /** 是否为只读状态 */
    var readonly: Boolean

    /** 是否为禁用状态 */
    var disabled: Boolean

    /** 提交表单时，是否必须填写该字段 */
    var required: Boolean

    /** 是否在页面加载完成后自动获取焦点 */
    var autofocus: Boolean

    /** 元素在使用 Tab 键切换焦点时的顺序 */
    var tabIndex: Int
  }
}
