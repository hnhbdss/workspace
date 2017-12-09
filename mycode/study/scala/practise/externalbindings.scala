object holder {
  trait Foo
  object Foo {
    implicit val list = List(new Foo {} )
  }
}


