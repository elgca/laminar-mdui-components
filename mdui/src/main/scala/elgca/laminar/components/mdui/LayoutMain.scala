package elgca.laminar.components.mdui

import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 布局主体内容组件
  * 
  * ```html
  * <mdui-layout>
  * ..<mdui-layout-item></mdui-layout-item>
  * ..<mdui-layout-item></mdui-layout-item>
  * ..<mdui-layout-main></mdui-layout-main>
  * </mdui-layout>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/LayoutMain.scala LayoutMain.scala source code]]
  */
object LayoutMain extends WebComponent("mdui-layout-main") {

  @JSImport("mdui/components/layout-main/layout-main.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = LayoutMain.type

  type Ref = dom.HTMLElement


  // -- Events --


  // -- Attributes --


  // -- Props --


  // -- Slots --

  object slots {

    /** 可以包含任意内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()
}
