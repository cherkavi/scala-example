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

// invariant
def player[T : Horn](target:T):Unit = {
  // not visible
  // target.produce()
  // target.airOut()
}

// contr-variant
def checkSound[T >: Horn](target:T): Unit ={
  // not visible
  // target.airOut()
  // target.produce()
}
// ------------------------

class AirMusicPlayer[T:AirTubeProducer]()