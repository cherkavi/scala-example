
println(">>> set")
// https://docs.scala-lang.org/overviews/collections/sets.html
// set is a ancestor from x:T=>Boolean
val setOfInt: Int=>Boolean = Set(1,2,3,1,2,3)
setOfInt(2) // contains
val setOfInt2: Set[Int] = Set(5,6,5,6)
val setOfInt3: Set[Int] = setOfInt2 + (7, 8, 9, 8, 7) // -
setOfInt2 ++ Set(7,8,9,8,7) // --

println("> set boolean operations")
setOfInt2 union setOfInt3 // |
setOfInt2 intersect setOfInt3 // &|
setOfInt3 diff setOfInt2 // &~
//setOfInt3 retain setOfInt2
//setOfInt3 remove setOfInt2

