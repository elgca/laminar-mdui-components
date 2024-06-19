package elgca.laminar.components.mdui

import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 顶部应用栏标题组件。需配合 `<mdui-top-app-bar>` 组件使用
  * 
  * ```html
  * <mdui-top-app-bar>
  * ..<mdui-button-icon icon="menu"></mdui-button-icon>
  * ..<mdui-top-app-bar-title>Title</mdui-top-app-bar-title>
  * ..<div style="flex-grow: 1"></div>
  * ..<mdui-button-icon icon="more_vert"></mdui-button-icon>
  * </mdui-top-app-bar>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/TopAppBarTitle.scala TopAppBarTitle.scala source code]]
  */
object TopAppBarTitle extends WebComponent("mdui-top-app-bar-title") {

  @JSImport("mdui/components/top-app-bar-title.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = TopAppBarTitle.type

  type Ref = dom.HTMLElement


  // -- Events --


  // -- Attributes --


  // -- Props --


  // -- Slots --

  object slots {

    /** 顶部应用栏的标题文本 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 展开状态下的标题文本 */
    lazy val labelLarge: Slot = Slot("label-large")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 标题文本 */
    lazy val label: String = "label"

    /** 展开状态下的标题文本 */
    lazy val labelLarge: String = "label-large"
  }
}
