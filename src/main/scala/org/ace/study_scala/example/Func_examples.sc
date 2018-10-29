package org.ace

import java.util.Date

object Func_examples {
  def hello(name: String): String = {
    s"Hello ${name}"
  }                                               //> Hello: (name: String)String
  hello("ace")                                    //> res0: String = Hello ace

  def hello2(name: String) = { // 自动识别返回值类型
    s"Hello ${name}"
  }                                               //> hello2: (name: String)String
  def hello3(name: String) = s"Hello ${name}"     //> hello3: (name: String)String

  hello2("ace")                                   //> res1: String = Hello ace

  def add(x: Int, y: Int) = x + y                 //> add: (x: Int, y: Int)Int
  add(5, 6)                                       //> res2: Int = 11

  // 高阶函数,输入参数为一个函数(这个函数输入是2个Int,返回是Int)
  def operate(f: (Int, Int) => Int) = {
    f(4, 4)
  }                                               //> operate: (f: (Int, Int) => Int)Int

  def operate2(f: (String) => String) = {
    f("ace2")
  }                                               //> operate2: (f: String => String)String

  def operate3(f: (String) => String, v: String) = {
    f(v)
  }
  operate(add)
  operate((a, b) => a+b)

  //> operate3: (f: String => String, v: String)String
  operate2(hello3) //输入参数是hello3,而不是hello3()      //> res3: String = Hello ace2
  operate2(s => s"Hello2 ${s}")
  operate3(hello3, "haha")                        //> res4: String = Hello haha

  def apply(f: Int => String, v: Int) = f(v)      //> apply: (f: Int => String, v: Int)String
  def layout[A](x: A) = "[" + x.toString() + "]"  //> layout: [A](x: A)String
  apply(layout, 10)                               //> res5: String = [10]

  // 高阶函数,返回值是函数
  var greeting = (name: String) => s"Hello ${name}"
                                                  //> greeting  : String => String = org.ace.Func_examples$$$Lambda$12/483422889@7
                                                  //| c75222b
  greeting("ace2")                                //> res6: String = Hello ace2
  //匿名函数，以上的(name: String) => s"Hello ${name}" 就是
  var add2 = (x: Int, y: Int) => x + y            //> add2  : (Int, Int) => Int = org.ace.Func_examples$$$Lambda$13/93122545@7c30a
                                                  //| 502
  add2(3, 4)                                      //> res7: Int = 7

  // 不设置参数
  var userDir = () => { System.getProperty("user.dir") }
                                                  //> userDir  : () => String = org.ace.Func_examples$$$Lambda$14/1239731077@2133
                                                  //| c8f8
  userDir()                                       //> res8: String = F:\develop\Eclipse\scala-SDK-4.6.1-vfinal-2.12-win32.win32.x
                                                  //| 86_64\eclipse

  //正常函数
  def add3(x: Int, y: Int) = x + y                //> add3: (x: Int, y: Int)Int
  // 柯里化函数
  def curriedAdd(x: Int)(y: Int) = x + y          //> curriedAdd: (x: Int)(y: Int)Int
  curriedAdd(2)(3)                                //> res9: Int = 5

  val addone = curriedAdd(1)_ // 即 curriedAdd(1)(_:Int)
                                                  //> addone  : Int => Int = org.ace.Func_examples$$$Lambda$15/997110508@1e643faf
                                                  //| 
  var addone2 = (x: Int) => curriedAdd(1)(x)      //> addone2  : Int => Int = org.ace.Func_examples$$$Lambda$16/1854778591@7a79be
                                                  //| 86
  addone(3)                                       //> res10: Int = 4
  addone2(2)                                      //> res11: Int = 3


  def log(date: Date, msg: String) = println(date + "----" + msg)
                                                  //> log: (date: java.util.Date, msg: String)Unit
  val date = new Date                             //> date  : java.util.Date = Sun Jul 23 00:09:15 CST 2017
  // 偏应用函数，不用新定义函数，只需要使用把新的函数值的索引的赋给变量
  val logWithDateBound = log(date, _: String)     //> logWithDateBound  : String => Unit = org.ace.Func_examples$$$Lambda$17/9200
                                                  //| 11586@39ba5a14
  // 正常函数
  val logWithDateBound2 = (msg: String) => log(date, msg)
                                                  //> logWithDateBound2  : String => Unit = org.ace.Func_examples$$$Lambda$18/136
                                                  //| 0767589@340f438e
  logWithDateBound("message1")                    //> Sun Jul 23 00:09:15 CST 2017----message1
  logWithDateBound2("message1")                   //> Sun Jul 23 00:09:15 CST 2017----message1

  // 递归函数，需要多个栈,
  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }                                               //> factorial: (n: Int)Int
  factorial(3)                                    //> res12: Int = 6
  
  // 尾递归,只需要一个栈,m保留上个函数的结果
//  @annotation.tailrec   // 加上注解
  def factorial2(n:Int, m:Int): Int  = {
  	if(n <=0 ) m
  	else factorial2(n - 1, m * n)
  }                                               //> factorial2: (n: Int, m: Int)Int
  factorial2(3, 1)                                //> res13: Int = 6
}