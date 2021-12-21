object Main extends App {
  println(Compositions.testCompose((a: Int) => BigInt(a))((b: BigInt) => b.toString)((c: String) => c.length)(23))
  println(Compositions.testMapFlatMap((a: Int) => Some(a.toString))((b: String) => Some(b.isBlank))((c: Boolean) => c.toString)(Some(2)))
  println(Compositions.testForComprehension((a: Int) => Some(a.toString))((b: String) => Some(b.isBlank))((c: Boolean) => c.toString)(Some(2)))
  println()

  println(RecursiveData.testListIntEmpty(Cons(1, Nil())))
  println(RecursiveData.testListIntHead(Nil()))
  println()

  println(RecursiveFunctions.testReverse(Cons(0, Cons(1, Cons(2, Nil())))))
  println(RecursiveFunctions.testMap(Cons(1, Cons(2, Cons(3, Nil()))), (item: Int) => Math.pow(item, 3)))
  println(RecursiveFunctions.testAppend(Cons(1, Cons(2, Cons(3, Nil()))), Cons(4, Cons(5, Cons(6, Nil())))))
  println(RecursiveFunctions.testFlatMap(Cons(1, Cons(2, Cons(3, Nil()))), (item: Int) => Cons(item, Cons(item * item, Nil()))))
  println(RecursiveFunctions.mostLeft(RecursiveData.Node(RecursiveData.Node(RecursiveData.Leaf(1), RecursiveData.Leaf(0)), RecursiveData.Leaf(0))))
}