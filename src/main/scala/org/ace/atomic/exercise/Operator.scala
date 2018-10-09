package org.ace.atomic.exercise

/**
  * 定义操作符
  * 方法名可用符号，并使用中缀表示法
  * Created by LiangShujie
  * Date: 2018/10/8 16:55
  */
object Operator {
  def main(args: Array[String]): Unit = {
    val m1 = new Molecule(3)
    val m2  = new Molecule(4)
    println((m1.plus(m2)))
    println((m1.+(m2)))
    println((m1 + m2)) // 中缀表示法
  }

}

class Molecule(var value:Int) {
  def plus(other: Molecule): Molecule ={
    value += other.value
    this
  }
  def + (other:Molecule) = {
    value += other.value
    this
  }

  override def toString: String = value + ""
}
