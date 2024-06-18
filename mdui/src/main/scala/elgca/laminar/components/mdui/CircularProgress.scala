package elgca.laminar.components.mdui

import com.raquo.laminar.keys.{HtmlProp, HtmlAttr}
import com.raquo.laminar.api.L
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSImport

// This file is generated at compile-time by WebComponentsGenerator.scala

/**
  * 圆形进度指示器组件
  * 
  * ```html
  * <mdui-circular-progress></mdui-circular-progress>
  * ```
  * 
  * [[mdui/src/main/scala/mdui/src/main/scala/elgca/laminar/components/mdui/CircularProgress.scala CircularProgress.scala source code]]
  */
object CircularProgress extends WebComponent("mdui-circular-progress") {

  @JSImport("mdui/components/circular-progress/circular-progress.js", JSImport.Namespace)
  @js.native object RawImport extends js.Object

  type Self = CircularProgress.type

  type Ref = CircularProgressComponent & dom.HTMLElement


  // -- Events --


  // -- Attributes --

  /** 进度指示器的最大值。默认为 `1` */
  lazy val max: HtmlAttr[Int] = intAttr("max")

  /** 进度指示器的当前值。如果未指定该值，则显示为不确定状态 */
  lazy val defaultValue: HtmlAttr[Int] = intAttr("value")


  // -- Props --

  /** 进度指示器的当前值。如果未指定该值，则显示为不确定状态 */
  lazy val value: HtmlProp[Int, ?] = intProp("value")


  // -- Slots --

  /** This component has no slots - don't give it any children. */
  @inline def noSlots: Unit = ()


  // -- CSS Vars --


  // -- CSS Parts --

  /** This component has no CSS parts. */
  @inline def noCssParts: Unit = ()


  // -- Element type -- 

  @js.native trait CircularProgressComponent extends js.Object { this: dom.HTMLElement => 

    /** 进度指示器的最大值。默认为 `1` */
    var max: Int

    /** 进度指示器的当前值。如果未指定该值，则显示为不确定状态 */
    var value: Int | Unit
  }
}
