val stringValue = "my own value"

// match with guard
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

println("@switch annotation")
import scala.annotation.switch
val searchValue:String = list(1).asInstanceOf[String]
// condition will be compiled into decision tree
// otherwise each time walk through all conditions
val multiOperator:Int = (searchValue: @switch) match{
  case "one" => 1
  case "two" | "four" | "six" => 2
  case s if s=="three" | s=="five" => 3
    // example of assigning "anything" to variable and use it further
  case rest @ _  => rest.length
}


println("match with type and with certain values into types")
def defineType(x:Any):String={
  x match{
    case     _ : Int            => ">integer<"
    case     _ : String         => ">string<"
    case  list @ List(1, 2, _)  => s">List(1,2,_) : ${list}<"
    case list2 @ List(5, 9, _*) => s">List started with 5 and 9 : ${list2}<"
    case     _ : List[String]   => ">List string<"
    case     _ : List[Int]      => ">List Int<"
    case                 (0, 5) => ">tuple (0, 5)<"
    // case                 (_*)   => ">tuple<"
    case                      _ => ">unknown<"
  }
}
println(defineType(1))
println(defineType("String"))
println(defineType(List(1, 2, 3)))
println(defineType(List(5, 9, 10, 12, 15)))
println(defineType(List("one","two", "three")))
println(defineType((0,5)))
println(defineType((4,3,5,7)))
println(defineType(35L))


println("match according the case class, unapply method ")
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
  // method will be used by "match"
  def unapply(employee: Employee): Option[String] = Some(employee.name)
}

def matchCaseClass(v:Employee): Unit ={
  v match{
    case Worker(n) => println(s"worker name ${n}")
    // case with guard
    case Employer(e) if e=="Vasya" => println(s"employer Vasya")
    case Employer(e) => println(s"employer name ${e}")
    case Employee(compObj) => println(s"object ${compObj}")
  }
}
matchCaseClass(new Worker("Petya"))
matchCaseClass(new Employer("Vasya"))
matchCaseClass(new Employee {
  override def name: String = "Kolya"
})


println(" match lists ")
def matchList(x:Any) = x match {
  // take first element (s1) of the list and rest (s2) of list
  case s1 :: s2 => println(s"$s1  $s2")
  // Nil - empty list
  case Nil => println("empty collection")
}
matchList(List("one", "two", "three"))
matchList(List())
matchList(Seq[String]())
matchList(new Iterator[String]{
  override def hasNext = false
  override def next() = null
})

