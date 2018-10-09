package org.ace.atomic.exercise

/**
  * 枚举类
  * Created by LiangShujie
  * Date: 2018/10/9 10:15
  */
object MonthName extends Enumeration {
 // type MonthName = Value
  val Jan,Feb = Value
  val Nov = Value(11)

  def main(args: Array[String]): Unit = {
    println(MonthName.Jan)
    println(MonthName.Jan.id)
    println(Nov.id)
  }
}


