package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 纸片组件
  * 
  * ```html
  * <mdui-chip>Chip</mdui-chip>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/Chip.scala Chip.scala source code]]
  */
object Chip extends WebComponent("mdui-chip") {

  @JSImport("mdui/components/chip.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = Chip.type

  type Ref = ChipComponent & dom.HTMLElement


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  /** 表单字段验证未通过时触发 */
  lazy val onInvalid: EventProp[dom.Event] = eventProp("invalid")

  /** 选中状态变更时触发 */
  lazy val onChange: EventProp[dom.Event] = eventProp("change")

  /** 点击删除图标时触发 */
  lazy val onDelete: EventProp[dom.Event] = eventProp("delete")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

  /**
    * 纸片的形状。可选值包括：
    * 
    * * `assist`：用于显示与当前上下文相关的辅助操作，如在点餐页面提供分享、收藏等功能
    * * `filter`：用于对内容进行筛选，如在搜索结果页过滤搜索结果
    * * `input`：用于表示用户输入的信息片段，如在 Gmail 的“收件人”字段中的联系人
    * * `suggestion`：用于提供动态生成的推荐信息，以简化用户操作，如在聊天应用中预测用户可能想发送的信息
    */
  lazy val variant: CommonKeys.variant.type = CommonKeys.variant

  /** 是否显示阴影 */
  lazy val elevated: HtmlAttr[Boolean] = boolAttr("elevated")

  /** 是否可选中 */
  lazy val selectable: HtmlAttr[Boolean] = boolAttr("selectable")

  /** 是否已选中 */
  lazy val defaultSelected: HtmlAttr[Boolean] = boolAttr("selected")

  /** 是否可删除。为 `true` 时，纸片右侧会显示删除图标 */
  lazy val deletable: HtmlAttr[Boolean] = boolAttr("deletable")

  /** 左侧的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
  lazy val icon: HtmlAttr[String] = stringAttr("icon")

  /** 选中状态下左侧的 Material Icons 图标名。也可以通过 `slot="selected-icon"` 设置 */
  lazy val selectedIcon: HtmlAttr[String] = stringAttr("selected-icon")

  /** 右侧的 Material Icons 图标名。也可以通过 `slot="end-icon"` 设置 */
  lazy val endIcon: HtmlAttr[String] = stringAttr("end-icon")

  /** 可删除时，右侧删除图标的 Material Icons 图标名。也可以通过 `slot="delete-icon"` 设置 */
  lazy val deleteIcon: HtmlAttr[String] = stringAttr("delete-icon")

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

  /** 是否禁用 */
  lazy val disabled: HtmlAttr[Boolean] = boolAttr("disabled")

  /** 是否处于加载中状态 */
  lazy val loading: HtmlAttr[Boolean] = boolAttr("loading")

  /**
    * 按钮的名称，将与表单数据一起提交。
    * 
    * **Note**：仅在未设置 `href` 属性时，此属性才有效。
    */
  lazy val name: HtmlAttr[String] = stringAttr("name")

  /**
    * 按钮的初始值，将与表单数据一起提交。
    * 
    * **Note**：仅在未设置 `href` 属性时，此属性才有效。
    */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /**
    * 按钮的类型。默认类型为 `button`。可选类型包括：
    * 
    * * `submit`：点击按钮会提交表单数据到服务器
    * * `reset`：点击按钮会将表单中的所有字段重置为初始值
    * * `button`：此类型的按钮没有默认行为
    * 
    * **Note**：仅在未指定 `href` 属性时，此属性才有效。
    */
  lazy val `type`: CommonKeys.`type`.type = CommonKeys.`type`

  lazy val typ: HtmlAttr[String] = `type`

  lazy val tpe: HtmlAttr[String] = `type`

  /**
    * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
    * 
    * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
    * 
    * **Note**：仅在未指定 `href` 属性时，此属性才有效。
    */
  lazy val formId: HtmlAttr[String] = stringAttr("form")

  /**
    * 指定提交表单的 URL。
    * 
    * 如果指定了此属性，将覆盖 `<form>` 元素的 `action` 属性。
    * 
    * **Note**：仅在未指定 `href` 属性且 `type="submit"` 时，此属性才有效。
    */
  lazy val formAction: HtmlAttr[String] = stringAttr("formaction")

  /**
    * 指定提交表单到服务器的内容类型。可选值包括：
    * 
    * * `application/x-www-form-urlencoded`：未指定该属性时的默认值
    * * `multipart/form-data`：当表单包含 `<input type="file">` 元素时使用
    * * `text/plain`：HTML5 新增，用于调试
    * 
    * 如果指定了此属性，将覆盖 `<form>` 元素的 `enctype` 属性。
    * 
    * **Note**：仅在未指定 `href` 属性且 `type="submit"` 时，此属性才有效。
    */
  lazy val formEncType: CommonKeys.formEncType.type = CommonKeys.formEncType

  /**
    * 指定提交表单时使用的 HTTP 方法。可选值包括：
    * 
    * * `post`：表单数据包含在表单内容中，发送到服务器
    * * `get`：表单数据以 `?` 作为分隔符附加到表单的 URI 属性中，生成的 URI 发送到服务器。当表单没有副作用，并且仅包含 ASCII 字符时，使用此方法
    * 
    * 如果设置了此属性，将覆盖 `<form>` 元素的 `method` 属性。
    * 
    * **Note**：仅在未设置 `href` 属性且 `type="submit"` 时，此属性才有效。
    */
  lazy val formMethod: CommonKeys.formMethod.type = CommonKeys.formMethod

  /**
    * 如果设置了此属性，表单提交时将不执行表单验证。
    * 
    * 如果设置了此属性，将覆盖 `<form>` 元素的 `novalidate` 属性。
    * 
    * **Note**：仅在未设置 `href` 属性且 `type="submit"` 时，此属性才有效。
    */
  lazy val formNoValidate: HtmlAttr[Boolean] = boolAttr("formnovalidate")

  /**
    * 提交表单后接收到的响应应显示在何处。可选值包括：
    * 
    * * `_self`：默认选项，在当前框架中打开
    * * `_blank`：在新窗口中打开
    * * `_parent`：在父框架中打开
    * * `_top`：在整个窗口中打开
    * 
    * 如果设置了此属性，将覆盖 `<form>` 元素的 `target` 属性。
    * 
    * **Note**：仅在未设置 `href` 属性且 `type="submit"` 时，此属性才有效。
    */
  lazy val formTarget: CommonKeys.formTarget.type = CommonKeys.formTarget
  // -- CommonKeys --
  object CommonKeys extends CommonTypes {
    import com.raquo.laminar.codecs.StringAsIsCodec
    import com.raquo.laminar.keys.{EventProp, HtmlAttr, HtmlProp}
    import com.raquo.laminar.modifiers.KeySetter.HtmlAttrSetter

    object formMethod extends HtmlAttr[String]("formmethod", StringAsIsCodec) {

      lazy val post: HtmlAttrSetter[String] = formMethod("post")

      lazy val get: HtmlAttrSetter[String] = formMethod("get")
    }

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

    object variant extends HtmlAttr[String]("variant", StringAsIsCodec) {

      lazy val assist: HtmlAttrSetter[String] = variant("assist")

      lazy val filter: HtmlAttrSetter[String] = variant("filter")

      lazy val input: HtmlAttrSetter[String] = variant("input")

      lazy val suggestion: HtmlAttrSetter[String] = variant("suggestion")
    }

    object `type` extends HtmlAttr[String]("type", StringAsIsCodec) {

      lazy val submit: HtmlAttrSetter[String] = `type`("submit")

      lazy val reset: HtmlAttrSetter[String] = `type`("reset")

      lazy val button: HtmlAttrSetter[String] = `type`("button")
    }

    object formTarget extends HtmlAttr[String]("formtarget", StringAsIsCodec) {

      lazy val _self: HtmlAttrSetter[String] = formTarget("_self")

      lazy val _blank: HtmlAttrSetter[String] = formTarget("_blank")

      lazy val _parent: HtmlAttrSetter[String] = formTarget("_parent")

      lazy val _top: HtmlAttrSetter[String] = formTarget("_top")
    }

    object formEncType extends HtmlAttr[String]("formenctype", StringAsIsCodec) {

      lazy val `application/x-www-form-urlencoded`: HtmlAttrSetter[String] = formEncType("application/x-www-form-urlencoded")

      lazy val `multipart/form-data`: HtmlAttrSetter[String] = formEncType("multipart/form-data")

      lazy val `text/plain`: HtmlAttrSetter[String] = formEncType("text/plain")
    }

    object target extends HtmlAttr[String]("target", StringAsIsCodec) {

      lazy val _blank: HtmlAttrSetter[String] = target("_blank")

      lazy val _parent: HtmlAttrSetter[String] = target("_parent")

      lazy val _self: HtmlAttrSetter[String] = target("_self")

      lazy val _top: HtmlAttrSetter[String] = target("_top")
    }
  }


  // -- Props --

  /**
    * 按钮的初始值，将与表单数据一起提交。
    * 
    * **Note**：仅在未设置 `href` 属性时，此属性才有效。
    */
  lazy val value: HtmlProp[String, ?] = L.value


  // -- Slots --

  object slots {

    /** 纸片文本 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 左侧元素 */
    lazy val icon: Slot = Slot("icon")

    /** 右侧元素 */
    lazy val endIcon: Slot = Slot("end-icon")

    /** 选中状态下的左侧元素 */
    lazy val selectedIcon: Slot = Slot("selected-icon")

    /** 可删除时的右侧删除元素 */
    lazy val deleteIcon: Slot = Slot("delete-icon")
  }


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 内部的 `<button>` 或 `<a>` 元素 */
    lazy val button: String = "button"

    /** 纸片文本 */
    lazy val label: String = "label"

    /** 左侧图标 */
    lazy val icon: String = "icon"

    /** 右侧图标 */
    lazy val endIcon: String = "end-icon"

    /** 选中状态下的左侧图标 */
    lazy val selectedIcon: String = "selected-icon"

    /** 可删除时的右侧删除图标 */
    lazy val deleteIcon: String = "delete-icon"

    /** 加载中状态的 `<mdui-circular-progress>` 元素 */
    lazy val loading: String = "loading"
  }


  // -- Element type -- 

  @js.native trait ChipComponent extends js.Object { this: dom.HTMLElement => 

    /**
      * 纸片的形状。可选值包括：
      * 
      * * `assist`：用于显示与当前上下文相关的辅助操作，如在点餐页面提供分享、收藏等功能
      * * `filter`：用于对内容进行筛选，如在搜索结果页过滤搜索结果
      * * `input`：用于表示用户输入的信息片段，如在 Gmail 的“收件人”字段中的联系人
      * * `suggestion`：用于提供动态生成的推荐信息，以简化用户操作，如在聊天应用中预测用户可能想发送的信息
      */
    var variant: String

    /** 是否显示阴影 */
    var elevated: Boolean

    /** 是否可选中 */
    var selectable: Boolean

    /** 是否已选中 */
    var selected: Boolean

    /** 是否可删除。为 `true` 时，纸片右侧会显示删除图标 */
    var deletable: Boolean

    /** 左侧的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
    var icon: String | Unit

    /** 选中状态下左侧的 Material Icons 图标名。也可以通过 `slot="selected-icon"` 设置 */
    var selectedIcon: String | Unit

    /** 右侧的 Material Icons 图标名。也可以通过 `slot="end-icon"` 设置 */
    var endIcon: String | Unit

    /** 可删除时，右侧删除图标的 Material Icons 图标名。也可以通过 `slot="delete-icon"` 设置 */
    var deleteIcon: String | Unit

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

    /** 是否禁用 */
    var disabled: Boolean

    /** 是否处于加载中状态 */
    var loading: Boolean

    /**
      * 按钮的名称，将与表单数据一起提交。
      * 
      * **Note**：仅在未设置 `href` 属性时，此属性才有效。
      */
    var name: String

    /**
      * 按钮的初始值，将与表单数据一起提交。
      * 
      * **Note**：仅在未设置 `href` 属性时，此属性才有效。
      */
    var value: String

    /**
      * 按钮的类型。默认类型为 `button`。可选类型包括：
      * 
      * * `submit`：点击按钮会提交表单数据到服务器
      * * `reset`：点击按钮会将表单中的所有字段重置为初始值
      * * `button`：此类型的按钮没有默认行为
      * 
      * **Note**：仅在未指定 `href` 属性时，此属性才有效。
      */
    var `type`: String

    /**
      * 关联的 `<form>` 元素。此属性值应为同一页面中的一个 `<form>` 元素的 `id`。
      * 
      * 如果未指定此属性，则该元素必须是 `<form>` 元素的子元素。通过此属性，你可以将元素放置在页面的任何位置，而不仅仅是 `<form>` 元素的子元素。
      * 
      * **Note**：仅在未指定 `href` 属性时，此属性才有效。
      */
    var form: String | Unit

    /**
      * 指定提交表单的 URL。
      * 
      * 如果指定了此属性，将覆盖 `<form>` 元素的 `action` 属性。
      * 
      * **Note**：仅在未指定 `href` 属性且 `type="submit"` 时，此属性才有效。
      */
    var formAction: String | Unit

    /**
      * 指定提交表单到服务器的内容类型。可选值包括：
      * 
      * * `application/x-www-form-urlencoded`：未指定该属性时的默认值
      * * `multipart/form-data`：当表单包含 `<input type="file">` 元素时使用
      * * `text/plain`：HTML5 新增，用于调试
      * 
      * 如果指定了此属性，将覆盖 `<form>` 元素的 `enctype` 属性。
      * 
      * **Note**：仅在未指定 `href` 属性且 `type="submit"` 时，此属性才有效。
      */
    var formEnctype: String | Unit

    /**
      * 指定提交表单时使用的 HTTP 方法。可选值包括：
      * 
      * * `post`：表单数据包含在表单内容中，发送到服务器
      * * `get`：表单数据以 `?` 作为分隔符附加到表单的 URI 属性中，生成的 URI 发送到服务器。当表单没有副作用，并且仅包含 ASCII 字符时，使用此方法
      * 
      * 如果设置了此属性，将覆盖 `<form>` 元素的 `method` 属性。
      * 
      * **Note**：仅在未设置 `href` 属性且 `type="submit"` 时，此属性才有效。
      */
    var formMethod: String | Unit

    /**
      * 如果设置了此属性，表单提交时将不执行表单验证。
      * 
      * 如果设置了此属性，将覆盖 `<form>` 元素的 `novalidate` 属性。
      * 
      * **Note**：仅在未设置 `href` 属性且 `type="submit"` 时，此属性才有效。
      */
    var formNoValidate: Boolean

    /**
      * 提交表单后接收到的响应应显示在何处。可选值包括：
      * 
      * * `_self`：默认选项，在当前框架中打开
      * * `_blank`：在新窗口中打开
      * * `_parent`：在父框架中打开
      * * `_top`：在整个窗口中打开
      * 
      * 如果设置了此属性，将覆盖 `<form>` 元素的 `target` 属性。
      * 
      * **Note**：仅在未设置 `href` 属性且 `type="submit"` 时，此属性才有效。
      */
    var formTarget: String | Unit

    /** 表单验证状态对象，具体参见 [`ValidityState`](https://developer.mozilla.org/zh-CN/docs/Web/API/ValidityState) */
    val validity: org.scalajs.dom.ValidityState | Unit

    /** 如果表单验证未通过，此属性将包含提示信息。如果验证通过，此属性将为空字符串 */
    val validationMessage: String | Unit
  }
}
