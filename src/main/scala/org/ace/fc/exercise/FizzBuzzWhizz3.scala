package org.ace.fc.exercise

/**
  *
  * Created by LiangShujie
  * Date: 2018/10/19 13:41
  */
object FizzBuzzWhizz3 {
  def main(args: Array[String]): Unit = {
    test()
    println("passed")
  }

  def test() = {
    assert("Fizz".equals(count(9)))
    assert("Buzz".equals(count(5)))
    assert("Wizz".equals(count(7)))
    assert("Buzz".equals(count(15)))
    assert("Fizz".equals(count(35)))
    assert("FizzWizz".equals(count(21)))
    assert("FizzBuzzWizz".equals(count(210)))
    assert(4.equals(count(4)))
  }

  def count(i:Int): Any ={
    role(Map(3->"Fizz", 5->"Buzz", 7->"Wizz"))(i)
  }

  def role(map:Map[Int, String])(num:Int): Any ={
    //如果数字中含有数组中的任何一个，直接以第一个含有的数字对应的字符来表达，比如35替换为“Fizz”
    num.toString.foreach(x => {
      val n = x.toString.toInt
      if(map.contains(n)){
        return map(n)
      }
    })
    val result = multiple(num, map)
    if(!result.equals("")){
      return result
    }
    return num
  }

  /**
    * 是否整除
    * @param n1
    * @param n2
    * @return
    */
  def isAliquot(n1:Int, n2:Int) : Boolean = n1 % n2 == 0

  /**
    * 如果有一个数字，同时是多个数字的倍数，则依次替换为对应的字符；如，21同时是3和7的倍数，替换为“FizzWizz”；
    * @param num
    * @param map
    * @return
    */
  def multiple(num:Int, map:Map[Int, String]) :String={
    var result = ""
    map.foreach(kv => {
      val (k,v) = (kv._1,kv._2)
      if(isAliquot(num, k)) result += v
    })
    return result;
  }

}
