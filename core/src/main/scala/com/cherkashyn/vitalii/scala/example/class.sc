trait Environment{
  val name:String
}
case class Ground(val name: String = "Ground") extends  Environment
case class Water(val name: String = "Water") extends  Environment
case class Air (val name: String = "Air")  extends  Environment

// abstract class with predefined constructor
abstract class Vehicle[T<:Environment](val name:String, val hasWheels:Boolean){
  println("Vehicle constructor begin ")

  // abstract method
  def go:Any

  // method with generic method type
  def env: Environment ={
    new Environment {
      override val name: String = "unknown"
    }
  }

  println("Vehicle constructor end")
}

final class Aircraft(override val name:String)
  extends Vehicle[Air](name, false){
  println("Aircraft constructor begin")

  override def go = println("flying")

  override def env: Environment = new Air()

  // override constructor
  def this() = this("superjet")

  println("Aircraft constructor end")
}

final class Car(override val name:String)
  extends Vehicle[Ground](name, true){
  println("Car constructor begin")

  override def go = {
    println("Car is riding ")
  }

  override def env: Environment = new Ground
  println("Car constructor end")
}


new Car("my_car")
new Aircraft("my jet")

// constructor with named parameters
class Example(name:String, size:Int, active:Boolean)
new Example(size=5, active=true, name = "some name")