package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 选项卡组件。需配合 `<mdui-tab>` 和 `<mdui-tab-panel>` 组件使用
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
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Tabs.scala Tabs.scala source code]]
  */
object Tabs extends WebComponent("mdui-tabs") {

  @JSImport("mdui/components/tabs.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Tabs.type

  type Ref = TabsComponent & dom.HTMLElement


  // -- Events --

  /** 选中的值变化时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")


  // -- Attributes --

  /**
    * 选项卡形状。可选值包括：
    * 
    * * `primary`：适用于位于 `<mdui-top-app-bar>` 下方，用于切换应用的主页面的场景
    * * `secondary`：适用于位于页面中，用于切换一组相关内容的场景
    */
  lazy val variant: CommonKeys.variant.type = CommonKeys.variant

  /** 当前激活的 `<mdui-tab>` 的值 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /**
    * 选项卡位置。默认为 `top-start`。可选值包括：
    * 
    * * `top-start`：位于上方，左对齐
    * * `top`：位于上方，居中对齐
    * * `top-end`：位于上方，右对齐
    * * `bottom-start`：位于下方，左对齐
    * * `bottom`：位于下方，居中对齐
    * * `bottom-end`：位于下方，右对齐
    * * `left-start`：位于左侧，顶部对齐
    * * `left`：位于左侧，居中对齐
    * * `left-end`：位于左侧，底部对齐
    * * `right-start`：位于右侧，顶部对齐
    * * `right`：位于右侧，居中对齐
    * * `right-end`：位于右侧，底部对齐
    */
  lazy val placement: CommonKeys.placement.type = CommonKeys.placement

  /** 是否填满父元素宽度 */
  lazy val fullWidth: HtmlAttr[Boolean] = boolAttr("full-width")

  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object variant extends HtmlAttr[String]("variant", StringAsIsCodec) {

      lazy val primary: HtmlAttrSetter[String] = autoCapitalize("primary")

      lazy val secondary: HtmlAttrSetter[String] = autoCapitalize("secondary")
    }

    object placement extends HtmlAttr[String]("placement", StringAsIsCodec) {

      lazy val topStart: HtmlAttrSetter[String] = autoCapitalize("top-start")

      lazy val top: HtmlAttrSetter[String] = autoCapitalize("top")

      lazy val topEnd: HtmlAttrSetter[String] = autoCapitalize("top-end")

      lazy val bottomStart: HtmlAttrSetter[String] = autoCapitalize("bottom-start")

      lazy val bottom: HtmlAttrSetter[String] = autoCapitalize("bottom")

      lazy val bottomEnd: HtmlAttrSetter[String] = autoCapitalize("bottom-end")

      lazy val leftStart: HtmlAttrSetter[String] = autoCapitalize("left-start")

      lazy val left: HtmlAttrSetter[String] = autoCapitalize("left")

      lazy val leftEnd: HtmlAttrSetter[String] = autoCapitalize("left-end")

      lazy val rightStart: HtmlAttrSetter[String] = autoCapitalize("right-start")

      lazy val right: HtmlAttrSetter[String] = autoCapitalize("right")

      lazy val rightEnd: HtmlAttrSetter[String] = autoCapitalize("right-end")
    }
  }


  // -- Props --

  /** 当前激活的 `<mdui-tab>` 的值 */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** `<mdui-tab>` 元素 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** `<mdui-tab-panel>` 元素 */
    lazy val panel: Slot = Slot("panel")
  }


  // -- CSS Vars --


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** `<mdui-tab>` 元素的容器 */
    lazy val container: String = "container"

    /** 激活状态指示器 */
    lazy val indicator: String = "indicator"
  }


  // -- Element type -- 

  @js.native trait TabsComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 选项卡形状。可选值包括：
      * 
      * * `primary`：适用于位于 `<mdui-top-app-bar>` 下方，用于切换应用的主页面的场景
      * * `secondary`：适用于位于页面中，用于切换一组相关内容的场景
      */
    var variant: String

    /** 当前激活的 `<mdui-tab>` 的值 */
    var value: String | Unit

    /**
      * 选项卡位置。默认为 `top-start`。可选值包括：
      * 
      * * `top-start`：位于上方，左对齐
      * * `top`：位于上方，居中对齐
      * * `top-end`：位于上方，右对齐
      * * `bottom-start`：位于下方，左对齐
      * * `bottom`：位于下方，居中对齐
      * * `bottom-end`：位于下方，右对齐
      * * `left-start`：位于左侧，顶部对齐
      * * `left`：位于左侧，居中对齐
      * * `left-end`：位于左侧，底部对齐
      * * `right-start`：位于右侧，顶部对齐
      * * `right`：位于右侧，居中对齐
      * * `right-end`：位于右侧，底部对齐
      */
    var placement: String

    /** 是否填满父元素宽度 */
    var fullWidth: Boolean
  }
}
