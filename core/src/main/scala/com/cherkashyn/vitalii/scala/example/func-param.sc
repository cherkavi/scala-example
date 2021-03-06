val list = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)

// return value - function
def lengthThree:  String=>Boolean = v=>v.length>3
// apply function as definition
list.filter(lengthThree)


// using function with predefined values for applying to smallest amount of parameters
def lengthByExample(sample:String, controlValue:String) : Boolean = {
  sample.length == controlValue.length
}
list.filter(lengthByExample("123", _))


// --------------------------
def applyFilter(values:List[String],
                // function as a parameter,         default value for function
                customFunction: String => Boolean =
                x=>x.length==2 )
                : List[String] = {
  values.filter(customFunction)
}
applyFilter(list, _.length>3)


def customFilter(sample:String, checkValue:String, count:Int) : Boolean = {
  checkValue.length > count && checkValue.length < sample.length
}
// send function with different amount of parameters with predefined values
// only one parameter is unknown - type String, what expected into 'applyFilter'
applyFilter(list, customFilter("predefined", _, 3))


// ---------------------------
// example of returning Unit
def functionUnit():Unit = {
  println("some operators inside function ")
  ()
}

def printStrings(s:String*):Unit = {
  for(each<-s)println(each)
}
printStrings("one","two","three")
printStrings(Array("one", "two", "three"):_*)
printStrings(List("one", "two", "three"):_*)

// ---------------------------
// default parameters, naming parameters
def printMessage(prefix:String=">>>", message:String, suffix:String="<<<<") : Unit = println(prefix+message+suffix)
printMessage(message="example", prefix = ">>>>")

// method currying
def printDefaultMessage : String => Unit = printMessage("...", _ , "...")
printDefaultMessage("another example")

val addOne         = (x:Int)=> x + 1
val addOneCurrying =     (_:Int) + 1
println(addOne(11))
println(addOneCurrying(12))