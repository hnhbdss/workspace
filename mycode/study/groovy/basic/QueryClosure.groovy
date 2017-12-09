def testClosure(closure) {
  println "$closure.maximumNumberOfParameters"

  for ( i in closure.parameterTypes) {
    println i.name
  }
}

testClosure { println "googd"}
testClosure { x , y -> println x + y} 