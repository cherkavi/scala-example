def getPosition():(Int, Int) = {
  ( math.rint(math.random*100).toInt,
    math.rint(math.random*100).toInt)
}

// Tuple1..Tuple22
def getPosition2():Tuple2[Int, Int] = {
  ( math.rint(math.random*100).toInt,
    math.rint(math.random*100).toInt)
}

val (x,y) = getPosition()
val position =  getPosition2()
position._1
position._2

// syntax sugar
val protocol = ("http" -> 1)
protocol._1
protocol._2