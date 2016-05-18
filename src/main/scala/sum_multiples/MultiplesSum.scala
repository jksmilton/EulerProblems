package sum_multiples
/**
  * Created by Jordan on 18/05/2016.
  */
object MultiplesSum {


  /**
    * calculates the sum of the the multiples of all arguments between start and end
    * @param startPoint
    *                   lowest multiple allowed
    * @param endPoint
    *                 highest multiple allowed
    * @param arguments
    *                  values to find the multiples of
    * @return
    */
  def calculateSum(startPoint: Int, endPoint: Int, arguments: Array[Int]): Int ={

    val startPoints = arguments.map{(x: Int) => calculateFirstMultiplier(x, startPoint)}
    val endPoints = arguments.map{(x: Int) => calculateLastMultiplier(x, endPoint)}

    val newList = (startPoints, endPoints, arguments).zipped.toList
// println("highest: " + b + "; v: " + c) ;
    newList.map{case(a: Int, b: Int, c: Int) => doAllMultiplications(a, b, c)}.reduceLeft(_+_)

  }

  /**
    * calculates the last value to multiply by
    * @param value
    *              value to be multiplied
    * @param start
    *              beginning point
    * @return
    *         the first value that when multiplied by value gives a result greater than start
    */
  def calculateFirstMultiplier(value: Int, start: Int) : Int = {
    val res = start.toFloat / value.toFloat
    math.ceil(res).toInt
  }

  /**
    * Calculates the last value to
    * @param value
    *              The value you want to use
    * @param end
    *            The max result
    * @return
    *         the largest number you can multiply value by without being larger than end
    */
  def calculateLastMultiplier(value: Int, end: Int) : Int = {
    val res = end.toFloat / value.toFloat
    math.floor(res).toInt
  }

  def doAllMultiplications(start: Int, end: Int, value: Int): Int = {
    var total = 0
    for(i <- start to end ){
      total += i * value
    }
    total
  }

}
