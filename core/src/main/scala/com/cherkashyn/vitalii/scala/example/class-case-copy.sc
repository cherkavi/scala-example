case class Cat(name:String, age:Int, hasId:Boolean){
}

// apply method
val kitCat = Cat("Kit", 5, true)

// value hasId will be copied from source object
kitCat.copy("Kit2", 2)

// specify field by name
kitCat.copy(age=2)

kitCat.productPrefix
kitCat.productArity

val iterator = kitCat.productIterator
while(iterator.hasNext)iterator.next()
