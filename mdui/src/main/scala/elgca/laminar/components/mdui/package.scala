package elgca.laminar.components

package object mdui {

  import com.raquo.laminar.api.L.{*, given}

  val v = Var(false)
  val buf = new EventBus[Boolean]

  def f = {
    div(
      v.signal --> buf
//      Dropdown.open --> buf,
    )
  }

}
