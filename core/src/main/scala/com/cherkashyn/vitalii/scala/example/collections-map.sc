println("> immutable Map")
val simpleMap = Map("one"->1, "two"->2, "three"->3)
for((key,value)<-simpleMap)yield key

println("> Map as function, join functions ")
val simpleMap2 = Map("four"->4, "five"->5, "six"->6, "seven"->7)

println("extend defined scope of 'partial function': "+simpleMap.applyOrElse("seven", simpleMap2))
println("extend defined scope of 'partial function' ask for unknown element: "+simpleMap.applyOrElse("not-exists", simpleMap2))
val simpleMap3 = Map(4->"*4*", 5->"*5*", 6->"*6*", 7->"*7*")
(simpleMap3 compose simpleMap2)("five")


println(">>> each entry as a tuple")
val immutableMap = Map[String, String]("one"->"two", "three"->"four")
// immutableMap.foreach[Unit]( ( "", "") => print("values") )
for((k,v)<-immutableMap)println(s" $k  $v ")
immutableMap.foreach( entry=> {println(s"${entry._1}   ${entry._2}")} )

println("> mutable map")
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

