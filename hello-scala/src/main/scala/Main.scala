import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
object Main extends App {
  // var is whats called a mutable variable, meaing after its been defined you can change it as you please
  var a: Int = 1
  a = 2

  //val is an immutable variable meaning once its set you cant change it 
  val b: Int = 1
  var c = 2

  var d: Long = 1
  var e: Double = 1.2 
  var f: Float = 1.5f
  var i: Boolean = true
  // you can assign multiple variables the same value at once like so
  val a1,a2,a3,a4 : Int = 300
  println(a1)
  println(a2)
  println(a3)
  println(a4)

  var string1: String = "Hello"
  var string2 = ", world!"
  println(string1 + string2)

  // print specific characters of the string like so
  println(string1.charAt(0))
  println(string1.charAt(1))
  println(string1.charAt(2))
  // replacing specific characters with another or more characters
  println(string1 + string2.replace("!", "!!!"))

  // tuples
  var coordinates = (5.6, 7.8)
  println(coordinates._1 + "-" + coordinates._2)

  var another = ("Hello", 5, true)
  println(another)

  var person = ("James", 25)
  val (name, age) = person 
  println(name)
  println(age)

  // string interpolation
  val firstname = "James"
  val lastname = "Calkins"
  println(s"My name is $lastname, $firstname, $lastname!")

  println(s"Random number is ${Random.nextInt(100)}")

  val bool = true 
  if (bool){
    println("true")
  }else
    println("false")

  println(if (!bool) "true" else "false")

  var x = 0
  do{
    println("do while")
    x+=1
  }while (x<5)

  var j = 0
  while(j<5){
    println(s"while $j")
    j+=1
  }

  // in a for loop "to" is inclusive of the ending number and until is exvlusive of the ending number
  for (y <- 1 to 10){
    println(s"for to $j")
  }
  for (z <- 0 until 10){
    println(s"for until $z")
  }

  var v = for(b <- 1 to 30 if b %3==0) yield b*b 
  for(b <- v){
    println(s"$b") 
  }


  // creating functions
  def sub(a: Int, b: Int): Int = {
    a-b
  }
  println(sub(5,3))

  // so this is a function that takes in another function and its parameters?????? i see no usecase for this if you do hmu
  def functionProvider(): (Int, Int) => Int = {
    // lamda function
    (a: Int, b: Int) => a-b
  }
  println(functionProvider()(10, 7))

  def mul(a: Int, b: Int): Int = {
    def multiply(a: Int, b:Int): Int = {
      a*b
    }
    multiply(a,b)
  }
  println(mul(3,4))

  //this function takes in 2 integers and a function as its parameters. this allows us to call on functions we've already created and run them inside this function.
  def applyThis(a: Int, b: Int, apply: (Int, Int)=> Int): Int = {
    apply(a,b)
  }
  println(applyThis(5,3,sub))
  println(applyThis(5,3,mul))
  def applyThis2(a: Int, b: Int)(apply: (Int, Int)=> Int): Int = {
    apply(a,b)
  }

  // implicit parameters
  // implicit paremeters are there so you don't have to provide that parameter. for instance a is a required parameter but since in the second set of parenthesis is implicit you dont have to fill that parameter
  def addConstant(a: Int)(implicit add: Int): Int = {
    a + add
  }
  implicit val constant = 100
  println(addConstant(5))

  //arrays 
  //this is an immutable array is has set values, you cannot remove values but you can replace them
  var numbers = Array(3,4,7)
  for (x<- numbers) println(x)
  numbers(0) = 100
  numbers(2)= 57
  for (x<- numbers) println(x)

  //here we are creating a mutable array
  var words = ArrayBuffer[String]()
  words += "book"
  words += "chair"
  words += "school"
  for (x<- words) println(x)
  //this foreach statement does the same thing as on line 139
  words.foreach(i => println(i))
  // and this is a more condensed version of the two
  words.foreach(println)

  //lists
  var immutableList = List[Int](1,2,3,4,5,6,7,8,9,10)
  for (x <- immutableList) println(x)

  var mutableList = ListBuffer[Int]()
  //simply appending to the list this shouldnt be too new
  mutableList.append(1).append(2).append(3)
  //doing the same as above but with one .append
  mutableList.appendAll(List(4,5,6))
  mutableList.foreach(println)
  //concatinating a list
  val x2 = 0 +: mutableList :+ 7 :++ List(8,9,10)
  x2.foreach(println)
  //this adds th to the end of each value
  x2.map(_ + "th").foreach(println)
  //this does the same but only does it to numbers and prints numbers moded by 2
  x2.filter(_ %2 == 0).map(_ +"th").foreach(println)

  //maps
  val hotelCountry = Map(
    "Plaza" -> "ES",
    "Premium Hotel" -> "US",
    "Premium Plaze" -> "US",
    "Family Hotel" -> "DE"
  )
  //grabbing the value of specific key
  println(hotelCountry.get("Premium Plaza"))

  //itterating through map and printing keys and values
  hotelCountry.foreach(x => println(s"for each ${x._1} - ${x._2}"))

