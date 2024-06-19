package elgca.laminar.components.mdui

import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 列表组件。需配合 `<mdui-list-item>` 组件使用
  * 
  * ```html
  * <mdui-list>
  * ..<mdui-list-subheader>Subheader</mdui-list-subheader>
  * ..<mdui-list-item>Item 1</mdui-list-item>
  * ..<mdui-list-item>Item 2</mdui-list-item>
  * </mdui-list>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/List.scala List.scala source code]]
  */
object List extends WebComponent("mdui-list") {

  @JSImport("mdui/components/list.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = List.type

  type Ref = dom.HTMLElement


  // -- Events --


  // -- Attributes --


  // -- Props --


  // -- Slots --

  object slots {

    /** `<mdui-list-item>` 元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()
}
