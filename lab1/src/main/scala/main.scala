package exercise1

object Main extends App {
  println(Animal.apply("cat"))
  println(Animal.fish.eat(Meat()))
  println(Animal.knowAnimals("cat"))
  println(Food.apply("meat"))

  println(Functions.testCircle(2))
  println(Functions.testRectangleCurried(2, 2))
  println(Functions.testRectangleUc(2, 2))

  println(HigherOrder.testNTimes(((a: Int, b: Int) => a + b), 2, 2, 3))
  println(HigherOrder.testAnonymousNTimes(2, 3, 4))

  println(PatternMatching.testIntToString(1))
  println(PatternMatching.testIsMaxAndMoritz("Max"))
  println(PatternMatching.testIsEven(2))
  println(PatternMatching.testWinsA(PatternMatching.Rock, PatternMatching.Scissor))
  println(PatternMatching.testExtractMammalWeight(new PatternMatching.Mammal("cat", PatternMatching.Meat, 10)))
  println(PatternMatching.testUpdateFood(new PatternMatching.Fish("goldfish", PatternMatching.Vegetables)))
}