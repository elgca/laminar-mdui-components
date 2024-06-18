package elgca.laminar.components.mdui

import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 列表标题组件。需配合 `<mdui-list>` 组件使用
  * 
  * ```html
  * <mdui-list>
  * ..<mdui-list-subheader>Subheader</mdui-list-subheader>
  * ..<mdui-list-item>Item 1</mdui-list-item>
  * ..<mdui-list-item>Item 2</mdui-list-item>
  * </mdui-list>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/ListSubheader.scala ListSubheader.scala source code]]
  */
object ListSubheader extends WebComponent("mdui-list-subheader") {

  @JSImport("mdui/components/list-subheader/list-subheader.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = ListSubheader.type

  type Ref = dom.HTMLElement


  // -- Events --


  // -- Attributes --


  // -- Props --


  // -- Slots --

  object slots {

    /** 列表标题文本 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()
}
