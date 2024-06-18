package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 范围滑块组件
  * 
  * ```html
  * <mdui-range-slider></mdui-range-slider>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/RangeSlider.scala RangeSlider.scala source code]]
  */
object RangeSlider extends WebComponent("mdui-range-slider") {

  @JSImport("mdui/components/range-slider/range-slider.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = RangeSlider.type

  type Ref = RangeSliderComponent & dom.HTMLElement


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  /** 值发生变更，且失去焦点时，将触发该事件 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

  /** 值变更时触发 */
  lazy val onInput: EventProp[dom.Event] = eventProp("input")

  /** 表单字段验证未通过时触发 */
  lazy val onInvalid: EventProp[dom.Event] = eventProp("invalid")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

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

  /** 滑块的最小值，默认为 `0` */
  lazy val min: HtmlAttr[Int] = intAttr("min")

  /** 滑块的最大值，默认为 `100` */
  lazy val max: HtmlAttr[Int] = intAttr("max")

  /** 步进间隔，默认为 `1` */
  lazy val step: HtmlAttr[Int] = intAttr("step")

  /** 是否添加刻度标记 */
  lazy val tickmarks: HtmlAttr[Boolean] = boolAttr("tickmarks")

  /** 是否隐藏文本提示 */
  lazy val nolabel: HtmlAttr[Boolean] = boolAttr("nolabel")

  /** 是否被禁用 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /**
    * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
    * 
    * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
    */
  lazy val formId: HtmlAttr[String] = stringAttr("form")

  /** 滑块的名称，该名称将与表单数据一起提交 */
  lazy val name: HtmlAttr[String] = stringAttr("name")


  // -- Props --

  /**
    * 滑块的值，为数组格式，将于表单数据一起提交。
    * 
    * **NOTE**：该属性无法通过 HTML 属性设置初始值，如果要修改该值，只能通过修改 JavaScript 属性值实现。
    */
  lazy val value: HtmlProp[js.Array[Double], ?] = asIsProp("value")

  /** 用于自定义标签的显示格式的函数。函数参数为滑块的当前值，返回值为期望显示的文本。 */


  // -- Slots --

  /** This component has no slots - don't give it any children. */
  @inline def noSlots: Unit = ()


  // -- CSS Vars --


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 未激活状态的轨道 */
    lazy val trackInactive: String = "track-inactive"

    /** 已激活状态的轨道 */
    lazy val trackActive: String = "track-active"

    /** 操作杆 */
    lazy val handle: String = "handle"

    /** 提示文本 */
    lazy val label: String = "label"

    /** 刻度标记 */
    lazy val tickmark: String = "tickmark"
  }


  // -- Element type -- 

  @js.native trait RangeSliderComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 滑块的值，为数组格式，将于表单数据一起提交。
      * 
      * **NOTE**：该属性无法通过 HTML 属性设置初始值，如果要修改该值，只能通过修改 JavaScript 属性值实现。
      */
    var value: js.Array[Double]

    /** 是否在页面加载完成后自动获取焦点 */
    var autofocus: Boolean

    /** 元素在使用 Tab 键切换焦点时的顺序 */
    var tabIndex: Int

    /** 滑块的最小值，默认为 `0` */
    var min: Int

    /** 滑块的最大值，默认为 `100` */
    var max: Int

    /** 步进间隔，默认为 `1` */
    var step: Int

    /** 是否添加刻度标记 */
    var tickmarks: Boolean

    /** 是否隐藏文本提示 */
    var nolabel: Boolean

    /** 是否被禁用 */
    var disabled: Boolean

    /**
      * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
      * 
      * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
      */
    var form: String | Unit

    /** 滑块的名称，该名称将与表单数据一起提交 */
    var name: String

    /** 表单验证状态对象，具体参见 [`ValidityState`](https://developer.mozilla.org/zh-CN/docs/Web/API/ValidityState) */
    val validity: org.scalajs.dom.ValidityState

    /** 如果表单验证未通过，此属性将包含提示信息。如果验证通过，此属性将为空字符串 */
    val validationMessage: String

    /** 用于自定义标签的显示格式的函数。函数参数为滑块的当前值，返回值为期望显示的文本。 */
    var labelFormatter: js.Function1[Double, String]
  }
}
