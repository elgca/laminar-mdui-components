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
  * 分段按钮组件。需配合 `<mdui-segmented-button>` 组件使用
  * 
  * ```html
  * <mdui-segmented-button-group>
  * ..<mdui-segmented-button>Day</mdui-segmented-button>
  * ..<mdui-segmented-button>Week</mdui-segmented-button>
  * ..<mdui-segmented-button>Month</mdui-segmented-button>
  * </mdui-segmented-button-group>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/SegmentedButtonGroup.scala SegmentedButtonGroup.scala source code]]
  */
object SegmentedButtonGroup extends WebComponent("mdui-segmented-button-group") {

  @JSImport("mdui/components/segmented-button-group.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = SegmentedButtonGroup.type

  type Ref = SegmentedButtonGroupComponent & dom.HTMLElement


  // -- Events --

  /** 选中的值变更时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

  /** 表单字段验证未通过时触发 */
  lazy val onInvalid: EventProp[dom.Event] = eventProp("invalid")


  // -- Attributes --

  /** 是否填满父元素宽度 */
  lazy val fullWidth: HtmlAttr[Boolean] = boolAttr("full-width")

  /**
    * 分段按钮的可选中状态，默认为不可选中。可选值包括：
    * 
    * * `single`：单选
    * * `multiple`：多选
    */
  lazy val selects: CommonKeys.selects.type = CommonKeys.selects

  /** 是否为禁用状态 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /** 提交表单时，是否必须选中 */
  lazy val required: HtmlAttr[Boolean] = boolAttr("required")

  /**
    * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
    * 
    * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
    */
  lazy val formId: HtmlAttr[String] = stringAttr("form")

  /** 提交表单时的名称，将与表单数据一起提交 */
  lazy val name: HtmlAttr[String] = stringAttr("name")
  // -- CommonKeys --
  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object selects extends HtmlAttr[String]("selects", StringAsIsCodec) {

      lazy val single: HtmlAttrSetter[String] = selects("single")

      lazy val multiple: HtmlAttrSetter[String] = selects("multiple")
    }
  }


  // -- Props --

  /**
    * 当前选中的 `<mdui-segmented-button>` 的值。
    * 
    * **Note**：该属性的 HTML 属性始终为字符串，且仅在 `selects="single"` 时可以通过 HTML 属性设置初始值。该属性的 JavaScript 属性值在 `selects="single"` 时为字符串，在 `selects="multiple"` 时为字符串数组。所以，在 `selects="multiple"` 时，如果要修改该值，只能通过修改 JavaScript 属性值实现。
    */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** `<mdui-segmented-button>` 组件 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait SegmentedButtonGroupComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否填满父元素宽度 */
    var fullWidth: Boolean

    /**
      * 分段按钮的可选中状态，默认为不可选中。可选值包括：
      * 
      * * `single`：单选
      * * `multiple`：多选
      */
    var selects: String | Unit

    /** 是否为禁用状态 */
    var disabled: Boolean

    /** 提交表单时，是否必须选中 */
    var required: Boolean

    /**
      * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
      * 
      * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
      */
    var form: String | Unit

    /** 提交表单时的名称，将与表单数据一起提交 */
    var name: String

    /**
      * 当前选中的 `<mdui-segmented-button>` 的值。
      * 
      * **Note**：该属性的 HTML 属性始终为字符串，且仅在 `selects="single"` 时可以通过 HTML 属性设置初始值。该属性的 JavaScript 属性值在 `selects="single"` 时为字符串，在 `selects="multiple"` 时为字符串数组。所以，在 `selects="multiple"` 时，如果要修改该值，只能通过修改 JavaScript 属性值实现。
      */
    var value: String

    /** 表单验证状态对象，具体参见 [`ValidityState`](https://developer.mozilla.org/zh-CN/docs/Web/API/ValidityState) */
    val validity: org.scalajs.dom.ValidityState

    /** 如果表单验证未通过，此属性将包含提示信息。如果验证通过，此属性将为空字符串 */
    val validationMessage: String
  }
}
