val stringValue = "my own vaue"

def checkForNull(value: String) {
  value match {
    case s if s!=null => println(s"input string [${s}] is NOT null")
    case s2 => println(s"input string [${s2}] is null ")
  }
}
checkForNull(stringValue)
checkForNull(null)

val list = ("one" +: "two" +: "three")
//  list = List("one", "two", "three")


import scala.annotation.switch
println(list)
val searchValue:String = list(1).asInstanceOf[String]
// (searchValue : @switch )
val multiOperator:Int = searchValue match{
  case "one" => 1
  case "two" | "four" | "six" => 2
  case "three" | "five" => 3
}

def defineType(x:Any):String={
  x match{
    case _: Int => ">integer<"
    case _: String => ">string<"
    case List(1, 2, _) => ">List(1,2,_)<"
    case List(5, 9, _*) => ">List started with 5 and 9<"
    case _: List[String] => ">List string<"
    case _: List[Int] => ">List Int<"
    case (0, 5) => ">tuple 0,5<"
    case _ => ">unknown<"
  }
}
println(defineType(1))

println(defineType("String"))

val listInt1 = List(1, 2, 3)
println(defineType(listInt1))

val listInt2 = List(5, 9, 10, 12, 15)
println(defineType(listInt2))

println(defineType(List("one","two", "three")))

println(defineType((0,5)))
