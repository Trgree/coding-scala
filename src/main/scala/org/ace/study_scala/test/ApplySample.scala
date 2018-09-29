package org.ace.study_scala.test

/**
  *
  * Created by LiangShujie
  * Date: 2018/9/29 9:55
  */

object ApplySample {

  def main(args: Array[String]): Unit = {
    val a = Goo()  // Object 中的apply
    a()  // class 中的 apply

    val arr = new Array[Int](3)
    val array = Array(1,2,3)
  }
}

class Goo{
  def apply() =println("class apply")
}

object Goo{
  def apply()={
    println("object apply")
    new Goo
  }
}


