
// 多行表达式
var c = {
  val a=1
  val b=2
  a + b
}



List.range(1, 10).reverse.take(3).sum/10
"1".map(x => x - 0).sum
val a = '1' - '0'
Nil.isInstanceOf[AnyRef]

null.isInstanceOf[Any]

for {
  a <- List.range(1, 3)
  (_, b) <- Map("a" -> 1)
  c <- Seq(4, 5)
  d <- Some(2)
  if a < 2; if c > 4
}  yield(a, b, c - 4, d - 1)



val m = Map("b" -> 2, 15 -> 3, "a" -> 4)
m.foreach(println(_))
m.getOrElse()