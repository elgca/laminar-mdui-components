package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by ShoelaceGenerator.scala

/**
  * 折叠面板组件，需配合 `<mdui-collapse-item>` 组件使用
  * 
  * ```html
  * <mdui-collapse>
  * ..<mdui-collapse-item header="header-1">content-1</mdui-collapse-item>
  * ..<mdui-collapse-item header="header-2">content-2</mdui-collapse-item>
  * </mdui-collapse>
  * ```
  * 
  * [[https://github.com/raquo/laminar-shoelace-components/blob/master/sample/src/main/scala/elgca/laminar/components/mdui/Collapse.scala Collapse.scala source code]]
  */
object Collapse extends WebComponent("mdui-collapse") {

  @JSImport("@shoelace-style/shoelace/dist/components/collapse/collapse.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Collapse.type

  type Ref = CollapseComponent & dom.HTMLElement


  // -- Events --

  /** 当前展开的折叠面板项变化时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")


  // -- Attributes --

  /** 是否启用手风琴模式 */
  lazy val accordion: HtmlAttr[Boolean] = boolAttr("accordion")

  /** 是否禁用此折叠面板 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")


  // -- Props --

  /**
    * 当前展开的 `<mdui-collapse-item>` 的值
    * 
    * **Note**：该属性的 HTML 属性始终为字符串，只有在 `accordion` 为 `true` 时，才能设置初始值；该属性的 JavaScript 属性值在 `accordion` 为 `true` 时为字符串，在 `accordion` 为 `false` 时为字符串数组。因此，当 `accordion` 为 `false` 时，只能通过修改 JavaScript 属性值来改变此值。
    */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** `<mdui-collapse-item>` 组件 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait CollapseComponent extends js.Object { this: dom.HTMLElement => 

    /** 是否启用手风琴模式 */
    var accordion: Boolean

    /**
      * 当前展开的 `<mdui-collapse-item>` 的值
      * 
      * **Note**：该属性的 HTML 属性始终为字符串，只有在 `accordion` 为 `true` 时，才能设置初始值；该属性的 JavaScript 属性值在 `accordion` 为 `true` 时为字符串，在 `accordion` 为 `false` 时为字符串数组。因此，当 `accordion` 为 `false` 时，只能通过修改 JavaScript 属性值来改变此值。
      */
    var value: String | Unit

    /** 是否禁用此折叠面板 */
    var disabled: Boolean
  }
}
