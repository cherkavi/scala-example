// destination point for function
def checkIfTrue( x:(Int) => Boolean): Boolean ={
  x(5)
}

println("anonymous function")
checkIfTrue( x => x>4 )

println("predefined function")
def posititveNumbers(v:Int):Boolean = {
  v>0
}
checkIfTrue(posititveNumbers)

println("class extends from Function[P1, RV]")
// class CustomClassFunction extends ((Int) => Boolean){
class CustomClassFunction extends Function1[Int, Boolean]{
  override def apply(v1: Int):Boolean = {
    v1<0
  }
}
checkIfTrue(new CustomClassFunction())

// ----------------------------------
println("for loop with class with 'foreach' method")

class ForLoopCustom(val times:Int) {
  def foreach(functionBody:Int => String): String ={
    (for(i<-0.to(times)) yield functionBody(i)).mkString(" ")
  }
}
for(index<-new ForLoopCustom(3)) s"${index*index} "