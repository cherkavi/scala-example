import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer

// https://docs.scala-lang.org/overviews/collections/performance-characteristics.html
println(">>> array")
val array1 = Array("one","two", "three")
println("append element to array")
array1:+"four"
println("create sequence from element: array & string ")
array1+:"four"+:Nil

println(">>> list")
val list = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)
val listInlineCreation = ("one" +: "two" +: "three" +: Nil)
println("> list add element ")
var listNumbers = List(1,2,3,4)
println("> prepend")
0+:listNumbers
println("> append")
listNumbers:+5
println("> flatmap")
listNumbers.flatMap(number=>Range(0,number))


println("> zip operation with not enough elements ")
list.zip("A")
println("> head")
list.head
println("> tail ")
list.tail
println("> zip with tail - create tuple")
list.zip(list)
list.zip(list.tail)
list.zip(list.tail.tail)
List(1,2,3).zip(List(4,5,6)).map(t => t._1 + t._2)

println("> unzip ")
List( ("one","two"), ("two","three"), ("three","four") ).unzip
// cannot be executed
// List( (1,2,3),(4,5,6), (7,8,9) ).unzip

println("> list.map")
list.map(s=>s"-$s-")

println("> collect with partial function ")
list.collect(new PartialFunction[String, String](){
  override def isDefinedAt(x: String) = x.length()<=3
  override def apply(v1: String) = v1.split("").mkString("-")
})

println("> collect with partial function as map")
list.collect(Map("one"->"o.n.e", "two"->"t.w.o","unknown"->"unknown"))

println("> add element to list")
List("one","two")++"three"++Nil
println("add elements to list")
println("> collect with partial function as case switcher")
def pdf:PartialFunction[String, String] = {
  case s if s.length<=3 => s.split("").mkString(":")
  case rest @ _  => rest.split("").mkString("|")
}
list.collect(pdf)

println("> collect chain ")
def startWith:PartialFunction[String, String] = {
  case s if s.startsWith("o") => s
  case s if s.startsWith("t") => s
}
list.collect(pdf).collect(startWith)

println("> collect by type")
List(1,2,"three","four",5.0).collect({case x:Int=>x.toString})

println("> filter")
list.filter(_.length>3)

println("> add two maps")
val list3 = List("one", "two" )  ++  (for(i<-1 to 5)yield i.toString)

println("> split list to partitions")
list.asInstanceOf[List[String]].partition(_.length>3)

def checkLength(s:String):Boolean = {
  s.length>3
}
list.filter(checkLength(_))

println("> join both collections")
list++list


val groups = list.partition(_.length>3)
// List(groups._1, groups._2).flatMap(_)

println("> Map")
val simpleMap = Map("one"->1, "two"->2, "three"->3)
for((key,value)<-simpleMap)yield key

println("> Map as function, join functions ")
val simpleMap2 = Map("four"->4, "five"->5, "six"->6, "seven"->7)

println("extend defined scope of 'partial function': "+simpleMap.applyOrElse("seven", simpleMap2))
println("extend defined scope of 'partial function' ask for unknown element: "+simpleMap.applyOrElse("not-exists", simpleMap2))

println(">>> accumulators, buffers")
val arrayBuffer = new ArrayBuffer[Int]()
System.identityHashCode(arrayBuffer) // the same
arrayBuffer+=1;arrayBuffer+=2;arrayBuffer+=3
System.identityHashCode(arrayBuffer) // the same
arrayBuffer

val listBuffer = new ListBuffer[Int]()
System.identityHashCode(listBuffer) // the same
listBuffer+=1;listBuffer+=2;listBuffer+=3
System.identityHashCode(listBuffer) // the same
listBuffer

println(">>> sequence")
val seq1:Seq[Int] = (for(i <- 1 to 5)yield i)
def printSeq(a:Seq[String]) = a.foreach(print(_))
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

println(">>> set")
// https://docs.scala-lang.org/overviews/collections/sets.html
// set is a ancestor from x:T=>Boolean
val setOfInt:(Int=>Boolean) = Set(1,2,3,1,2,3)
setOfInt(2) // contains
val setOfInt2:(Set[Int]) = Set(5,6,5,6)
val setOfInt3:Set[Int] = setOfInt2 + (7, 8, 9, 8, 7) // -
setOfInt2 ++ Set(7,8,9,8,7) // --

println("> set boolean operations")
setOfInt2 union setOfInt3 // |
setOfInt2 intersect setOfInt3 // &|
setOfInt3 diff setOfInt2 // &~
//setOfInt3 retain setOfInt2
//setOfInt3 remove setOfInt2

println(">>> immutable map")
println(">>> each entry as a tuple")
val immutableMap = Map[String, String]("one"->"two", "three"->"four")
// immutableMap.foreach[Unit]( ( "", "") => print("values") )
for((k,v)<-immutableMap)println(s" $k  $v ")
immutableMap.foreach( entry=> {println(s"${entry._1}   ${entry._2}")} )

println(">>> mutable map")
val mutableMap = scala.collection.mutable.Map[String, String]()
mutableMap.put("one", "two")
mutableMap+=("three"->"four")

println(">>> convert mutable to immutable")
mutableMap.toMap

println(">>> zip two ranges (stop when one of the range ran out) and convert them into map ")
val zippedRange = (1 to 5).zip('a' to 'z').toMap

zippedRange(1)
// zippedRange(9)
zippedRange.get(1)
zippedRange.getOrElse(9, "z")

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