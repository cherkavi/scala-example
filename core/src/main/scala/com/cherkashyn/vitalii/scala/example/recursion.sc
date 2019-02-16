import scala.annotation.tailrec

@tailrec
def sum(list: List[Int], accumulator: Int): Int = {
  list match {
    case Nil => accumulator
    case x :: xs => sum(xs, accumulator + x)
  }
}

sum(Range(1,10).toList, 0)
