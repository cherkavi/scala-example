import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer

// https://docs.scala-lang.org/overviews/collections/performance-characteristics.html

println(">>> list")
val list = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)
val listInlineCreation = ("one" +: "two" +: "three" +: Nil)
println("> append ")
List("one","two")++"three"++Nil
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
println("> collect with matching as partial function")
list.collect({
  case "one"=>"o.n.e"
  case "two"=>"t.w.o"
  case _ => "unknown"
})

println("> collect with map as partial function")
list.collect(Map("one"->"o.n.e", "two"->"t.w.o","unknown"->"unknown"))

println("> collect with partial function as case switcher")
def partialFunctionWithSplit:PartialFunction[String, String] = {
  case s if s.length<=3 => s.split("").mkString(":")
  case rest @ _  => rest.split("").mkString("|")
}
list.collect(partialFunctionWithSplit)

println("> collect chain ")
def startWith:PartialFunction[String, String] = {
  case s if s.startsWith("o") => s
  case s if s.startsWith("t") => s
}
list.collect(partialFunctionWithSplit).collect(startWith)

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

