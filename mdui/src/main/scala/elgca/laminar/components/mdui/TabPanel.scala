package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 选项卡面板项组件。需配合 `<mdui-tabs>` 和 `<mdui-tab>` 组件使用
  * 
  * ```html
  * <mdui-tabs value="tab-1">
  * ..<mdui-tab value="tab-1">Tab 1</mdui-tab>
  * ..<mdui-tab value="tab-2">Tab 2</mdui-tab>
  * ..<mdui-tab value="tab-3">Tab 3</mdui-tab>
  * 
  * ..<mdui-tab-panel slot="panel" value="tab-1">Panel 1</mdui-tab-panel>
  * ..<mdui-tab-panel slot="panel" value="tab-2">Panel 2</mdui-tab-panel>
  * ..<mdui-tab-panel slot="panel" value="tab-3">Panel 3</mdui-tab-panel>
  * </mdui-tabs>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/TabPanel.scala TabPanel.scala source code]]
  */
object TabPanel extends WebComponent("mdui-tab-panel") {

  @JSImport("mdui/components/tab-panel.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = TabPanel.type

  type Ref = TabPanelComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /** 选项卡面板项的值 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /** 是否为激活状态，由 `<mdui-tabs>` 组件控制该状态 */
  lazy val active: HtmlAttr[Boolean] = boolAttr("active")


  // -- Props --

  /** 选项卡面板项的值 */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** 选项卡面板项内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait TabPanelComponent extends js.Object { this: dom.HTMLElement => 

    /** 选项卡面板项的值 */
    var value: String | Unit
  }
}
