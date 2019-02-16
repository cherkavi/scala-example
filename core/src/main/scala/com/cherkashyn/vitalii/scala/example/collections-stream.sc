println(">>> stream")
println("> predefined stream ")
val streamFinite:Stream[Int] = 1 #:: 2 #:: 3 #:: 4 #:: Stream.empty

println("> infinite stream ")
val streamInfinite:Stream[Int] =
  1 #:: 2 #:: Stream.from(3)
streamInfinite.take(5).toArray

val streamInfinite2:Stream[Int] =
  1 #:: 2 #:: streamInfinite2
streamInfinite2.take(5).toArray

val streamInfinite3:Stream[Int] =
  1 #:: 2 #:: streamInfinite3
streamInfinite3.tail.take(5).toArray

val streamInfinite4:Stream[Int] =
  1 #:: 2 #:: streamInfinite4.zip(streamInfinite4.tail).map(each=>each._1+each._2)
streamInfinite4.take(5).toArray