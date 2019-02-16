import scala.annotation.tailrec

@tailrec
def sum(list: List[Int], accumulator: Int): Int = {
  list match {
    case Nil => accumulator
    case firstElement :: restOfList => sum(restOfList, accumulator + firstElement)
  }
}

sum(Range(1,10).toList, 0)
