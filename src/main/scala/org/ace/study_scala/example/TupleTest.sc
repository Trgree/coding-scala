package org.ace

object TupleTest {
  (1,2)     // Pair                               //> res0: (Int, Int) = (1,2)
  1 -> 2    // Pair                               //> res1: (Int, Int) = (1,2)
 var t =  (1,"ace","Math",99.5)                   //> t  : (Int, String, String, Double) = (1,ace,Math,99.5)
 t._1                                             //> res2: Int = 1
 t._2                                             //> res3: String = ace
 var b = (1,"ace",("Math",99.5))                  //> b  : (Int, String, (String, Double)) = (1,ace,(Math,99.5))
 b._3._1                                          //> res4: String = Math
 
}