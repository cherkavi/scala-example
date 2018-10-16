val stringValue = "my own value"
println(stringValue)
if (stringValue!=null){
  println("string exits")
}

// if return value
val a = if(stringValue.length>0) 1 else 0

// ternary operator
val anotherString = if(stringValue.startsWith("my")) stringValue else "unknown"

// ternary condition into function
def isNullString(v:String):Boolean = {
  if (v!=null) true else false
}

println(">>> for loop with object, python style, iterator function <<<")
class MyCustomIterator(val begin:Int, val end:Int){
  /** method will be called implicitly during "for" instruction */
  def foreach( iteratorFunctionWithParameter:Int => Unit) :Unit ={
    for(i <- this.begin.until(this.end)) iteratorFunctionWithParameter(i)
  }
}
for(i<-new MyCustomIterator(10,20))print(s"${i} ")

println(">>> for loop<<<")
val newString = for(char <- anotherString) yield (char+1).asInstanceOf[Char]
println(newString)

val list3 = for(index <- 0 to 10 if index<5) yield index*index

for(counter<- 0 to 10 if counter%2 == 0)print(counter)

println("loop with step")
for(counter<-0 to (12,3))yield counter
for(counter<-0.to(12,3))yield counter

println("double loop with 'unitil' condition ")
for(counter <- 0 until 10 ;
    counter2 <- 0 until counter)print(counter2)

// multiply counters, multiply guards
for{
  counter <- 0 until 10
  counter2 <- 0 until counter
  if counter!=1
  if counter2!=2
}   print(counter2)

val cities = Map("Germany"->"Berlin", "Ukraine"->"Kiev", "Switzerland"->"Zurich")
println(s"elements inside map")
for( (_, city) <- cities )print ( city)
cities.keys
cities.values

// last element "three" will be splitted by characters
val list = List("one" +: "two" +: "three")
// list loop "for"
for( (value) <- list){
  println(value)
}

// fix "mistake" with last element
val list2 = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)
for(el<-list2)yield el