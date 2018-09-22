val a="abcdabcdabcdabcdabcd"

a substring (5, 12)
a(0)+""+a(1)+""+a(2)

// java.lang.String
a.getClass.getName

// true - no symbol 'x' into string
a.forall(p=>p != "x")

a.foreach(a=>print(a))

for(eachChar <- a) print(eachChar)

for(i <- 0 to a.length-1 if a.charAt(i)!='a')print(a.charAt(i))

// Array[Byte]
a.getBytes()

 val b:String = "abcd"
// true
a=="""abcd
    |abcdabcd
    |abcdabcd"""

// true
a==new java.lang.String(s"${b}abcdabcdabcdabcd")

val c:Double = 2.54
println(f"format double value: $c%.3f ")

// remove some symbols
var withoutA = for{eachChar<-a if eachChar != 'a'} yield eachChar
var withoutA2 = a.filter(eachChar=>eachChar!='a')
println(withoutA == withoutA2)



import scala.util.matching.Regex

val regularExpression = new Regex("cdab")
regularExpression.findFirstIn(a).getOrElse("not found");
// replaceAll, replaceAllIn, replaceFirstIn

val regPattern = "abcd".r
// val regPattern(value) = a
// println(s"this is result of regular expression pattern: $value")


// extends class functionality
implicit class MyOwnStringImprovements(s:String){
  def constantValue = s.length+""
  def charCount:Int = s.length
}

a.constantValue
"some string".charCount

// scala.io.Source.fromURL("localhost:8387/rest/endpoint").mkString()