  //if you wanted to specify the values that can go into your map just do like so 
  // val hotelCountry = Map[String, String](
  //   "Plaza" -> "ES",
  //   "Premium Hotel" -> "US",
  //   "Premium Plaze" -> "US",
  //   "Family Hotel" -> "DE"
  // )
}

trait Fruit{
  val calories: Int
  def eat(): Unit
}

trait PomeFruit{
  def doSomething(): Unit
}

class Apple(val calories: Int=35, var gram: Int = 10, var color: String = "Red") extends Fruit with PomeFruit{
  override def eat(): Unit = println(s"eating... $calories calories / $gram grams / color is $color")

  override def doSomething(): Unit = println("doing something...")
}
// so the easiest way i can explain traits is in video game terms. in video    games each enemy, teammate and sometimes objects have certain health values, how much damage they can do or damage a certain gun can do those are specific traits of the gun, character, or object same with traits! 
// if you've played siege here is a good example
// traits for ella's gun (var damage: Int = 20, var rps: Int = 6, var movementSpeed: Int = 7
// those variable make up the traits of ellas gun and how the gun can effect ella as well. i.e. movement speed effects how fast ella can run with this specific gun in her hand
object FoodTraits extends App {
  var apple = new Apple
  apple.gram = 13
  apple.eat()
  apple.doSomething()

}


// compound types
trait Animal 
trait Pet
class Cat extends Animal with Pet
class Tiger extends Animal

object petAnimals extends App{
  def feed(animal: Animal with Pet): Unit = println("feeding...")

  feed(new Cat)
  //since we've added to the feed function Animal with Pet we can only feed the classes (or animals whichever is easiest for you to understand) that extends both Animal and Pet and since Tiger is an animal but not a pet the code below would bring up errors
  //feed(new Tiger)
}

//Nested classes
class A(val a: Int){
  class B (val b: Int){

  }
  // you can instantiate class B ONLY IN CLASS A
  def createB(value: Int): B = new B(value)
  // now that we instantiated class B in class a we can use class a to call this function outside of a to insantiate class B
  // this can also be known as a private class as i've heard it called when learning java
}

object nestedClasses extends App{
  val a = new A(1)
  val b = a.createB(2)
}

//case classes
// these are like immutable objects. when you have an instance of the case class you cant change the values of the members
case class Aritcle(title: String, author: String, pages: Int)

object caseClass extends App{
  // good example here, we instantiated the article case class and gave it values. we cannot change those values now that they are set
  var article = new Aritcle("Hello World", "JJ Smith", 100)
  println(s"Article: ${article.title} - ${article.author}")
}

//singleton objects
object CoordinateUtils{
  def createCoordinates(): (Int, Int) = (1,7)
}

object singletonObject extends App{
  println(CoordinateUtils.createCoordinates())
}

//functions as objects
// here were creating an object that when you call on the object you provide the value needed and it will put that value into the function within the object
object Negate {
  def apply(value: Int): Int = -value 
}

object objectFunction extends App {
  println(Negate(7))
}

//generics 
// [A] allows us to tell the function what value type were going to be giving and returning i.e. String Int Double etc...
class Holder[A](value: A){
  def getVlaue(): A = value
}

object Generics extends App {
  val stringHolder = new Holder[String]("Hello World")
  val intHolder = new Holder[Int](42)
  println(stringHolder.getVlaue())
  println(intHolder.getVlaue())
}

//self types
trait Person {
  val name: String
}
//essentially what were doing here is allowing the speaker trait use a person trait without having to extend it 
//Simply put were mixing a trait with another trait without extending
trait Speaker{
  this:Person =>
    def say(something: String) = println(s"$name says: $something")
}
class newsAnnouncer(announcerName: String) extends Speaker with Person{
  val name = announcerName
}

object selfType extends App {
  val newsAnnouncer = new newsAnnouncer("Peter Peterson")
  newsAnnouncer.say("so much to say...")
}

// Implicit classes

import Helpers._
object Helpers {
  implicit class sayThis(times: Int){
    def say(say: String) = {
      for (i <- 0 until times)
      println(say)
    }
  }
}

object implicitClasses extends App {
  5 say("I am implicit")
}

//operators
// this allows us to kinda create our own operators. so were creating a class and allowing it to take in 3 values simple enoug. within that class tho we create a function that calls on the class its in to tell that class when its called it should do this. we give the function a plus sign to Vector knows that when to Vecotrs are being added it needs to do this. If you wanted one for subtract youd put a minus sign instead of the plus signs
case class Vector(x: Int, y: Int, z: Int){
  def +(other: Vector): Vector = {
    Vector(x + other.x, y + other.y, z + other.z)
  }
}

object Operators extends App{
  println(Vector(1,2,3) + Vector(3,2,1))
}

//Pattern Matching

// all were doing here is giving cases to x and telling x what to give the result value based on the value x is

//you can do this with classes too
object patternMatching extends App{
  val x: Int = Random.nextInt(5)

  val result = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }
  println(result)

  val tuples = List((1,0),(4,7),(3,12))

  tuples.foreach{
    case (left, right) => println(s"left: $left - right: $right")
  }
}