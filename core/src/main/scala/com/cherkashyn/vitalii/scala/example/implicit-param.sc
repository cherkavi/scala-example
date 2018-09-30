// implicit parameter should be last
def summarize(value:Int)(implicit base: Int) : Int = {
  base+value
}


def usingSummarize(): Int ={
  implicit var myOwnBase = 10
  summarize(5)
}

def usingSummarizeImplicitly(): Int ={
  summarize(10)(5)
}

println(usingSummarize)
println(usingSummarizeImplicitly)



// -------------------------------------------------------------
// not working - only single and last should be
// def multiply(value:Int)(implicit base:Int)(implicit superBase:Int):Int= {

// runtime exception: two implicit types has the same type
def multiply(value:Int)(implicit base:Int, superBase:Int):Int= {
  value*base+superBase
}


def usingMultiply(): Int ={
  implicit var base = 10
  implicit var superBase = 100
  // will not work
  // multiply(5)
  base
}

println(usingMultiply())
