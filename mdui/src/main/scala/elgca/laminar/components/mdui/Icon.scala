package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 图标组件
  * 
  * ```html
  * <mdui-icon name="search"></mdui-icon>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Icon.scala Icon.scala source code]]
  */
object Icon extends WebComponent("mdui-icon") {

  @JSImport("mdui/components/icon/icon.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Icon.type

  type Ref = IconComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /** Material Icons 图标名 */
  lazy val name: HtmlAttr[String] = stringAttr("name")

  /** svg 图标的路径 */
  lazy val src: HtmlAttr[String] = stringAttr("src")


  // -- Props --


  // -- Slots --

  object slots {

    /** `svg` 图标的内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait IconComponent extends js.Object { this: dom.HTMLElement => 

    /** Material Icons 图标名 */
    var name: String | Unit

    /** svg 图标的路径 */
    var src: String | Unit
  }
}
