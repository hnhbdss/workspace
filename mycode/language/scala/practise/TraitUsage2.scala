trait log {
  def log (msg :String) {}
}

trait ConsoleLog extends log {
  override def log (msg : String) {
    println(msg)
  }
}

trait PrefixA extends log {
  abstract override def log (msg : String) {
    super.log("A:" + msg)
  }
}

trait PrefixB extends log {
  abstract override def log (msg : String) {
    super.log("B:" + msg)
  }
}

abstract class Account extends log {
  def withdraw(a : Int) {
    if (a > 0) log("moneny is large")
  }
}

object main extends App {
  var o = new Account() with ConsoleLog with PrefixA with PrefixB
  o.withdraw(100)
  o = new Account() with ConsoleLog with PrefixB with PrefixA
  o.withdraw(100)
}
