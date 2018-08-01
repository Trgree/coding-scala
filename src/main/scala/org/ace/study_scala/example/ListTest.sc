package org.ace

object ListTest {
	// 列表创建
  val a = List(1, 2, 3, 4)                        //> a  : List[Int] = List(1, 2, 3, 4)
  var empty = Nil                                 //> empty  : scala.collection.immutable.Nil.type = List()
  var g = List()                                  //> g  : List[Nothing] = List()
  var f = 1 :: 2 :: 3 :: Nil                      //> f  : List[Int] = List(1, 2, 3)
  
  a(1)                                            //> res0: Int = 2
  
  // 添加元素
  val b = 0 :: a                                  //> b  : List[Int] = List(0, 1, 2, 3, 4)
  var c = 2 +: a                                  //> c  : List[Int] = List(2, 1, 2, 3, 4)
  var d = b :: a                                  //> d  : List[Any] = List(List(0, 1, 2, 3, 4), 1, 2, 3, 4)
  // 列表连接
  var e = b ::: a                                 //> e  : List[Int] = List(0, 1, 2, 3, 4, 1, 2, 3, 4)
  var e2 = List.concat(a, b)                      //> e2  : List[Int] = List(1, 2, 3, 4, 0, 1, 2, 3, 4)
  var e3 = b.:::(a)                               //> e3  : List[Int] = List(1, 2, 3, 4, 0, 1, 2, 3, 4)
  // 二维
  var h = (1 :: 2 ::3 :: Nil)::(4 :: 5 ::6 :: Nil)::(7 :: 8 ::9 :: Nil)::Nil
                                                  //> h  : List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
  // 列表操作
  val i = a.head                                  //> i  : Int = 1
  val j = a.tail                                  //> j  : List[Int] = List(2, 3, 4)
  j.isEmpty                                       //> res1: Boolean = false
  val k = List.fill(3)("hello")                   //> k  : List[String] = List(hello, hello, hello)
  var l = a.reverse                               //> l  : List[Int] = List(4, 3, 2, 1)
  a.contains(3)                                   //> res2: Boolean = true
  
  
  // 遍历
   a.foreach(println)                             //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  // Iterator（迭代器）不是一个集合，它是一种用于访问集合的方法。
	  val it = Iterator("Baidu", "Google", "Runoob", "Taobao")
                                                  //> it  : Iterator[String] = non-empty iterator
	  var n = a.iterator                      //> n  : Iterator[Int] = non-empty iterator
	  println("the max is:" + n.max )         //> the max is:4
	  while(n.hasNext){
	  	println(n.next)
	  }
	  
    // 高阶函数
   a.filter(s => s > 2 )                          //> res3: List[Int] = List(3, 4)
   a.filter(_ > 2)                                //> res4: List[Int] = List(3, 4)
  "99 Red Ball".toList                            //> res5: List[Char] = List(9, 9,  , R, e, d,  , B, a, l, l)
	 "99 Red Ball".toList.filter(x => Character.isDigit(x))
                                                  //> res6: List[Char] = List(9, 9)
   "99 Red Ball".toList.takeWhile(x => x != 'B')  //> res7: List[Char] = List(9, 9,  , R, e, d,  )
	 
	 //通过给定的方法将所有元素重新计算
	 var biga =  a.map(x => x + 1000)         //> biga  : List[Int] = List(1001, 1002, 1003, 1004)
	 var big2 = a.map(_ + 1000)               //> big2  : List[Int] = List(1001, 1002, 1003, 1004)
	 k.map(_.toUpperCase())                   //> res8: List[String] = List(HELLO, HELLO, HELLO)
	 h.map(x => x.filter(x => x % 2 == 0))    //> res9: List[List[Int]] = List(List(2), List(4, 6), List(8))
	 h.flatMap(x => x)                        //> res10: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
	 h.flatMap(x => x.filter(x => x % 2 == 0))//> res11: List[Int] = List(2, 4, 6, 8)
	 h.flatMap(_.filter(_ % 2 == 0)) // 返回的是x //> res12: List[Int] = List(2, 4, 6, 8)
	 a.reduceLeft((x,y) => x + y)             //> res13: Int = 10
	 a.reduceLeft(_ + _)                      //> res14: Int = 10
	 // 0 + a(1) + a(2) + ...
	 a.foldLeft(0)((x, y) => x + y)// 返回的是x,即输入的初始值类型
                                                  //> res15: Int = 10
	 a.foldLeft(0)(_ + _)                     //> res16: Int = 10
	 // 1 * a(1) * a(2) * ...
	 a.foldLeft(1)(_ * _)                     //> res17: Int = 24
	 // a(1)*a(1) + a(2)*a(2) + a(3)*a(3)
	 a.foldLeft(0)((z,v) => z + v * v)        //> res18: Int = 30
	 
	 //求List的元素个数，元素和，元素平方和
	 def sumSq(l : List[Int]) : (Int, Int, Int)= l.foldLeft(0,0,0)((t, v) => (t._1 + 1, t._2 + v, t._3 + v * v))
                                                  //> sumSq: (l: List[Int])(Int, Int, Int)
    sumSq(a)                                      //> res19: (Int, Int, Int) = (4,10,30)
}