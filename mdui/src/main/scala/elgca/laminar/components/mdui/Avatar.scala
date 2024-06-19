package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 头像组件
  * 
  * ```html
  * <mdui-avatar src="https://avatars.githubusercontent.com/u/3030330?s=40&v=4"></mdui-avatar>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Avatar.scala Avatar.scala source code]]
  */
object Avatar extends WebComponent("mdui-avatar") {

  @JSImport("mdui/components/avatar.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Avatar.type

  type Ref = AvatarComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /** 头像图片的 URL 地址 */
  lazy val src: HtmlAttr[String] = stringAttr("src")

  /**
    * 图片如何适应容器框，与原生的 [`object-fit`](https://developer.mozilla.org/en-US/docs/Web/CSS/object-fit) 属性相同。可选值包括：
    * 
    * * `contain`：保持图片原有尺寸比例，内容会被等比例缩放
    * * `cover`：保持图片原有尺寸比例，但部分内容可能被剪切
    * * `fill`：默认值，不保持图片原有尺寸比例，内容会被拉伸以填充整个容器
    * * `none`：保留图片原有尺寸，内容不会被缩放或拉伸
    * * `scale-down`：保持图片原有尺寸比例，内容尺寸与 `none` 或 `contain` 中较小的一个相同
    */
  lazy val fit: CommonKeys.fit.type = CommonKeys.fit

  /** 头像的 Material Icons 图标名 */
  lazy val icon: HtmlAttr[String] = stringAttr("icon")

  /** 头像的替代文本描述 */
  lazy val label: HtmlAttr[String] = stringAttr("label")

  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object fit extends HtmlAttr[String]("fit", StringAsIsCodec) {

      lazy val contain: HtmlAttrSetter[String] = fit("contain")

      lazy val cover: HtmlAttrSetter[String] = fit("cover")

      lazy val fill: HtmlAttrSetter[String] = fit("fill")

      lazy val none: HtmlAttrSetter[String] = fit("none")

      lazy val scaleDown: HtmlAttrSetter[String] = fit("scale-down")
    }
  }


  // -- Props --


  // -- Slots --

  object slots {

    /** 自定义头像内容，可以为字母、汉字、`<img>` 元素、图标等 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 使用图片作为头像时，组件内部的 `<img>` 元素 */
    lazy val image: String = "image"

    /** 使用图标作为头像时，组件内部的 `<mdui-icon>` 元素 */
    lazy val icon: String = "icon"
  }


  // -- Element type -- 

  @js.native trait AvatarComponent extends js.Object { this: dom.HTMLElement => 

    /** 头像图片的 URL 地址 */
    var src: String | Unit

    /**
      * 图片如何适应容器框，与原生的 [`object-fit`](https://developer.mozilla.org/en-US/docs/Web/CSS/object-fit) 属性相同。可选值包括：
      * 
      * * `contain`：保持图片原有尺寸比例，内容会被等比例缩放
      * * `cover`：保持图片原有尺寸比例，但部分内容可能被剪切
      * * `fill`：默认值，不保持图片原有尺寸比例，内容会被拉伸以填充整个容器
      * * `none`：保留图片原有尺寸，内容不会被缩放或拉伸
      * * `scale-down`：保持图片原有尺寸比例，内容尺寸与 `none` 或 `contain` 中较小的一个相同
      */
    var fit: String | Unit

    /** 头像的 Material Icons 图标名 */
    var icon: String | Unit

    /** 头像的替代文本描述 */
    var label: String | Unit
  }
}
