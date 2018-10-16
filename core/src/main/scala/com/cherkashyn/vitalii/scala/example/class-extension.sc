// trait
trait Wheels{
  def wheelsCount:Int
}

/** abstract class has a constructor */
abstract class Vehicle(val name:String)

class Car(name:String) extends Vehicle(name) with Wheels{
  override def wheelsCount: Int = 4
}

class Bus(name:String) extends Car(name)

/** trait with ability to belong only to ancestor of Bus */
trait Kitchen {
  // can be extended only with instanceOf Bus
  // also possible add addition traits via keyword 'with'
  this: Bus =>
  // default value for method
  def hasAKitchen:Boolean = true
}
// Kitchen can be applied to Bus
class FamilyBus(name:String) extends Bus(name) with Kitchen
// wrong hierarchy - Car is not a Bus
// class AnotherBus(name:String) extends Car with Kitchen

/** class extends a function  */
class SummatorExtension extends ( (Int, Int)=>Int ){
  override def apply(v1: Int, v2: Int) = v1+v2
}

new SummatorExtension().apply(5,5)