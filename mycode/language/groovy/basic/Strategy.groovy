def totalSelectValues(n, filter) {
  total = 0
  for (i in 1..n) {
    if (filter(i)) {
      total += i;
    }
  }
  total
}

isOdd  = { it % 2 != 0 }
isEven = { it % 2 == 0 }
isAll =  { true }
println totalSelectValues(10, isOdd)
println totalSelectValues(10, isEven)
println totalSelectValues(10,  isAll)

