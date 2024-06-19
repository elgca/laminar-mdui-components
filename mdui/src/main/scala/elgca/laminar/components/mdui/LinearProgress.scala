package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlProp, HtmlAttr, StyleProp}
import com.raquo.laminar.api.L
import com.raquo.laminar.defs.styles.{traits as s, units as u}
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 线性进度指示器组件
  * 
  * ```html
  * <mdui-linear-progress></mdui-linear-progress>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/LinearProgress.scala LinearProgress.scala source code]]
  */
object LinearProgress extends WebComponent("mdui-linear-progress") {

  @JSImport("mdui/components/linear-progress.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = LinearProgress.type

  type Ref = LinearProgressComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /** 进度指示器的最大值。默认为 `1` */
  lazy val max: HtmlAttr[Int] = intAttr("max")

  /** 进度指示器的当前值。如果未指定该值，则处于不确定状态 */
  lazy val defaultValue: HtmlAttr[Int] = intAttr("value")


  // -- Props --

  /** 进度指示器的当前值。如果未指定该值，则处于不确定状态 */
  lazy val value: HtmlProp[Int, ?] = intProp("value")


  // -- Slots --

  /** This component has no slots - don't give it any children. */
  @inline def noSlots: Unit = ()


  // -- CSS Vars --

  /** 组件的圆角大小。可以指定一个具体的像素值；但更推荐引用[设计令牌](/docs/2/styles/design-tokens#shape-corner) */
  lazy val shapeCorner: StyleProp[String] & u.Length[DSP, Int] = lengthStyle("--shape-corner")


  // -- CSS Parts --

  /** For documentation only. You need to style these from a CSS stylesheet. */
  object cssParts {

    /** 指示器部分 */
    lazy val indicator: String = "indicator"
  }


  // -- Element type -- 

  @js.native trait LinearProgressComponent extends js.Object { this: dom.HTMLElement => 

    /** 进度指示器的最大值。默认为 `1` */
    var max: Int

    /** 进度指示器的当前值。如果未指定该值，则处于不确定状态 */
    var value: Int | Unit
  }
}
