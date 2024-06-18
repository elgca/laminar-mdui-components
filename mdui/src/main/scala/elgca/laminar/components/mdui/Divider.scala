package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlAttr}
import com.raquo.laminar.api.L
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 分割线组件
  * 
  * ```html
  * <mdui-divider></mdui-divider>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Divider.scala Divider.scala source code]]
  */
object Divider extends WebComponent("mdui-divider") {

  @JSImport("mdui/components/divider/divider.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Divider.type

  type Ref = DividerComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /** 是否为垂直分割线 */
  lazy val vertical: HtmlAttr[Boolean] = boolAttr("vertical")

  /** 是否进行左侧缩进 */
  lazy val inset: HtmlAttr[Boolean] = boolAttr("inset")

  /** 是否进行左右两侧缩进 */
  lazy val middle: HtmlAttr[Boolean] = boolAttr("middle")


  // -- Props --


  // -- Slots --

  /** This component has no slots - don't give it any children. */
  @inline def noSlots: Unit = ()


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait DividerComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否为垂直分割线 */
    var vertical: Boolean

    /** 是否进行左侧缩进 */
    var inset: Boolean

    /** 是否进行左右两侧缩进 */
    var middle: Boolean
  }
}
