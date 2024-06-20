package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 列表项组件。需配合 `<mdui-list>` 组件使用
  * 
  * ```html
  * <mdui-list>
  * ..<mdui-list-subheader>Subheader</mdui-list-subheader>
  * ..<mdui-list-item>Item 1</mdui-list-item>
  * ..<mdui-list-item>Item 2</mdui-list-item>
  * </mdui-list>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/ListItem.scala ListItem.scala source code]]
  */
object ListItem extends WebComponent("mdui-list-item") {

  @JSImport("mdui/components/list-item.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = ListItem.type

  type Ref = ListItemComponent & dom.HTMLElement


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

  /** 主文本。也可以通过 default slot 设置 */
  lazy val headline: HtmlAttr[String] = stringAttr("headline")

  /**
    * 主文本行数，超过限制后将截断显示。默认无行数限制。可选值包括：
    * 
    * * `1`：显示单行，超出后截断
    * * `2`：显示两行，超出后截断
    * * `3`：显示三行，超出后截断
    */
  lazy val headlineLine: HtmlAttr[Int] = intAttr("headline-line")

  /** 副文本。也可以通过 `slot="description"` 设置 */
  lazy val description: HtmlAttr[String] = stringAttr("description")

  /**
    * 副文本行数，超过限制后将截断显示。默认无行数限制。可选值包括：
    * 
    * * `1`：显示单行，超出后截断
    * * `2`：显示两行，超出后截断
    * * `3`：显示三行，超出后截断
    */
  lazy val descriptionLine: HtmlAttr[Int] = intAttr("description-line")

  /** 左侧的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
  lazy val icon: HtmlAttr[String] = stringAttr("icon")

  /** 右侧的 Material Icons 图标名。也可以通过 `slot="end-icon"` 设置 */
  lazy val endIcon: HtmlAttr[String] = stringAttr("end-icon")

  /** 是否禁用该列表项，禁用后，列表项将变为灰色，且其中的 [`<mdui-checkbox>`](/docs/2/components/checkbox)、[`<mdui-radio>`](/docs/2/components/radio)、[`<mdui-switch>`](/docs/2/components/switch) 等也将禁用 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /** 是否激活该列表项 */
  lazy val active: HtmlAttr[Boolean] = boolAttr("active")

  /** 是否使列表项不可点击。设置后，列表项中的 [`<mdui-checkbox>`](/docs/2/components/checkbox)、[`<mdui-radio>`](/docs/2/components/radio)、[`<mdui-switch>`](/docs/2/components/switch) 等仍可交互 */
  lazy val nonclickable: HtmlAttr[Boolean] = boolAttr("nonclickable")

  /** 是否使用圆角形状的列表项 */
  lazy val rounded: HtmlAttr[Boolean] = boolAttr("rounded")

  /**
    * 列表项的垂直对齐方式。可选值包括：
    * 
    * * `start`：顶部对齐
    * * `center`：居中对齐
    * * `end`：底部对齐
    */
  lazy val alignment: CommonKeys.alignment.type = CommonKeys.alignment

  /**
    * 链接的目标 URL。
    * 
    * 如果设置了此属性，组件内部将渲染为 `<a>` 元素，并可以使用链接相关的属性。
    */
  lazy val href: HtmlAttr[String] = stringAttr("href")

  /**
    * 下载链接的目标。
    * 
    * **Note**：仅在设置了 `href` 属性时，此属性才有效。
    */
  lazy val download: HtmlAttr[String] = stringAttr("download")

  /**
    * 链接的打开方式。可选值包括：
    * 
    * * `_blank`：在新窗口中打开链接
    * * `_parent`：在父框架中打开链接
    * * `_self`：默认。在当前框架中打开链接
    * * `_top`：在整个窗口中打开链接
    * 
    * **Note**：仅在设置了 `href` 属性时，此属性才有效。
    */
  lazy val target: CommonKeys.target.type = CommonKeys.target

  /**
    * 当前文档与被链接文档之间的关系。可选值包括：
    * 
    * * `alternate`：当前文档的替代版本
    * * `author`：当前文档或文章的作者
    * * `bookmark`：永久链接到最近的祖先章节
    * * `external`：引用的文档与当前文档不在同一站点
    * * `help`：链接到相关的帮助文档
    * * `license`：当前文档的主要内容由被引用文件的版权许可覆盖
    * * `me`：当前文档代表链接内容的所有者
    * * `next`：当前文档是系列中的一部分，被引用的文档是系列的下一个文档
    * * `nofollow`：当前文档的作者或发布者不认可被引用的文件
    * * `noreferrer`：不包含 `Referer` 头。类似于 `noopener` 的效果
    * * `opener`：如果超链接会创建一个顶级浏览上下文（即 `target` 属性值为 `_blank`），则创建一个辅助浏览上下文
    * * `prev`：当前文档是系列的一部分，被引用的文档是系列的上一个文档
    * * `search`：提供一个资源链接，可用于搜索当前文件及其相关页面
    * * `tag`：提供一个适用于当前文档的标签（由给定地址识别）
    * 
    * **Note**：仅在指定了 `href` 属性时可用。
    */
  lazy val rel: CommonKeys.rel.type = CommonKeys.rel

  /** 是否在页面加载完成后自动获取焦点 */
  lazy val autoFocus: HtmlAttr[Boolean] = boolAttr("autofocus")

  /**
    * 是否获得了焦点，不管是鼠标点击，还是键盘切换获得的焦点，都会添加该属性
    * 添加到 :host 元素上，供 CSS 选择器添加样式
    */
  lazy val focused: HtmlAttr[Boolean] = boolAttr("focused")

  /**
    * 是否通过键盘切换获得了焦点
    * 添加到 :host 元素上，供 CSS 选择器添加样式
    */
  lazy val focusVisible: HtmlAttr[Boolean] = boolAttr("focus-visible")

  /** 元素在使用 Tab 键切换焦点时的顺序 */
  lazy val tabIndex: HtmlAttr[Int] = intAttr("tabindex")
  // -- CommonKeys --
  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object rel extends HtmlAttr[String]("rel", StringAsIsCodec) {

      lazy val alternate: HtmlAttrSetter[String] = rel("alternate")

      lazy val author: HtmlAttrSetter[String] = rel("author")

      lazy val bookmark: HtmlAttrSetter[String] = rel("bookmark")

      lazy val external: HtmlAttrSetter[String] = rel("external")

      lazy val help: HtmlAttrSetter[String] = rel("help")

      lazy val license: HtmlAttrSetter[String] = rel("license")

      lazy val me: HtmlAttrSetter[String] = rel("me")

      lazy val next: HtmlAttrSetter[String] = rel("next")

      lazy val nofollow: HtmlAttrSetter[String] = rel("nofollow")

      lazy val noreferrer: HtmlAttrSetter[String] = rel("noreferrer")

      lazy val opener: HtmlAttrSetter[String] = rel("opener")

      lazy val prev: HtmlAttrSetter[String] = rel("prev")

      lazy val search: HtmlAttrSetter[String] = rel("search")

      lazy val tag: HtmlAttrSetter[String] = rel("tag")
    }

    object alignment extends HtmlAttr[String]("alignment", StringAsIsCodec) {

      lazy val start: HtmlAttrSetter[String] = alignment("start")

      lazy val center: HtmlAttrSetter[String] = alignment("center")

      lazy val end: HtmlAttrSetter[String] = alignment("end")
    }

    object target extends HtmlAttr[String]("target", StringAsIsCodec) {

      lazy val _blank: HtmlAttrSetter[String] = target("_blank")

      lazy val _parent: HtmlAttrSetter[String] = target("_parent")

      lazy val _self: HtmlAttrSetter[String] = target("_self")

      lazy val _top: HtmlAttrSetter[String] = target("_top")
    }
  }


  // -- Props --


  // -- Slots --

  object slots {

    /** 主文本 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 副文本 */
    lazy val description: Slot = Slot("description")

    /** 列表项左侧的元素 */
    lazy val icon: Slot = Slot("icon")

    /** 列表项右侧的元素 */
    lazy val endIcon: Slot = Slot("end-icon")

    /** 任意自定义内容 */
    lazy val custom: Slot = Slot("custom")
  }


  // -- CSS Vars --

  /** 列表项的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")

  /** 指定了 `rounded` 属性时，列表项的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCornerRounded: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner-rounded")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 列表项容器 */
    lazy val container: String = "container"

    /** 左侧图标 */
    lazy val icon: String = "icon"

    /** 右侧图标 */
    lazy val endIcon: String = "end-icon"

    /** 中间部分 */
    lazy val body: String = "body"

    /** 主标题 */
    lazy val headline: String = "headline"

    /** 副标题 */
    lazy val description: String = "description"
  }


  // -- Element type -- 

  @js.native trait ListItemComponent extends js.Object { this: dom.HTMLElement => 

    /** 主文本。也可以通过 default slot 设置 */
    var headline: String | Unit

    /**
      * 主文本行数，超过限制后将截断显示。默认无行数限制。可选值包括：
      * 
      * * `1`：显示单行，超出后截断
      * * `2`：显示两行，超出后截断
      * * `3`：显示三行，超出后截断
      */
    var headlineLine: Int | Unit

    /** 副文本。也可以通过 `slot="description"` 设置 */
    var description: String | Unit

    /**
      * 副文本行数，超过限制后将截断显示。默认无行数限制。可选值包括：
      * 
      * * `1`：显示单行，超出后截断
      * * `2`：显示两行，超出后截断
      * * `3`：显示三行，超出后截断
      */
    var descriptionLine: Int | Unit

    /** 左侧的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
    var icon: String | Unit

    /** 右侧的 Material Icons 图标名。也可以通过 `slot="end-icon"` 设置 */
    var endIcon: String | Unit

    /** 是否禁用该列表项，禁用后，列表项将变为灰色，且其中的 [`<mdui-checkbox>`](/docs/2/components/checkbox)、[`<mdui-radio>`](/docs/2/components/radio)、[`<mdui-switch>`](/docs/2/components/switch) 等也将禁用 */
    var disabled: Boolean

    /** 是否激活该列表项 */
    var active: Boolean

    /** 是否使列表项不可点击。设置后，列表项中的 [`<mdui-checkbox>`](/docs/2/components/checkbox)、[`<mdui-radio>`](/docs/2/components/radio)、[`<mdui-switch>`](/docs/2/components/switch) 等仍可交互 */
    var nonclickable: Boolean

    /** 是否使用圆角形状的列表项 */
    var rounded: Boolean

    /**
      * 列表项的垂直对齐方式。可选值包括：
      * 
      * * `start`：顶部对齐
      * * `center`：居中对齐
      * * `end`：底部对齐
      */
    var alignment: String

    /**
      * 链接的目标 URL。
      * 
      * 如果设置了此属性，组件内部将渲染为 `<a>` 元素，并可以使用链接相关的属性。
      */
    var href: String

    /**
      * 下载链接的目标。
      * 
      * **Note**：仅在设置了 `href` 属性时，此属性才有效。
      */
    var download: String

    /**
      * 链接的打开方式。可选值包括：
      * 
      * * `_blank`：在新窗口中打开链接
      * * `_parent`：在父框架中打开链接
      * * `_self`：默认。在当前框架中打开链接
      * * `_top`：在整个窗口中打开链接
      * 
      * **Note**：仅在设置了 `href` 属性时，此属性才有效。
      */
    var target: String

    /**
      * 当前文档与被链接文档之间的关系。可选值包括：
      * 
      * * `alternate`：当前文档的替代版本
      * * `author`：当前文档或文章的作者
      * * `bookmark`：永久链接到最近的祖先章节
      * * `external`：引用的文档与当前文档不在同一站点
      * * `help`：链接到相关的帮助文档
      * * `license`：当前文档的主要内容由被引用文件的版权许可覆盖
      * * `me`：当前文档代表链接内容的所有者
      * * `next`：当前文档是系列中的一部分，被引用的文档是系列的下一个文档
      * * `nofollow`：当前文档的作者或发布者不认可被引用的文件
      * * `noreferrer`：不包含 `Referer` 头。类似于 `noopener` 的效果
      * * `opener`：如果超链接会创建一个顶级浏览上下文（即 `target` 属性值为 `_blank`），则创建一个辅助浏览上下文
      * * `prev`：当前文档是系列的一部分，被引用的文档是系列的上一个文档
      * * `search`：提供一个资源链接，可用于搜索当前文件及其相关页面
      * * `tag`：提供一个适用于当前文档的标签（由给定地址识别）
      * 
      * **Note**：仅在指定了 `href` 属性时可用。
      */
    var rel: String

    /** 是否在页面加载完成后自动获取焦点 */
    var autofocus: Boolean

    /** 元素在使用 Tab 键切换焦点时的顺序 */
    var tabIndex: Int
  }
}
