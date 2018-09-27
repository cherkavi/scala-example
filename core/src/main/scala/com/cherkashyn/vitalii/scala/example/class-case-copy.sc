case class Cat(name:String, age:Int, hasId:Boolean){
}

val kitCat = Cat("Kit", 5, true)

// value hasId will be copied from source object
kitCat.copy("Kit2", 2)