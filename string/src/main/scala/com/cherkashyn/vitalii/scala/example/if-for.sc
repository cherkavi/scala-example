val stringValue = "my own value"
println(stringValue)
if (stringValue!=null){
  println("string exits")
}


def isNullString(v:String):Boolean = {
  if (v!=null) true else false
}

val anotherString = if(stringValue.startsWith("my")) stringValue else "unknown"


val newString = for(char <- anotherString) yield (char+1).asInstanceOf[Char]
println(newString)

val list3 = for(index <- 0 to 10 if index<5) yield index*index

for(counter<- 0 to 10 if counter%2 == 0)print(counter)

for(counter <- 0 until 10 ; counter2 <- 0 until counter) {
  print(counter2)
}

for{
  counter <- 0 until 10
  counter2 <- 0 until counter
  if counter!=1
  if counter2!=2
}   print(counter2)

val cities = Map("Germany"->"Berlin", "Ukraine"->"Kiev")
for( (_, city) <- cities )print ( city)

// last element "three" will be splitted by characters
val list = List("one" +: "two" +: "three")
for( (value) <- list){
  println(value)
}
val list2 = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)

