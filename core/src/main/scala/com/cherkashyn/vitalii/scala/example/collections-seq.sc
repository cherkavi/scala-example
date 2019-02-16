println(">>> sequence")
val seq1: Seq[Int] = for(each <- 1 to 5) yield each
def printSeq(a:Seq[String]) : Unit = a.foreach(print(_))
printSeq(seq1.map(_.toString+" "))

println("> forall ")
seq1.forall( x => x>0 )

println("> reduce ")
seq1.reduce((accumulator, nextValue)=> accumulator+nextValue)

println("> foldLeft")
seq1.foldLeft[Int](100){
  case(accumulator, nextValue)=>accumulator+nextValue
}
seq1.foldRight[Int](100){
  case(accumulator, nextValue)=>accumulator+nextValue
}
seq1.fold[Int](100){
  case(accumulator, nextValue)=>accumulator+nextValue
}

println("> exists")
seq1.exists(p => p>100)

println("> find")
seq1.find(p=> p==3).getOrElse(99)

println("> group by key")
seq1.groupBy(each=> if(each>=3)"three" else "zero")

println("> takeWhile ")
seq1.takeWhile(p => p<3)

println("> dropWhile ")
seq1.dropWhile(p => p<3)

println("> product")
seq1.product
