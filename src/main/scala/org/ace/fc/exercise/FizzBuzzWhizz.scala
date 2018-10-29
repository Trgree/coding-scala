package org.ace.fc.exercise




/**
  * 写一个程序模拟报数，从1到n
  * 如果数字是3的倍数，不输出数字，替换为“Fizz”；如果是5的倍数，不输出数字，替换为“Buzz”；如果是7的倍数，替换为“Wizz”。
  * 如果有一个数字，同时是多个数字的倍数，则依次替换为对应的字符；如，21同时是3和7的倍数，替换为“FizzWizz”；
  * 如，15同时是3和5的倍数，替换为“FizzBuzz”；105同时是3,5,7的倍数替换为“FizzBuzzWizz”
  * 如果数字中含有3,5,7中的任何一个，则忽略上述规则，直接以第一个含有的数字对应的字符来表达，比如35替换为“Fizz” 请编写一个函数，实现上述4项描述，函数定义为：
  */
object FizzBuzzWhizz {

  def count(i:Int): Any ={
    go(new Rules(Pair(3,"Fizz")::Pair(5,"Buzz")::Pair(7,"Wizz")::Nil))(i)
  }

  def go(rules: Rules)(num:Int): Any ={
    val cont = containsNum(num, rules)
    if(cont != None){
      return cont.get
    }
    val result = multiple(num, rules)
    if(!result.isEmpty){
      return result
    }
    return num
  }

  /**
    * 如果数字中含有数组中的任何一个，直接以第一个含有的数字对应的字符来表达，比如35替换为“Fizz”
    */
  def containsNum(num: Int, rules: Rules): Option[String] = {
    num.toString.foreach(x => {
      val n = x.toString.toInt
      val rule = rules.getValue(n)
      if(rule != None){
        return Some(rule.get.word)
      }
    })
    None
  }

  /**
    * 如果有一个数字，同时是多个数字的倍数，则依次替换为对应的字符；如，21同时是3和7的倍数，替换为“FizzWizz”；
    */
  def multiple(num:Int, rules: Rules) :String={
    @annotation.tailrec
    def go(num:Int, pairs:List[Pair], result: String): String ={
     pairs match {
       case Nil => result
       case (h :: t) if(isAliquot(num, h.num))=> go(num, t, result + h.word)
       case (_ :: t) => go(num, t, result)
     }
    }
   go(num, rules.values, "")
  }

  /**
    * 是否整除
    */
  def isAliquot(n1:Int, n2:Int) : Boolean = n1 % n2 == 0

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

}

case class Pair(num :Int, word: String)
class Rules(var values: List[Pair]){
  def getValue(num : Int): Option[Pair] ={
    values.foreach(x => {
      if(x.num == num) {
        return Some(x)
      }
    })
    None
  }
}