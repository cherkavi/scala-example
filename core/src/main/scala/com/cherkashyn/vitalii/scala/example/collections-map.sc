println("> Map")
val simpleMap = Map("one"->1, "two"->2, "three"->3)
for((key,value)<-simpleMap)yield key

println("> Map as function, join functions ")
val simpleMap2 = Map("four"->4, "five"->5, "six"->6, "seven"->7)

println("extend defined scope of 'partial function': "+simpleMap.applyOrElse("seven", simpleMap2))
println("extend defined scope of 'partial function' ask for unknown element: "+simpleMap.applyOrElse("not-exists", simpleMap2))
val simpleMap3 = Map(4->"*4*", 5->"*5*", 6->"*6*", 7->"*7*")
(simpleMap3 compose simpleMap2)("five")
