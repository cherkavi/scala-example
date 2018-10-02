trait Sprache{
  def greeting:String = "default greeting"
}

trait Deutsch extends Sprache{
  override def greeting: String = "German lang"
}

trait English extends Sprache{
  override def greeting: String = "English lang"
}

class Human extends Deutsch with English{
  // output of the method depends on *last* extension -
  // Engish will be printed
  // override def greeting: String = super.greeting

  override def greeting: String = {
    // can not be reached out !!!
    // super[Sprache].greeting
    println(super[Deutsch].greeting)
    println(super[English].greeting)
    "human speach"
  }
}


new Human().greeting