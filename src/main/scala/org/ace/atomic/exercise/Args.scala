package org.ace.atomic.exercise

/**
  *
  * Created by LiangShujie
  * E-mail: liangshujie@fcbox.com
  * Date: 2018/9/19 11:34
  */
object Args {
  def main(args: Array[String]): Unit = {
    val ca = new ClassArg(12)
    ca.f()
    // ca.a  // error
    val ca2 = new ClassArg2(2)
    val ca3 = new ClassArg3(3)
    ca2.a = 4  // 可变
    println(ca2.a) // 类参数定义为var或val才可见
    println(ca3.a)

    println(new Sum(12,34,5).result())
    new ClassArg4(red=20);// 参数有默认值时，可以不传
  }
}

class ClassArg(a: Int) {
  println(f)
  def f():Int = { a * 10}
}

class ClassArg2(var a: Int)
class ClassArg3(val a: Int)
class ClassArg4(red:Int = 1,green:Int = 2)


class Sum(args:Int*) { // 使用* 表示 可变元参数
  def result():Int = {
    var total = 0;
    for(n <- args){
      total += n
    }
    total
  }
}



