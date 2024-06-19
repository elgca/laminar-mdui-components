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
  * 单选框组组件。需配合 `<mdui-radio>` 组件使用
  * 
  * ```html
  * <mdui-radio-group value="chinese">
  * ..<mdui-radio value="chinese">Chinese</mdui-radio>
  * ..<mdui-radio value="english">English</mdui-radio>
  * </mdui-radio-group>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/RadioGroup.scala RadioGroup.scala source code]]
  */
object RadioGroup extends WebComponent("mdui-radio-group") with ControlledInput {

  @JSImport("mdui/components/radio-group.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = RadioGroup.type

  type Ref = RadioGroupComponent & dom.HTMLElement

  override protected lazy val tag: CustomHtmlTag[Ref] = {
    tagWithControlledInput(value, initial = "", onInput)
  }


  // -- Events --

  /** 选中值变化时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

  /** 选中值变化时触发 */
  lazy val onInput: EventProp[dom.Event] = eventProp("input")

  /** 表单字段验证未通过时触发 */
  lazy val onInvalid: EventProp[dom.Event] = eventProp("invalid")


  // -- Attributes --

  /** 是否禁用此组件 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /**
    * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
    * 
    * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
    */
  lazy val formId: HtmlAttr[String] = stringAttr("form")

  /** 单选框组的名称，将与表单数据一起提交 */
  lazy val name: HtmlAttr[String] = stringAttr("name")

  /** 单选框组的名称，将于表单数据一起提交 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /** 提交表单时，是否必须选中其中一个单选框 */
  lazy val required: HtmlAttr[Boolean] = boolAttr("required")


  // -- Props --

  /** 单选框组的名称，将于表单数据一起提交 */
  lazy val value: HtmlProp[String, ?] = L.value


  // -- Slots --

  object slots {

    /** `<mdui-radio>` 元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait RadioGroupComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否禁用此组件 */
    var disabled: Boolean

    /**
      * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
      * 
      * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
      */
    var form: String | Unit

    /** 单选框组的名称，将与表单数据一起提交 */
    var name: String

    /** 单选框组的名称，将于表单数据一起提交 */
    var value: String

    /** 提交表单时，是否必须选中其中一个单选框 */
    var required: Boolean
  }
}
