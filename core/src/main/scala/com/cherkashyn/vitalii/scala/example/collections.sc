import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer

println(">>> list")
val list = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)

list.map(s=>s"-$s-")
// list.asInstanceOf[List[String]].partition(_.length>3)
list.filter(_.length>0)

val list2 = List("one", "two" )  ++  (for(i<-1 to 5)yield i.toString)



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