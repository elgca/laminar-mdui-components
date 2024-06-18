package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by ShoelaceGenerator.scala

/**
  * 布局组件
  * 
  * ```html
  * <mdui-layout>
  * ..<mdui-layout-item></mdui-layout-item>
  * ..<mdui-layout-item></mdui-layout-item>
  * ..<mdui-layout-main></mdui-layout-main>
  * </mdui-layout>
  * ```
  * 
  * [[https://github.com/raquo/laminar-shoelace-components/blob/master/sample/src/main/scala/elgca/laminar/components/mdui/Layout.scala Layout.scala source code]]
  */
object Layout extends WebComponent("mdui-layout") {

  @JSImport("@shoelace-style/shoelace/dist/components/layout/layout.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Layout.type

  type Ref = LayoutComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /** 设置当前布局的高度为 100% */
  lazy val fullHeight: HtmlAttr[Boolean] = boolAttr("full-height")


  // -- Props --


  // -- Slots --

  object slots {

    /** 可以包含 [`<mdui-top-app-bar>`](/docs/2/components/top-app-bar)、[`<mdui-bottom-app-bar>`](/docs/2/components/bottom-app-bar)、[`<mdui-navigation-bar>`](/docs/2/components/navigation-bar)、[`<mdui-navigation-drawer>`](/docs/2/components/navigation-drawer)、[`<mdui-navigation-rail>`](/docs/2/components/navigation-rail)、`<mdui-layout-item>`、`<mdui-layout-main>` 元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait LayoutComponent extends js.Object { this: dom.HTMLElement => 

    /** 设置当前布局的高度为 100% */
    var fullHeight: Boolean
  }
}
