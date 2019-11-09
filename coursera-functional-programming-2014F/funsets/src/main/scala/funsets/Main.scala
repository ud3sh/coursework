package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  println(contains(singletonSet(4), 12))
  println(contains(singletonSet(4), 4))
  def odds :Set = (value:Int) => {value% 2 == 1}
  def evens :Set = (value:Int) => {value% 2 == 1}
  def negativeInt :Set = (value:Int) => {value < 1}
  def noneNegative:Set =(value:Int) => {value >= 0}
  def naturalNumbers:Set =(value:Int) => {value > 0}

 println("odds + evens, 1 : " + contains(union(odds, evens), 1))
 println("odds + negativeInt, 1: " + contains(union(odds, negativeInt), 1))
 println("odds + naturalNumbers, 1: " + contains(union(odds, naturalNumbers), 1))
 println("odds && negativeInt, 1:" + contains(intersect(odds, negativeInt), 1))



}
