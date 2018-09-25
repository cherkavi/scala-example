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
