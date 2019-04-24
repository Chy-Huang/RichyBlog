object testDemo{
  def main(args: Array[String]): Unit = {
    Test()
    println("hello world!")
    printString("Scala","Java","Python")//可变函数
    for (i <- 1 to 10){
      println(i + " 的阶乘为：= " + factorial(i))
    }
  }

  def Test(): Unit ={
    val colors = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")

    val nums: Map[Int, Int] = Map()

    println( "colors 中的键为 : " + colors.keys )
    println( "colors 中的值为 : " + colors.values )
    println( "检测 colors 是否为空 : " + colors.isEmpty )
    println( "检测 nums 是否为空 : " + nums.isEmpty )
  }
  def printString( args:String* ): Unit ={
    var i :Int = 0;
    for (arg <- args){
      println("Arg value[" + i + "] = " +arg)
      i = i +1;
    }
  }
  def factorial(n: BigInt): BigInt={
    if(n <= 1)
      1
    else
      n * factorial(n - 1)
  }

}
