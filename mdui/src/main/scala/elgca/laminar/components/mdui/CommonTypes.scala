package elgca.laminar.components.mdui

import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.*
import com.raquo.laminar.codecs.*
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.keys
import com.raquo.laminar.keys.DerivedStyleProp
import com.raquo.laminar.modifiers.KeySetter
import com.raquo.laminar.modifiers.KeySetter.StyleSetter
import org.scalajs.dom

/**
 * Copy from [[https://github.com/raquo/laminar-shoelace-components/blob/master/src/main/scala/com/raquo/laminar/shoelace/sl/CommonTypes.scala]]
 */
trait CommonTypes {

  // #TODO[API] I should make use of Laminar helpers like lengthAutoStyle in StyleProps.scala,
  //  but they're defined together with the listings in the same traits, and I don't want
  //  to expose all those props. Split them out. Need minor breaking changes in Laminar.

  protected type DSP[V] = DerivedStyleProp[V]

  protected type SS = StyleSetter

  //// #TODO[Perf] I'm not convinced that these cache maps actually have a net benefit.
  ////  - I don't really think that we need reference equality among keys on different components
  ////  - We still refer to attrs as `lazy val`, this doesn't help with that
  ////  - Whether we save any RAM or not depends on which attrs on which components you use
  //
  // private val boolAttrs = js.Dictionary[HtmlAttr[Boolean]]()
  //
  // private val intAttrs = js.Dictionary[HtmlAttr[Int]]()
  //
  // private val stringAttrs = js.Dictionary[HtmlAttr[String]]()

  protected def eventProp[Ev <: dom.Event](name: String): EventProp[Ev] =
    L.eventProp(name)

  protected def stringProp(name: String): HtmlProp[String, ?] =
    L.htmlProp(name, StringAsIsCodec)

  protected def intProp(name: String): HtmlProp[Int, ?] =
    L.htmlProp(name, IntAsIsCodec)

  protected def doubleProp(name: String): HtmlProp[Double, ?] =
    L.htmlProp(name, DoubleAsIsCodec)

  protected def boolProp(name: String): HtmlProp[Boolean, ?] =
    L.htmlProp(name, BooleanAsIsCodec)

  protected def asIsProp[V](name: String): HtmlProp[V, ?] =
    L.htmlProp(name, AsIsCodec[V]())

  protected def boolAttr(name: String): HtmlAttr[Boolean] = {
    L.htmlAttr(name, BooleanAsAttrPresenceCodec)
  }

  protected def intAttr(name: String): HtmlAttr[Int] = {
    L.htmlAttr(name, IntAsStringCodec)
  }

  protected def stringAttr(name: String): HtmlAttr[String] = {
    // stringAttrs.getOrElseUpdate(name, L.htmlAttr(name, StringAsIsCodec))
    L.htmlAttr(name, StringAsIsCodec)
  }

  protected def lengthStyle(
    name: String,
  ): StyleProp[String] & u.Length[DSP, Int] = {
    new StyleProp[String](name) with u.Length[DSP, Int]
  }

  protected def colorStyle(
    name: String,
  ): StyleProp[String] & s.Color & u.Color[SS, DSP] = {
    new StyleProp[String](name) with s.Color with u.Color[SS, DSP]
  }

  protected def timeStyle(key: String): StyleProp[String] & u.Time[DSP] = {
    new StyleProp[String](key) with u.Time[DSP]
  }

  protected def lineStyle(key: String): StyleProp[String] & s.Line = {
    new StyleProp[String](key) with s.Line
  }

  protected def doubleStyle(key: String): StyleProp[Double] = {
    new StyleProp[Double](key)
  }

  protected def intStyle(key: String): StyleProp[Int] = {
    new StyleProp[Int](key)
  }
}
