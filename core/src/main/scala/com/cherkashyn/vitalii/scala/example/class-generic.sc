trait SoundProducer{
  def produce()
}

class Horn extends SoundProducer{
  override def produce(): Unit = {
    println("sounds of horn")
  }
}

// T is child of SoundProducer,
// also possible to specify ancestor >:
trait Player[T <: SoundProducer]{
  def play(soundProducer: T): Unit ={
    soundProducer.produce()
  }
}

class Mp3Player extends Player[Horn]{
  override def play(s:Horn): Unit = {
    s.produce()
  }
}

new Mp3Player().play(new Horn())


// retrieve class from Typed/Generic parameter
//  def typeToClassTag[T: scala.reflect.api.TypeTags.TypeTag]: scala.reflect.ClassTag[T] =
//    scala.reflect.ClassTag[T](typeTag[T].mirror.runtimeClass(typeTag[T].tpe))
// val c = typeToClassTag[T]
