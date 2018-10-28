case class Cat(name:String, age:Int, hasId:Boolean){}

println("> apply method in case class")
// val kitCat = new Cat("Kit", 5, true)
val kitCat = Cat("Kit", 5, true) //  Cat.apply("Kit", 5, true)

println("> apply method in simple object")
object FacadeString{
  def apply(s:String): String = s.split("").mkString(".")
}
println(FacadeString("one"))

var arr = Array(1,2,3) // Array.apply(1,2,3)



println(">unapply method")
var a:Option[(String,Int,Boolean)] = Cat.unapply(kitCat)
a.get

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