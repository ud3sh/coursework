package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0) {
      0
    } else {
      if (c == 0 && r == 0) {
        1
      } else {
        pascal(c - 1, r - 1) + pascal(c, r - 1)
      }
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def isOpen(c: Char): Boolean = {
      c == '('
    }
    def isClose(c: Char) = {
      c == ')'
    }

    def isBalanced(str: List[Char], count: Int): Boolean = {
      if (count < 0) {
        false;
      } else if (str.isEmpty) {
        count == 0;
      } else {
        if (isOpen(str.head)) {
          isBalanced(str.tail, count + 1);
        } else if (isClose(str.head)) {
          count >= 0 && isBalanced(str.tail, count - 1);
        } else {
          isBalanced(str.tail, count);
        }
      }

    }
    isBalanced(chars, 0);
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def count(amt: Int, coinList: List[Int]): Int = {
      if (amt == 0) {
        1
      } else if (amt < 0) {
        0
      } else if (amt > 0 && coinList.isEmpty) {
        0
      } else {
        count(amt, coinList.tail) + count(amt - coinList.head, coinList)
      }
    }

    count(money, coins)
  }
}
