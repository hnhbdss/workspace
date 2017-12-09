object NumberExtract {
  def unapply(input : String) : Option[Int] = {
    try {
      Some(Integer.parseInt(input))
    }
    catch {
      case ex : NumberFormatException => None
    }
  }
}

object isComponent {
  def unapply(input : String) = input.contains(" ")
}

object main extends App {
  val NumberExtract(n) = "100"
  println(n)

  val a = "hello world"
  a match {
    case isComponent() => println("good")
    case _ => println("bad")
  }
}
