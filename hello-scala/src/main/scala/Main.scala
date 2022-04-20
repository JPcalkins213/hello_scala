import scala.util.Random
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

  // so this is a function that takes in another function and its parameters??????
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
  // implicit paremeters are there so you don't have to provide that parameter. for instance a is a required parameter
  def addConstant(a: Int)(implicit add: Int): Int = {
    a + add
  }
}