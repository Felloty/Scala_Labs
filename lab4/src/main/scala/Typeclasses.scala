package Lab_ex4

object Typeclasses {

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.

  trait Reversable[T] {
    def reverse(a: T): T
  }

  object Reversable {
    def reverse[T](a: T)(implicit reversable: Reversable[T]): T = reversable.reverse(a)
  }

  // b) Реализуйте функцию Reverse для String.

  implicit object ReversableString extends Reversable[String] {
    override def reverse(str: String) = str.reverse
  }

  // примените тайп-класс-решение из пункта (a) здесь
  def testReversableString(str: String): String = Reversable.reverse(str)

  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.

  trait Smash[T] {
    def apply(a: T, b: T): T
  }

  object Smash {
    def smash[T](a: T, b: T)(implicit smash: Smash[T]): T = smash.apply(a, b)
  }

  // d) Реализуйте  функции Smash для типа Int и Double.
  //    Используйте сложение для типа Int у умножение для типа Double.

  implicit object SmashInt extends Smash[Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  implicit object SmashDouble extends Smash[Double] {
    override def apply(a: Double, b: Double): Double = a * b
  }

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = Smash.smash(a, b)

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashDouble(a: Double, b: Double): Double = Smash.smash(a, b)


  // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра. 

  implicit object SmashString extends Smash[String] {
    override def apply(a: String, b: String): String = a.concat(b)
  }

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashString(a: String, b: String): String = Smash.smash(a, b)
}

// Реализуйте тестовые функции с выводом на экран проверки разработанных функций.