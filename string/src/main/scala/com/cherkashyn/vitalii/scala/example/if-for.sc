val stringValue = "my own vaue"
println(stringValue)
if (stringValue!=null){
  println("string exits")
}

checkForNull(stringValue)
checkForNull(null)


def checkForNull(value: String) {
  value match {
  case s if s!=null => println(s"input string [${s}] is NOT null")
  case s2 => println(s"input string [${s2}] is null ")
  }
}

def isNullString(v:String):Boolean = {
  if (v!=null) true else false
}

val anotherString = if(stringValue.startsWith("my")) stringValue else "unknown"

val newString = for(char <- anotherString) yield (char+1).asInstanceOf[Char]
println(newString)

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
for( (country, city) <- cities )print ( city)

val list = List("one" +: "two" +: "three"+: Nil)
for( (value) <- list){
  println(value)
}
val list2 = List("one" +: "two" +: "three")

val list3 = for(index <- 0 to 10 if index<5) yield index*index


// ------- loop for and break
import scala.util.control.Breaks._
import scala.util.control.Breaks

// example of break
breakable{
  for(i<-0.to(5)){
    if (i==2)break
    print(i)
  }
}

// example of break without Breaks
var shouldStop = false
for(i<- 0 to 5 if shouldStop==false){
  shouldStop = (i==3)
  print(i)
}

// example of continue
for(i<- 0 until 5){
  breakable({
    if(i==2)break
    print(i)
  })
}


// multi break example
val BreakLevel1 = new Breaks()
val BreakLevel2 = new Breaks()

BreakLevel1.breakable{
  for(i<- 1 to 5){
    BreakLevel2.breakable{
      for(j<-1 to 5){
        print(i + " " + j + " | " )
        if(i%2==1){
          println("BreakLevel2.break")
          BreakLevel2.break
        }
        if(j>3){
          println("BreakLevel1.break")
          BreakLevel1.break
        }
      }
    }
  }
}