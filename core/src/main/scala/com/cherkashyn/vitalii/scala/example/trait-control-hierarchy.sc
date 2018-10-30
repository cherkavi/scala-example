class Car(name:String)

class AirCraft(name:String)

/** trait with specifying parent type */
trait FlagForCar{
  this: Car =>

  def showFlag:String =
    """
      |****
      |***
      |****
    """

}


class VolvoTrack extends Car("XC60") with FlagForCar


// can not be compiled
// class Mig27 extends AirCraft("MIG") with FlagForCar

// -------------
trait Animal{
  def breathing():String = "air consumer"
}

trait Runner extends Animal{
  def run():String = "can run"
}

trait Swimmer extends Animal{
  def swim():String = "can swim"
}
/** trait with specifying method into parent trait/class */
trait LegsOwner {
  this: {
    def run():String
  } =>
  def legsCount():Int
}

class Monkey extends Runner with LegsOwner{
  override def legsCount() = 2
}
//class Wahl extends Swimmer with LegsOwner{
//  override def legsCount() = 4
//}