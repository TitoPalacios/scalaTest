/**
  * Created by Tito Palacios on 20/09/16.
  * Date: 20/09/16
  * Time: 19:00
  * ........
  * ........
  */
object myModule {
  def abs(n: Int): Int = if (n<0) -n else n

  def factorial(n: Int): Int ={
    def go(n: Int, acc: Int): Int =
      if (n <=0 ) acc
      else go(n-1, n*acc)
    go (n,1)
  }

  def fib(n: Int): Int = {
    def go(n: Int, s1:Int, s2:Int): Int = {
      if (n == 0) s1
      else go(n-1, s2, s1+s2)
    }
    go(n,0,1)

  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x,abs(x))
  }
  private def formatFac(x: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(x,factorial(x))
  }
  private def formatFib(x: Int) = {
    val msg = "The fibonacci number of %d is %d"
    msg.format(x,fib(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFac(4))
    println(formatFib(5))
  }

}
