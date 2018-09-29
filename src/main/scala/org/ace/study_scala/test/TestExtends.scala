package org.ace.study_scala.test

/**
  * 继承
  * Created by LiangShujie
  * E-mail: liangshujie@fcbox.com
  * Date: 2018/8/1 10:52
  */
object TestExtends {
  def main(args: Array[String]): Unit = {
    val p = new Point(2,3)
    p.move(3,4)
    println("取到属性：" + p.x)

    val l = new Location(2,3,4)
    l.move(1,2,3)
    l.move(1,2)


  }
}

class Point(xc: Int, yc: Int) {
  var x : Int = xc
  var y : Int = yc

  def move(dx: Int, dy: Int): Unit ={
    x = x + dx
    y = y + dy
    println(s"x=$x,y=$y")
  }
}

class Location(xc:Int, yc:Int, zc: Int) extends Point(xc, yc){
  var z :Int = zc

  def move(dx:Int, dy:Int, dz:Int) = {
    x = x + dx
    y = y + dy
    z = z + dz
    println(s"x=$x,y=$y,z=$z")
  }

  /**
    * 重写非抽象函数，必须使用override关键字
    * @param dx
    * @param dy
    */
  override def move(dx: Int, dy: Int): Unit = {
    println("重写了")
    super.move(dx, dy) // super可以不用在第一行
  }
}