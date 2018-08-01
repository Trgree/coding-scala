package org.ace

object other_examples {
	
	
	def str2int(str:String, defVal:Int) = {
	  try{
	  	Integer.parseInt(str)
	  } catch{
	  	case ex: Exception => defVal
	  } finally{
	  	println("always be printed")
	  }
  }                                               //> str2int: (str: String, defVal: Int)Int
  
  str2int("2",1)                                  //> always be printed
                                                  //| res0: Int = 2
  var result_try = try {
  	Integer.parseInt("dog")
  } catch{
  	case _ => 0
  } finally {
  	println("always be printed")
  }                                               //> always be printed
                                                  //| result_try  : Int = 0
   val code=4                                     //> code  : Int = 4
   var result_match = code match {
   		case 1 => "one"
   		case 2 => "two"
   		case 3 => "three"
   		case _ => "other"
   }                                              //> result_match  : String = other
}