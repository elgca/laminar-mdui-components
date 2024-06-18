package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{EventProp, HtmlProp, HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import com.raquo.laminar.nodes.Slot
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by ShoelaceGenerator.scala

/**
  * 侧边导航项组件。需配合 `<mdui-navigation-rail>` 组件使用
  * 
  * ```html
  * <mdui-navigation-rail>
  * ..<mdui-navigation-rail-item icon="watch_later">Recent</mdui-navigation-rail-item>
  * ..<mdui-navigation-rail-item icon="image">Images</mdui-navigation-rail-item>
  * ..<mdui-navigation-rail-item icon="library_music">Library</mdui-navigation-rail-item>
  * </mdui-navigation-rail>
  * ```
  * 
  * [[https://github.com/raquo/laminar-shoelace-components/blob/master/sample/src/main/scala/elgca/laminar/components/mdui/NavigationRailItem.scala NavigationRailItem.scala source code]]
  */
object NavigationRailItem extends WebComponent("mdui-navigation-rail-item") {

  @JSImport("@shoelace-style/shoelace/dist/components/navigation-rail-item/navigation-rail-item.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = NavigationRailItem.type

  type Ref = NavigationRailItemComponent & dom.HTMLElement


  // -- Events --

  /** 获得焦点时触发 */
  lazy val onFocus: EventProp[dom.Event] = eventProp("focus")

  /** 失去焦点时触发 */
  lazy val onBlur: EventProp[dom.Event] = eventProp("blur")

  lazy val onKeydown: EventProp[dom.Event] = eventProp("keydown")


  // -- Attributes --

  /** 未激活状态下的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
  lazy val icon: HtmlAttr[String] = stringAttr("icon")

  /** 激活状态下的 Material Icons 图标名。也可以通过 `slot="active-icon"` 设置 */
  lazy val activeIcon: HtmlAttr[String] = stringAttr("active-icon")

  /** 导航项的值 */
  lazy val defaultValue: HtmlAttr[String] = stringAttr("value")

  /** 是否为激活状态，由 `<mdui-navigation-rail>` 组件控制该参数 */
  lazy val active: HtmlAttr[Boolean] = boolAttr("active")

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
  lazy val rel: HtmlAttr[String] = stringAttr("rel")

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


  // -- Props --

  /** 导航项的值 */
  lazy val value: HtmlProp[String, ?] = stringProp("value")


  // -- Slots --

  object slots {

    /** 文本内容 Note: You can just say `_ => element` instead of `_.slots.default(element)` */
    lazy val default: Slot = Slot("")

    /** 图标 */
    lazy val icon: Slot = Slot("icon")

    /** 激活状态的图标 */
    lazy val activeIcon: Slot = Slot("active-icon")

    /** 徽标 */
    lazy val badge: Slot = Slot("badge")
  }


  // -- CSS Vars --

  /** 指示器的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCornerIndicator: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner-indicator")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 导航项容器 */
    lazy val container: String = "container"

    /** 指示器 */
    lazy val indicator: String = "indicator"

    /** 徽标 */
    lazy val badge: String = "badge"

    /** 图标 */
    lazy val icon: String = "icon"

    /** 激活状态的图标 */
    lazy val activeIcon: String = "active-icon"

    /** 文本内容 */
    lazy val label: String = "label"
  }


  // -- Element type -- 

  @js.native trait NavigationRailItemComponent extends js.Object { this: dom.HTMLElement => 

    /** 未激活状态下的 Material Icons 图标名。也可以通过 `slot="icon"` 设置 */
    var icon: String | Unit

    /** 激活状态下的 Material Icons 图标名。也可以通过 `slot="active-icon"` 设置 */
    var activeIcon: String | Unit

    /** 导航项的值 */
    var value: String | Unit

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
