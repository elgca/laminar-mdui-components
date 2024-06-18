package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by ShoelaceGenerator.scala

/**
  * 文本框组件
  * 
  * ```html
  * <mdui-text-field label="Text Field"></mdui-text-field>
  * ```
  * 
  * [[https://github.com/raquo/laminar-shoelace-components/blob/master/sample/src/main/scala/elgca/laminar/components/mdui/TextField.scala TextField.scala source code]]
  */
object TextField extends WebComponent("mdui-text-field") {

  @JSImport("@shoelace-style/shoelace/dist/components/text-field/text-field.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = TextField.type

  type Ref = TextFieldComponent & dom.HTMLElement


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  /** 在文本框的值变更，且失去焦点时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

  /** 在文本框的值变更时触发 */
  lazy val onInput: EventProp[dom.Event] = eventProp("input")

  /** 表单字段验证不通过时触发 */
  lazy val onInvalid: EventProp[dom.Event] = eventProp("invalid")

  /** 在点击由 `clearable` 属性生成的清空按钮时触发。可以通过调用 `event.preventDefault()` 阻止清空文本框 */
  lazy val onClear: EventProp[dom.Event] = eventProp("clear")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

  /**
    * 文本框的形状。默认为 `filled`。可选值包括：
    * 
    * * `filled`：带背景色的文本框，视觉效果较强
    * * `outlined`：带边框的文本框，视觉效果较弱
    */
  lazy val variant: CommonKeys.variant.type = CommonKeys.variant

  /**
    * 文本框输入类型。默认为 `text`。可选值包括：
    * 
    * * `text`：默认值。文本字段
    * * `number`：只能输入数字。拥有动态键盘的设备上会显示数字键盘
    * * `password`：用于输入密码，其值会被遮盖
    * * `url`：用于输入 URL，会验证 URL 格式。在支持动态键盘的设备上有相应的键盘
    * * `email`：用于输入邮箱地址，会验证邮箱格式。在支持动态键盘的设备上有相应的键盘
    * * `search`：用于搜索框。拥有动态键盘的设备上的回车图标会变成搜索图标
    * * `tel`：用于输入电话号码。拥有动态键盘的设备上会显示电话数字键盘
    * * `hidden`：隐藏该控件，但其值仍会提交到服务器
    * * `date`：输入日期的控件（年、月、日，不包括时间）。在支持的浏览器激活时打开日期选择器或年月日的数字滚轮
    * * `datetime-local`：输入日期和时间的控件，不包括时区。在支持的浏览器激活时打开日期选择器或年月日的数字滚轮
    * * `month`：输入年和月的控件，没有时区
    * * `time`：用于输入时间的控件，不包括时区
    * * `week`：用于输入以年和周数组成的日期，不带时区
    */
  lazy val `type`: HtmlAttr[String] = stringAttr("type")

  lazy val typ: HtmlAttr[String] = `type`

  lazy val tpe: HtmlAttr[String] = `type`

  /** 文本框名称，将与表单数据一起提交 */
  lazy val name: HtmlAttr[String] = stringAttr("name")

  /** 文本框的值，将与表单数据一起提交 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /** 标签文本 */
  lazy val label: HtmlAttr[String] = stringAttr("label")

  /** 占位符文本 */
  lazy val placeholder: HtmlAttr[String] = stringAttr("placeholder")

  /** 文本框底部的帮助文本。也可以通过 `slot="helper"` 设置 */
  lazy val helper: HtmlAttr[String] = stringAttr("helper")

  /** 是否仅在获得焦点时，显示底部的帮助文本 */
  lazy val helperOnFocus: HtmlAttr[Boolean] = boolAttr("helper-on-focus")

  /** 是否可清空文本框内容 */
  lazy val clearable: HtmlAttr[Boolean] = boolAttr("clearable")

  /** 可清空文本框时，显示在文本框右侧的清空按钮的 Material Icons 图标名。也可以通过 `slot="clear-icon"` 设置 */
  lazy val clearIcon: HtmlAttr[String] = stringAttr("clear-icon")

  /** 是否将文本右对齐 */
  lazy val endAligned: HtmlAttr[Boolean] = boolAttr("end-aligned")

  /** 文本框的前缀文本。只在文本框聚焦或有值时显示。也可以通过 `slot="prefix"` 设置 */
  lazy val prefix: HtmlAttr[String] = stringAttr("prefix")

  /** 文本框的后缀文本。只在文本框聚焦或有值时显示。也可以通过 `slot="suffix"` 设置 */
  lazy val suffix: HtmlAttr[String] = stringAttr("suffix")

  /** 文本框的前缀图标的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
  lazy val icon: HtmlAttr[String] = stringAttr("icon")

  /** 文本框的后缀图标的 Material Icons 图标名。也可以通过 `slot="end-icon"` 设置 */
  lazy val endIcon: HtmlAttr[String] = stringAttr("end-icon")

  /** 表单字段验证失败时，显示在文本框右侧的 Material Icons 图标名。也可以通过 `slot="error-icon"` 设置 */
  lazy val errorIcon: HtmlAttr[String] = stringAttr("error-icon")

  /**
    * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
    * 
    * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
    */
  lazy val formId: HtmlAttr[String] = stringAttr("form")

  /** 是否为只读模式 */
  lazy val readOnly: HtmlAttr[Boolean] = boolAttr("readonly")

  /** 是否禁用输入框 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /** 提交表单时，是否必须填写该字段 */
  lazy val required: HtmlAttr[Boolean] = boolAttr("required")

  /** 文本框的固定显示行数 */
  lazy val rows: HtmlAttr[Int] = intAttr("rows")

  /** 是否根据输入内容自动调整文本框高度 */
  lazy val autosize: HtmlAttr[Boolean] = boolAttr("autosize")

  /** `autosize` 为 `true` 时，文本框的最小行数 */
  lazy val minRows: HtmlAttr[Int] = intAttr("min-rows")

  /** `autosize` 为 `true` 时，文本框的最大行数 */
  lazy val maxRows: HtmlAttr[Int] = intAttr("max-rows")

  /** 允许输入的最小字符数 */
  lazy val minLength: HtmlAttr[Int] = intAttr("minlength")

  /** 允许输入的最大字符数 */
  lazy val maxLength: HtmlAttr[Int] = intAttr("maxlength")

  /** 是否显示字数统计，只在 `maxlength` 被指定时有效 */
  lazy val counter: HtmlAttr[Boolean] = boolAttr("counter")

  /** 当 `type` 为 `number` 时，允许输入的最小数值 */
  lazy val min: HtmlAttr[Int] = intAttr("min")

  /** 当 `type` 为 `number` 时，允许输入的最大数值 */
  lazy val max: HtmlAttr[Int] = intAttr("max")

  /** `type` 为 `number` 时，数值增减的步长 */
  lazy val step: HtmlAttr[Int] = intAttr("step")

  /** 用于表单验证的正则表达式 */
  lazy val pattern: HtmlAttr[String] = stringAttr("pattern")

  /** `type` 为 `password` 时，设置此属性会添加一个切换按钮，用于在明文和密文之间切换 */
  lazy val togglePassword: HtmlAttr[Boolean] = boolAttr("toggle-password")

  /** 密码切换按钮的 Material Icons 图标，当密码为明文时显示。也可以通过 `slot="show-password-icon"` 设置 */
  lazy val showPasswordIcon: HtmlAttr[String] = stringAttr("show-password-icon")

  /** 密码切换按钮的 Material Icons 图标，当密码为密文时显示。也可以通过 `slot="hide-password-icon"` 设置 */
  lazy val hidePasswordIcon: HtmlAttr[String] = stringAttr("hide-password-icon")

  /**
    * iOS 的非标准属性，用于控制文本首字母是否自动大写。在 iOS5 及以后的版本上有效。可选值包括：
    * 
    * * `none`：禁用首字母大写
    * * `sentences`：句子首字母大写
    * * `words`：单词首字母大写
    * * `characters`：所有字母大写
    */
  lazy val autoCapitalize: CommonKeys.autoCapitalize.type = CommonKeys.autoCapitalize

  /** `input` 元素的 `autocorrect` 属性 */
  lazy val autoCorrect: HtmlAttr[String] = stringAttr("autocorrect")

  /**
    * 是否使用浏览器的自动填充功能。可选值包括：
    * 
    * * `off`：禁用浏览器的自动填充，使用者必须输入他们想要输入的所有内容。或者网页提供了自己的自动填充方法
    * * `on`：浏览器根据用户之前输入的内容或者习惯，在用户输入的时候给出相应输入提示
    */
  lazy val autoComplete: HtmlAttr[String] = stringAttr("autocomplete")

  /**
    * `input` 元素的 `enterkeyhint` 属性，用于定制虚拟键盘上的 Enter 键的显示文本或图标。具体显示效果取决于用户使用的设备和语言。可选值包括：
    * 
    * * `enter`：插入新行
    * * `done`：完成输入，关闭虚拟键盘
    * * `go`：导航到输入文本的目标
    * * `next`：移动到下一个输入项
    * * `previous`：移动到上一个输入项
    * * `search`：导航到搜索结果
    * * `send`：发送文本信息
    */
  lazy val enterkeyhint: HtmlAttr[String] = stringAttr("enterkeyhint")

  /** 是否启用拼写检查 */
  lazy val spellCheck: HtmlAttr[Boolean] = boolAttr("spellcheck")

  /**
    * `input` 元素的 `inputmode` 属性，用于定制虚拟键盘的类型。可选值包括：
    * 
    * * `none`：无虚拟键盘。在需要实现自己的键盘输入控件时很有用
    * * `text`：标准文本输入键盘
    * * `decimal`：小数输入键盘，除了数字之外可能会有小数点 `.` 或者千分符逗号 `,`
    * * `numeric`：显示 0-9 的数字键盘
    * * `tel`：手机数字键盘，包含 0-9 数字、星号 `*` 或者井号 `#` 键
    * * `search`：为搜索输入优化的虚拟键盘，提交按钮通常会显示 `search` 或者 “搜索”
    * * `email`：为邮件地址输入优化的虚拟键盘，通常会有 `@ .` 等键
    * * `url`：为 URL 输入优化的虚拟键盘，通常会有 `. / #` 等键
    */
  lazy val inputMode: CommonKeys.inputMode.type = CommonKeys.inputMode

  /**
    * 该属性设置为 true 时，则在样式上为 text-field 赋予聚焦状态。实际是否聚焦仍然由 focusableMixin 控制
    * 该属性仅供 mdui 内部使用，当前 select 组件使用了该属性
    */
  lazy val focusedStyle: HtmlAttr[Boolean] = boolAttr("focused-style")

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

  /** 文本框的值，将与表单数据一起提交 */
  lazy val value: HtmlProp[String, ?] = L.value

  /**
    * 获取当前值，并转换为 `number` 类型；或设置一个 `number` 类型的值。
    * 如果值无法被转换为 `number` 类型，则会返回 `NaN`。
    */
  lazy val valueAsNumber: HtmlProp[Int, ?] = intProp("valueAsNumber")


  // -- Slots --

  object slots {

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

    /** 密码显示状态切换按钮 */
    lazy val togglePasswordButton: Slot = Slot("toggle-password-button")

    /** 显示密码状态下，密码显示状态切换按钮中的图标 */
    lazy val showPasswordIcon: Slot = Slot("show-password-icon")

    /** 隐藏密码状态下，密码显示状态切换按钮中的图标 */
    lazy val hidePasswordIcon: Slot = Slot("hide-password-icon")

    /** 底部的帮助文本 */
    lazy val helper: Slot = Slot("helper")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 文本框容器 */
    lazy val container: String = "container"

    /** 左侧图标 */
    lazy val icon: String = "icon"

    /** 右侧图标 */
    lazy val endIcon: String = "end-icon"

    /** 验证失败状态的右侧图标 */
    lazy val errorIcon: String = "error-icon"

    /** 左侧文本 */
    lazy val prefix: String = "prefix"

    /** 右侧文本 */
    lazy val suffix: String = "suffix"

    /** 上方的标签文本 */
    lazy val label: String = "label"

    /** 内部的 `<input>` 或 `<textarea>` 元素 */
    lazy val input: String = "input"

    /** 清空按钮 */
    lazy val clearButton: String = "clear-button"

    /** 清空按钮中的图标 */
    lazy val clearIcon: String = "clear-icon"

    /** 密码显示状态切换按钮 */
    lazy val togglePasswordButton: String = "toggle-password-button"

    /** 显示密码状态下，密码显示状态切换按钮中的图标 */
    lazy val showPasswordIcon: String = "show-password-icon"

    /** 隐藏密码状态下，密码显示状态切换按钮中的图标 */
    lazy val hidePasswordIcon: String = "hide-password-icon"

    /** 底部辅助信息容器，包括 helper、error、counter */
    lazy val supporting: String = "supporting"

    /** 底部的帮助文本 */
    lazy val helper: String = "helper"

    /** 底部的错误描述文本 */
    lazy val error: String = "error"

    /** 底部右侧的字数统计 */
    lazy val counter: String = "counter"
  }


  // -- Element type -- 

  @js.native trait TextFieldComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 文本框的形状。默认为 `filled`。可选值包括：
      * 
      * * `filled`：带背景色的文本框，视觉效果较强
      * * `outlined`：带边框的文本框，视觉效果较弱
      */
    var variant: String

    /**
      * 文本框输入类型。默认为 `text`。可选值包括：
      * 
      * * `text`：默认值。文本字段
      * * `number`：只能输入数字。拥有动态键盘的设备上会显示数字键盘
      * * `password`：用于输入密码，其值会被遮盖
      * * `url`：用于输入 URL，会验证 URL 格式。在支持动态键盘的设备上有相应的键盘
      * * `email`：用于输入邮箱地址，会验证邮箱格式。在支持动态键盘的设备上有相应的键盘
      * * `search`：用于搜索框。拥有动态键盘的设备上的回车图标会变成搜索图标
      * * `tel`：用于输入电话号码。拥有动态键盘的设备上会显示电话数字键盘
      * * `hidden`：隐藏该控件，但其值仍会提交到服务器
      * * `date`：输入日期的控件（年、月、日，不包括时间）。在支持的浏览器激活时打开日期选择器或年月日的数字滚轮
      * * `datetime-local`：输入日期和时间的控件，不包括时区。在支持的浏览器激活时打开日期选择器或年月日的数字滚轮
      * * `month`：输入年和月的控件，没有时区
      * * `time`：用于输入时间的控件，不包括时区
      * * `week`：用于输入以年和周数组成的日期，不带时区
      */
    var `type`: String

    /** 文本框名称，将与表单数据一起提交 */
    var name: String

    /** 文本框的值，将与表单数据一起提交 */
    var value: String

    /** 标签文本 */
    var label: String | Unit

    /** 占位符文本 */
    var placeholder: String | Unit

    /** 文本框底部的帮助文本。也可以通过 `slot="helper"` 设置 */
    var helper: String | Unit

    /** 是否仅在获得焦点时，显示底部的帮助文本 */
    var helperOnFocus: Boolean

    /** 是否可清空文本框内容 */
    var clearable: Boolean

    /** 可清空文本框时，显示在文本框右侧的清空按钮的 Material Icons 图标名。也可以通过 `slot="clear-icon"` 设置 */
    var clearIcon: String | Unit

    /** 是否将文本右对齐 */
    var endAligned: Boolean

    /** 文本框的前缀文本。只在文本框聚焦或有值时显示。也可以通过 `slot="prefix"` 设置 */
    var prefix: String

    /** 文本框的后缀文本。只在文本框聚焦或有值时显示。也可以通过 `slot="suffix"` 设置 */
    var suffix: String | Unit

    /** 文本框的前缀图标的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
    var icon: String | Unit

    /** 文本框的后缀图标的 Material Icons 图标名。也可以通过 `slot="end-icon"` 设置 */
    var endIcon: String | Unit

    /** 表单字段验证失败时，显示在文本框右侧的 Material Icons 图标名。也可以通过 `slot="error-icon"` 设置 */
    var errorIcon: String | Unit

    /**
      * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
      * 
      * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
      */
    var form: String | Unit

    /** 是否为只读模式 */
    var readonly: Boolean

    /** 是否禁用输入框 */
    var disabled: Boolean

    /** 提交表单时，是否必须填写该字段 */
    var required: Boolean

    /** 文本框的固定显示行数 */
    var rows: Int | Unit

    /** 是否根据输入内容自动调整文本框高度 */
    var autosize: Boolean

    /** `autosize` 为 `true` 时，文本框的最小行数 */
    var minRows: Int | Unit

    /** `autosize` 为 `true` 时，文本框的最大行数 */
    var maxRows: Int | Unit

    /** 允许输入的最小字符数 */
    var minlength: Int | Unit

    /** 允许输入的最大字符数 */
    var maxlength: Int | Unit

    /** 是否显示字数统计，只在 `maxlength` 被指定时有效 */
    var counter: Boolean

    /** 当 `type` 为 `number` 时，允许输入的最小数值 */
    var min: Int | Unit

    /** 当 `type` 为 `number` 时，允许输入的最大数值 */
    var max: Int | Unit

    /** `type` 为 `number` 时，数值增减的步长 */
    var step: Int | Unit

    /** 用于表单验证的正则表达式 */
    var pattern: String | Unit

    /** `type` 为 `password` 时，设置此属性会添加一个切换按钮，用于在明文和密文之间切换 */
    var togglePassword: Boolean

    /** 密码切换按钮的 Material Icons 图标，当密码为明文时显示。也可以通过 `slot="show-password-icon"` 设置 */
    var showPasswordIcon: String | Unit

    /** 密码切换按钮的 Material Icons 图标，当密码为密文时显示。也可以通过 `slot="hide-password-icon"` 设置 */
    var hidePasswordIcon: String | Unit

    /**
      * iOS 的非标准属性，用于控制文本首字母是否自动大写。在 iOS5 及以后的版本上有效。可选值包括：
      * 
      * * `none`：禁用首字母大写
      * * `sentences`：句子首字母大写
      * * `words`：单词首字母大写
      * * `characters`：所有字母大写
      */
    var autocapitalize: String

    /** `input` 元素的 `autocorrect` 属性 */
    var autocorrect: String | Unit

    /**
      * 是否使用浏览器的自动填充功能。可选值包括：
      * 
      * * `off`：禁用浏览器的自动填充，使用者必须输入他们想要输入的所有内容。或者网页提供了自己的自动填充方法
      * * `on`：浏览器根据用户之前输入的内容或者习惯，在用户输入的时候给出相应输入提示
      */
    var autocomplete: String | Unit

    /**
      * `input` 元素的 `enterkeyhint` 属性，用于定制虚拟键盘上的 Enter 键的显示文本或图标。具体显示效果取决于用户使用的设备和语言。可选值包括：
      * 
      * * `enter`：插入新行
      * * `done`：完成输入，关闭虚拟键盘
      * * `go`：导航到输入文本的目标
      * * `next`：移动到下一个输入项
      * * `previous`：移动到上一个输入项
      * * `search`：导航到搜索结果
      * * `send`：发送文本信息
      */
    var enterkeyhint: String | Unit

    /** 是否启用拼写检查 */
    var spellcheck: Boolean

    /**
      * `input` 元素的 `inputmode` 属性，用于定制虚拟键盘的类型。可选值包括：
      * 
      * * `none`：无虚拟键盘。在需要实现自己的键盘输入控件时很有用
      * * `text`：标准文本输入键盘
      * * `decimal`：小数输入键盘，除了数字之外可能会有小数点 `.` 或者千分符逗号 `,`
      * * `numeric`：显示 0-9 的数字键盘
      * * `tel`：手机数字键盘，包含 0-9 数字、星号 `*` 或者井号 `#` 键
      * * `search`：为搜索输入优化的虚拟键盘，提交按钮通常会显示 `search` 或者 “搜索”
      * * `email`：为邮件地址输入优化的虚拟键盘，通常会有 `@ .` 等键
      * * `url`：为 URL 输入优化的虚拟键盘，通常会有 `. / #` 等键
      */
    var inputmode: String | Unit

    /** 表单验证状态对象，具体参见 [`ValidityState`](https://developer.mozilla.org/zh-CN/docs/Web/API/ValidityState) */
    val validity: org.scalajs.dom.ValidityState

    /** 如果表单验证未通过，此属性将包含提示信息。如果验证通过，此属性将为空字符串 */
    val validationMessage: String

    /**
      * 获取当前值，并转换为 `number` 类型；或设置一个 `number` 类型的值。
      * 如果值无法被转换为 `number` 类型，则会返回 `NaN`。
      */
    var valueAsNumber: Int

    /** 是否在页面加载完成后自动获取焦点 */
    var autofocus: Boolean

    /** 元素在使用 Tab 键切换焦点时的顺序 */
    var tabIndex: Int
  }
}
