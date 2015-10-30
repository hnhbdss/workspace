object Enum extends Enumeration {
       type MyEnum = Value
       val Red, Blue, Black = Value
       val Green = Value(100, "GREEN")
}

object Main extends App {
       for (i <- Enum.values) {
       	   println(i.toString + ":" + i.id )
       }
}
