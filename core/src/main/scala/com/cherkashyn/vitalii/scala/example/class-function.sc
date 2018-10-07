def checkIfTrue( x:(Int) => Boolean): Boolean ={
  x(5)
}

// anonymous function
checkIfTrue( x => x>4 )

def posititveNumbers(v:Int):Boolean = {
  v>0
}
// predefined function
checkIfTrue(posititveNumbers)

// class CustomClassFunction extends ((Int) => Boolean){
class CustomClassFunction extends Function1[Int, Boolean]{
  override def apply(v1: Int):Boolean = {
    v1<0
  }
}

checkIfTrue(new CustomClassFunction())