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