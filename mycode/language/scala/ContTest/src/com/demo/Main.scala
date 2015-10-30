package com.demo

/**
 * Created by lili on 15-8-15.
 */
object Main extends App{

  def qsort[T <% Ordered[T]](list : List[T]) : List[T] = {
    list match {
      case Nil => Nil
      case x :: other =>
        val (before, after) = other partition (_ < x)
        qsort(before) ++ (x :: qsort(after))
    }
  }

  val org = List(5, 4, 1, 2, 3)
  println(org)
  println(qsort(org))
}
