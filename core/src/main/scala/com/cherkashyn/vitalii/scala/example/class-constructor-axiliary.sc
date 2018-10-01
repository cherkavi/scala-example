//           main constructor
class Person(val name:String, val surname:String,
             var nickName:String, var age:Int, val phone:String){

  // auxiliary constructor #1
  def this(name:String, surname:String, age:Int, phone:String){
    // look into main
    this(name, surname, "", age, phone)
  }

  // auxiliary constructor #2
  def this(name:String, surname:String, age:Int){
    // look into #1
    this(name, surname, age, "")
  }

  // auxiliary constructor #3
  def this(name:String, surname:String){
    // look into #2
    this(name, surname, 0)
  }

  // auxiliary constructor #4
  def this(name:String){
    // look into #3
    this(copyName(name), name)
  }

  def copyName(v:String):String = v

}


class Employee(name:String, surname:String)
  extends Person(name, surname, age = 100){

  def this(name:String, surname:String, salary:Int){
    // no way to using auxiliary parent constructor
    // into another auxiliary constructor of the current class
    // super(name, surname)
    this(name, surname)
  }

}