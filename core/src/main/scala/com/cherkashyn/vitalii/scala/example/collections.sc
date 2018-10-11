import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer

println(">>> list")
val list = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)
val listInlineCreation = ("one" +: "two" +: "three" +: Nil)
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

println("> map")
list.map(s=>s"-$s-")
// list.asInstanceOf[List[String]].partition(_.length>3)
list.filter(_.length>0)

val list3 = List("one", "two" )  ++  (for(i<-1 to 5)yield i.toString)



def checkLength(s:String):Boolean = {
  s.length>3
}
list.filter(checkLength(_))

println("> join both collections")
list++list


val groups = list.partition(_.length>3)
// List(groups._1, groups._2).flatMap(_)


val simpleMap = Map("one"->"1", "two"->"2", "three"->"3")
for((key,value)<-simpleMap)yield key

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
val seq1:Seq[Int] = (for(i<-1 to 5)yield i)
def printSeq(a:Seq[String]) = a.foreach(print(_))
printSeq(seq1.map(_.toString+" "))


println(">>> set")
// set is a ancestor from x:T=>Boolean
val setOfInt:(Int=>Boolean) = Set(1,2,3,1,2,3)
setOfInt(2) // contains
val setOfInt2:(Set[Int]) = Set(5,6,5,6)
val setOfInt3:Set[Int] = setOfInt2 + (7, 8, 9, 8, 7) // -
setOfInt2 ++ Set(7,8,9,8,7) // --

setOfInt2 intersect setOfInt3 // & |
setOfInt3 diff setOfInt2 // &~

//setOfInt3 retain setOfInt2
//setOfInt3 remove setOfInt2

println(">>> immutable map")
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