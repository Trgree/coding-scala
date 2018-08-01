package org.ace

object MapTest {
  var m = Map(1 ->"a",2 -> "b")                   //> m  : scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b)
  var m2 = Map((3,"c"),(4,"d"))                   //> m2  : scala.collection.immutable.Map[Int,String] = Map(3 -> c, 4 -> d)
  m(1)                                            //> res0: String = a
  m.contains(2)                                   //> res1: Boolean = true
  m.keys                                          //> res2: Iterable[Int] = Set(1, 2)
  m.values                                        //> res3: Iterable[String] = MapLike.DefaultValuesIterable(a, b)
  m + (4 -> "e")  // 新的map                        //> res4: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 4 -> 
                                                  //| e)
                  
 var m3 =  m - (1)                                //> m3  : scala.collection.immutable.Map[Int,String] = Map(2 -> b)
 // + 多个
 m ++ m2                                          //> res5: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -> 
                                                  //| c, 4 -> d)
 m ++ List(6->"f" ,7 -> "g")                      //> res6: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 6 -> 
                                                  //| f, 7 -> g)
 // -多个
 m -- List(1,2,3)                                 //> res7: scala.collection.immutable.Map[Int,String] = Map()
 println(m)                                       //> Map(1 -> a, 2 -> b)
}