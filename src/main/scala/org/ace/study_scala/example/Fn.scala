package org.ace.study_scala.example

/**
 * 计算 f(n)+f(n+1)++f(n+2)+f(n+3)..+f(m)
 */
object Fn extends App {
  
   // 递归，计算很多次时会StackOverflow
  def sum(f: Int => Int)(x: Int)(y: Int): Long = {
    if (x <= y)
      f(x) + sum(f)(x + 1)(y)
    else
      0
  }
  
  def sum2(f: Int => Int)(x: Int)(y: Int): Long = {
    @annotation.tailrec // 尾递归，计算很多次也不会StackOverflow
    def loop(n:Int, acc:Long):Long={
      if(n > y) acc
      else loop(n + 1, acc + f(n))
    }
    loop(x, 0)
  }

 println(sum(x => x * x)(1)(3000))
 println(sum2(x => x * x)(1)(30000000))

}