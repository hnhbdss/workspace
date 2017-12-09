import scala.util.continuations._
import java.io._

object Main extends App {
  var cont : (Unit => Unit) = null

  reset {
    println("Before shift")

    shift {
      k : (Unit => Unit) => {
        cont = k
        println("Inside shift")
      }
    }

    println("After shift")
  }

  println("After reset")

  cont()
}
