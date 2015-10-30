class Handler {
  def f1() {
    println "f1 called from Handler"
  }

  def f2() {
    println "f2 called from Handler"
  }

}

class Example {
  
  def f1() {
    println "f1 called from Example"
  }

  def f2() {
    println "f2 called from Example"
  }

  def foo(closure1) {
    def closure = closure1.clone()
    closure.delegate = new Handler()
    closure()
  }
}

def f1() {
  println "f1 call from script"
}

def c = {
  println this
  println owner
  f1()
  f2()
}

new Example().foo (c)
