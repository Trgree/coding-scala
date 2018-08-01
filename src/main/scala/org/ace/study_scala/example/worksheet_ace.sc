object worksheet_ace {
  println("Welcome to the Scala worksheet")
  var a = 3
  val b = 4
  println(a)
  lazy val c=a
	c
  a + a
  var d:Int=4
  c + a
  var e:AnyRef = new String("a")
  var f = new Integer(a) // java 引用类型
  var g:Long = c
  var h = ()
  var is:Unit = () // Void
  def foo() = throw new Exception("")
 	var name = "ace"
 	println(s"Hello ${name}!")
 	
 	
 	// call by value
 	def test1(x:Int, y:Int) = x * y
 	// call by name
 	def test2(x: => Int, y: => Int) = x * y
 	test1(3+2,3)  // 会先算出3+2，再传给x
 	test2(3+2,3)  // 相当于(3+2)*3
}