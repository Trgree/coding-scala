package org.ace.study_scala.test

/**
  * 构造及辅助构造器
  * Created by LiangShujie
  * Date: 2018/9/29 9:40
  */
object ObjectSample {

  def main(args: Array[String]): Unit = {
    new Color();
    new Color(green = 2)
    new Color2(20)
    new Color2(Array(1,2))
  }
}

// 有默认参数时，部分参数可不填
class Color(val red:Int = 10, val green:Int = 100 ) {
  override def toString = s"Color($red, $green)"
}

// 使用辅助构造器
class Color2(val red:Int, val green:Int) {
  override def toString = s"Color2($red, $green)"
  def this(red:Int) { // 辅助构造器
    this(red, 100)
  }
  def this(arr: Array[Int]){ // 辅助构造器
    this(arr(0), arr(1))
  }
}

