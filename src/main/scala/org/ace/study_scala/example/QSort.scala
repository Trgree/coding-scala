package org.ace.study_scala.example

// 快速排序
object QSort extends App {
  def qSort(l : List[Int]):List[Int] = {
    if(l.length < 2) l
    else {
      qSort(l.filter(_ < l.head)) ++ l.filter(_ == l.head) ++  qSort(l.filter(_ > l.head))
    }
  }
  
  println(qSort(List(3,5,1,2,9,5,3)))
}