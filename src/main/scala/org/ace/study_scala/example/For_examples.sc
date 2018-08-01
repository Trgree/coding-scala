package org.ace

object For_examples {
  var l = List("ace", "trgree", "lsj")            //> l  : List[String] = List(ace, trgree, lsj)

  for (
    s <- l
  ) println(s)                                    //> ace
                                                  //| trgree
                                                  //| lsj
  for(i <- l){
  	println(i)                                //> ace
                                                  //| trgree
                                                  //| lsj
  }
   for(i <-0 until l.length){
  	println(l(i))                             //> ace
                                                  //| trgree
                                                  //| lsj
  }
  
  for (
    s <- l
    if (s.length() == 3) // filter
  ) println(s)                                    //> ace
                                                  //| lsj
  var upper_for = for {
    s <- l
    s1 = s.toUpperCase()
    if (s1 != "")
  } yield (s1) // 导出，把s1放在新的collection            //> upper_for  : List[String] = List(ACE, TRGREE, LSJ)
  
  for(i <- 1 to 3){
  	println(i)                                //> 1
                                                  //| 2
                                                  //| 3
  }
  
   for(i <- 1 until 3){
  	println(i)                                //> 1
                                                  //| 2
  }
  
 
  
}