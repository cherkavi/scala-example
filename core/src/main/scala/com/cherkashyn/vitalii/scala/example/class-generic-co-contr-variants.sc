trait SoundProducer{
  def produce()
}

trait AirTubeProducer extends SoundProducer{
  def airOut()
}

class Horn extends AirTubeProducer{
  override def airOut(): Unit = println("u-u-u-u")
  override def produce(): Unit = println("u-u-u")
}


// co-variant
def produceSound[T <: AirTubeProducer](target:T): Unit ={
  target.airOut()
  target.produce()
}
produceSound(new Horn())


// contr-variant
def checkSound[T >: Horn](target:T): Unit ={
  // not visible
  // target.airOut()
  // target.produce()
}
// ------------------------
