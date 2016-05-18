import sum_multiples.MultiplesSum

/**
  * Created by Jordan on 18/05/2016.
  */
object EulerProblemController {
  def main(args: Array[String]): Unit = {
    /*
    val a1 = List("1","2","3")
    val a2 = List("a", "b", "c")
    val a3 = List("z", "x", "y")

    val abomination = (a1, a2, a3).zipped.toList
    */

    var input = ""

    while(input != "q"){

      println("Enter option:")
      println("1: Sum multiples")

      println("q: quit")

      input = scala.io.StdIn.readLine()

      if(input == "1"){
        sumMainIO()
      } else if(input != "q"){
        println("Not valid")
      }

    }


  }

  def sumMainIO() : Unit ={
    var repeat = true
    var startPoint: Int = 0
    var endPoint: Int = 0
    var arguments: Array[Int] = null

    while(repeat){
      println("Enter lowest allowed multiple:")
      val str = scala.io.StdIn.readLine
      try{
        startPoint = str.toInt
        repeat = false
      } catch {
        case e: Exception => {
          println("Invalid input")
        }
      }
    }

    repeat = true

    while(repeat){
      println("Enter highest allowed multiple:")
      val str = scala.io.StdIn.readLine
      try{
        endPoint = str.toInt
        repeat = false
      } catch {
        case e: Exception => {
          println("Invalid input")
        }
      }
    }

    repeat = true

    while(repeat){
      println("Enter values to sum the multiples of, seperated by spaces")
      val str = scala.io.StdIn.readLine
      try{
        arguments = str.split(" ").map{s => s.toInt}
        repeat = false
      } catch {
        case e: Exception => {
          println("Invalid input")
        }
      }
    }

    println("Answer is: " + MultiplesSum.calculateSum(startPoint, endPoint, arguments))

  }

}
