/**
 * Copy from [[https://github.com/raquo/laminar-shoelace-components/blob/master/src/main/scala/com/raquo/laminar/shoelace/sl/CommonKeys.scala]]
 */
package elgca.laminar.components.mdui

import com.raquo.ew.JsArray
import com.raquo.laminar.DomApi
import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.inputs.InputController.InputControllerConfig
import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter
import org.scalajs.dom

import scala.scalajs.js

/**
 * Typical events / properties / etc. defined on Shoelace web components. We selectively export them from this object into individual components that define them.
 */
object CommonKeys extends CommonTypes {

  /** Emitted when the control’s "state" changes, similar to the browser's `change` event. */
  // lazy val onChange: EventProp[dom.Event] = eventProp("sl-change")
  //
  /// ** Emitted when the control receives input, similar to the browser's `input` event */
  // lazy val onInput: EventProp[dom.Event] = eventProp("sl-input")
  //
  /// ** Emitted when the component loses focus. */
  // lazy val onBlur: EventProp[dom.Event] = eventProp("sl-blur")
  //
  /// ** Emitted when the component obtains focus. */
  // lazy val onFocus: EventProp[dom.Event] = eventProp("sl-focus")
  //
  /// ** Emitted when the form control has been checked for validity and its constraints aren’t satisfied. */
  // lazy val onInvalid: EventProp[dom.Event] = eventProp("sl-invalid")

  object autoCapitalize
      extends HtmlAttr[String]("autocapitalize", StringAsIsCodec) {

    lazy val off: HtmlAttrSetter[String] = autoCapitalize("off")

    lazy val none: HtmlAttrSetter[String] = autoCapitalize("none")

    lazy val on: HtmlAttrSetter[String] = autoCapitalize("on")

    lazy val sentences: HtmlAttrSetter[String] = autoCapitalize("sentences")

    lazy val words: HtmlAttrSetter[String] = autoCapitalize("words")

    lazy val characters: HtmlAttrSetter[String] = autoCapitalize("characters")
  }

  object inputMode extends HtmlAttr[String]("inputmode", StringAsIsCodec) {

    lazy val none: HtmlAttrSetter[String] = inputMode("none")

    lazy val text: HtmlAttrSetter[String] = inputMode("text")

    lazy val decimal: HtmlAttrSetter[String] = inputMode("decimal")

    lazy val numeric: HtmlAttrSetter[String] = inputMode("numeric")

    lazy val tel: HtmlAttrSetter[String] = inputMode("tel")

    lazy val search: HtmlAttrSetter[String] = inputMode("search")

    lazy val email: HtmlAttrSetter[String] = inputMode("email")

    lazy val url: HtmlAttrSetter[String] = inputMode("url")
  }

  object placement extends HtmlAttr[String]("placement", StringAsIsCodec) {

    lazy val top: HtmlAttrSetter[String] = placement("top")

    lazy val topStart: HtmlAttrSetter[String] = placement("top-start")

    lazy val topEnd: HtmlAttrSetter[String] = placement("top-end")

    lazy val bottom: HtmlAttrSetter[String] = placement("bottom")

    lazy val bottomStart: HtmlAttrSetter[String] = placement("bottom-start")

    lazy val bottomEnd: HtmlAttrSetter[String] = placement("bottom-end")

    lazy val right: HtmlAttrSetter[String] = placement("right")

    lazy val rightStart: HtmlAttrSetter[String] = placement("right-start")

    lazy val rightEnd: HtmlAttrSetter[String] = placement("right-end")

    lazy val left: HtmlAttrSetter[String] = placement("left")

    lazy val leftStart: HtmlAttrSetter[String] = placement("left-start")

    lazy val leftEnd: HtmlAttrSetter[String] = placement("left-end")
  }

  /** Standard sizes */
  object size extends HtmlAttr[String]("size", StringAsIsCodec) {

    lazy val small: HtmlAttrSetter[String] = size("small")

    lazy val medium: HtmlAttrSetter[String] = size("medium")

    lazy val large: HtmlAttrSetter[String] = size("large")
  }

  /** Which window to open the url in */
  object target extends HtmlAttr[String]("target", StringAsIsCodec) {

    lazy val _blank: HtmlAttrSetter[String] = target("blank")

    lazy val _parent: HtmlAttrSetter[String] = target("parent")

    lazy val _self: HtmlAttrSetter[String] = target("self")

    lazy val _top: HtmlAttrSetter[String] = target("top")
  }

  /** Theme variant – changes the colors */
  abstract class Variant extends HtmlAttr[String]("variant", StringAsIsCodec) {

    lazy val default: HtmlAttrSetter[String] = this := "default"

    lazy val primary: HtmlAttrSetter[String] = this := "primary"

    lazy val success: HtmlAttrSetter[String] = this := "success"

    lazy val neutral: HtmlAttrSetter[String] = this := "neutral"

    lazy val warning: HtmlAttrSetter[String] = this := "warning"

    lazy val danger: HtmlAttrSetter[String] = this := "danger"
  }

  object variant extends Variant

  object buttonVariant extends Variant {

    lazy val text: HtmlAttrSetter[String] = this := "text"
  }
}
