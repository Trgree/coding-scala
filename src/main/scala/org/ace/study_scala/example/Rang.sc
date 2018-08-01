package org.ace

object Rang {
	1 to 10                                   //> res0: scala.collection.immutable.Range.Inclusive = Range 1 to 10
  val a = 1 to 10                                 //> a  : scala.collection.immutable.Range.Inclusive = Range 1 to 10
  val b = 1 until 10                              //> b  : scala.collection.immutable.Range = Range 1 until 10
  val c = 1 to 10 by 2                            //> c  : scala.collection.immutable.Range = inexact Range 1 to 10 by 2
  val d = a.toList                                //> d  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  
  
  var z = Array("Runoob", "Baidu", "Google")      //> z  : Array[String] = Array(Runoob, Baidu, Google)
  z(1)                                            //> res1: String = Baidu
  
  // Stream is a lazy List
  val e = 1 #:: 2 #:: 3 #:: Stream.empty          //> e  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  val f = (1 to 100000).toStream                  //> f  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  f.head                                          //> res2: Int = 1
  f.tail                                          //> res3: scala.collection.immutable.Stream[Int] = Stream(2, ?)
}