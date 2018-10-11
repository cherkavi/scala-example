class Car(val name:String, val wheelsCount: Int){

}

/**
  * direct implicit via class
  * @param c
  */
implicit class MyCarWrapper(c:Car){
  def fullDescription(prefix:String = "prefix: "):String ={
    s"$prefix  ${this.c.name}  ${this.c.wheelsCount}"
  }
}

new Car("ford", 4).fullDescription(">>>")



object ExtensionContainer{
  implicit class MyCarAdditionalWrapper(c:Car){
    def additionalDescription():String = {
      s"${c.fullDescription("additionalPrefix:")}"
    }
  }
  println(new Car("audi", wheelsCount = 4).additionalDescription())
}

new ExtensionContainer.MyCarAdditionalWrapper(new Car("xxx", 3)).additionalDescription()
// implicit method "additionalDescription" does not exists
//new Car("audi", wheelsCount = 4).additionalDescription