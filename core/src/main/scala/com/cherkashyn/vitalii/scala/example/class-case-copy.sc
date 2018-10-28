case class Cat(name:String, age:Int, hasId:Boolean){}

println("> apply method")
val kitCat = Cat("Kit", 5, true)

println("> value hasId will be copied from source object")
kitCat.copy("Kit2", 2)

println("> specify field by name")
kitCat.copy(age=2)

println("> product -Prefix, -Arity, -Iterator")
kitCat.productPrefix
kitCat.productArity

val iterator = kitCat.productIterator
while(iterator.hasNext)iterator.next()

println("> equals")
kitCat == Cat("Kit",5,true)
kitCat == Cat("kit",5,true)

println("> toString")
println(kitCat)