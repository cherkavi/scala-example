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
    case     _ : Int            => ">integer<"
    case     _ : String         => ">string<"
    case  list @ List(1, 2, _)  => s">List(1,2,_) : ${list}<"
    case list2 @ List(5, 9, _*) => s">List started with 5 and 9 : ${list2}<"
    case     _ : List[String]   => ">List string<"
    case     _ : List[Int]      => ">List Int<"
    case                 (0, 5) => ">tuple 0,5<"
    case                      _ => ">unknown<"
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


sealed trait Employee{
  def name: String = ???
}
case class Worker(var wname:String) extends Employee{
  override def name = wname
}
case class Employer(var ename:String) extends Employee{
  override def name = ename
}
// companion object for Employee
object Employee {
  def unapply(employee: Employee): Option[Any] = Some(employee.name)
}

def matchCaseClass(v:Employee): Unit ={
  v match{
    case Worker(n) => println(s"worker name ${n}")
    case Employer(e) => println(s"employer name ${e}")
    case Employee(compObj) => println(s"object ${compObj}")
  }
}
matchCaseClass(new Worker("Petya"))
matchCaseClass(new Employer("Vasya"))
matchCaseClass(new Employee {
  override def name: String = "Kolya"
})