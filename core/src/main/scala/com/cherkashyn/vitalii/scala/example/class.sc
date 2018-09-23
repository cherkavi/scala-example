trait Environment{
  val name:String
}
case class Ground(val name: String = "Ground") extends  Environment
case class Water(val name: String = "Water") extends  Environment
case class Air(val name: String = "Air") extends  Environment


abstract class Vehicle[Environment](val name:String, val hasWheels:Boolean){
  println("Vehicle constructor begin ")

  abstract def go:Any

  def env:Environment={
    new Ground()
  }

  println("Vehicle constructor end")
}

final class Car(override val name:String)
  extends Vehicle[Ground](name, true){

  println("Car constructor begin")

  override def go = {

  }

  override def env: Environment = new Ground
  println("Car constructor end")
}