val stringValue = "my own value"
println(stringValue)
if (stringValue!=null){
  println("string exits")
}


// ternary operator
val anotherString = if(stringValue.startsWith("my")) stringValue else "unknown"

// ternary condition into function
def isNullString(v:String):Boolean = {
  if (v!=null) true else false
}


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

// multiply counters, multipy guards
for{
  counter <- 0 until 10
  counter2 <- 0 until counter
  if counter!=1
  if counter2!=2
}   print(counter2)

// map loop "for"
val cities = Map("Germany"->"Berlin", "Ukraine"->"Kiev")
for( (_, city) <- cities )print ( city)

// last element "three" will be splitted by characters
val list = List("one" +: "two" +: "three")
// list loop "for"
for( (value) <- list){
  println(value)
}

// fix "mistake" with last element
val list2 = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)
for(el<-list2)yield el