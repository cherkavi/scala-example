class Car(val name:String, val wheelsCount: Int){

}

/**
  * direct implicit via class
  * @param c
  */
implicit class MyCarExtension(c:Car){
  def fullDescription(prefix:String = "prefix: "):String ={
    s"$prefix  ${this.c.name}  ${this.c.wheelsCount}"
  }
}

new Car("ford", 4).fullDescription(">>>")



object ExtensionWrapper{
  implicit class MyCarAdditionalExtension(c:Car){
    def additionalDescription():String = {
      s"${c.fullDescription("additionalPrefix:")}"
    }
  }
  println(new Car("audi", wheelsCount = 4).additionalDescription())
}

new ExtensionWrapper.MyCarAdditionalExtension(new Car("xxx", 3)).additionalDescription()
// implicit method "additionalDescription" does not exists
//new Car("audi", wheelsCount = 4).additionalDescription