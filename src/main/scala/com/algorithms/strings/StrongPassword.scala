import java.io.PrintWriter
import scala.io.StdIn

object StrongPassword {
  val numbers = "0123456789"
  val lower_case = "abcdefghijklmnopqrstuvwxyz"
  val upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val special_characters = "!@#$%^&*()-+"

  def intersectsP(pass: String, lookup: String): Boolean ={
    ((pass.toSet intersect lookup.toSet).size >0)
  }

  // Complete the minimumNumber function below.
  def minimumNumber(n: Int, password: String): Int = {
    // Return the minimum number of characters to make the password strong
    var numOfCharsToAdd=0
    if (!intersectsP(password, numbers)) numOfCharsToAdd+=1
    if (!intersectsP(password, lower_case)) numOfCharsToAdd+=1
    if (!intersectsP(password, upper_case)) numOfCharsToAdd+=1
    if (!intersectsP(password, special_characters)) numOfCharsToAdd+=1
    val toMake6Chars=6 - (numOfCharsToAdd + password.length())

    if (toMake6Chars>0) {
      numOfCharsToAdd + toMake6Chars
    } else {
      numOfCharsToAdd
    }
  }

  /* 
   Test cases to run in sbt 
   runMain StrongPassword 11 #Ha1 
   2 

   */
  def main(args: Array[String]) {
    val n = args(0).toInt
    if ((n >=1) && (n<=100)) {
      val password = args(1)
      val answer = minimumNumber(n, password)
      println(answer)
    }
  }
}

