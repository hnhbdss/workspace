def factorial(int factorialFor) {
  def cl
  
  cl = { int number, BigInteger total = 1 ->
    number == 1 ?
    total : cl.trampoline(number - 1, number * total)
  }.trampoline()
  cl(factorialFor)
}

println factorial(10000)