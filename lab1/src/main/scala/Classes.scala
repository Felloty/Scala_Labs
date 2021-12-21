package exercise1

/* This task has no tests. It is an exercise for you to write different class structures.
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String

 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }

 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 * 
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *    
 *     который проверяет ест ли животное определенную пищу
 * 
 * d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 * 
 * e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 * 
 * f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */

//class Animal(val name: String, val species: String, val food: String){
//  def eat(food: String): Boolean = this.food == food
//}

object Animal {
  val mamal = Mammal("cat", Meat())
  val bird =  Birds ("parrot", Vegetables())
  val fish = Fish("goldfish", Plants())

  def knowAnimals(name:String): Boolean = name == mamal.name || bird.name == name || fish.name == name;

  def apply(name:String): Option[Animal] = {
    name match{
      case "cat"=> Some(mamal)
      case "parrot"=>Some(bird)
      case "goldfish"=>Some(fish)
      case _ => None[Animal]()
    }
  }
}

sealed trait Animal{
  val name: String
  val food: Food
  def eat(food: Food): Boolean = this.food == food
}

case class Mammal(val name: String, val food: Food) extends Animal
case class Birds(val name: String, val food: Food) extends Animal
case class Fish(val name: String, val food: Food) extends Animal

sealed trait Food
case class Meat() extends Food
case class Vegetables() extends Food
case class Plants() extends Food

object Food{
  def apply(food: String): Option[Food]={
    food match {
      case "meat" => Some(Meat())
      case "plants" => Some(Plants())
      case "vegetables" => Some(Vegetables())
      case _ => None()
    }
  }
}

sealed trait Option[A] {
  def isEmpty: Boolean
}
case class Some[A](a: A) extends Option[A] {
  val isEmpty = false
}
case class None[A]()     extends Option[A] {
  val isEmpty = true
}