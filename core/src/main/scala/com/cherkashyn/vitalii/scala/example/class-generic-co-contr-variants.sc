class BaseProduct
class Product extends BaseProduct
class SpecificProduct extends Product

println(">>> contravariant ")
// not possible
// trait Factory[-A]{  // minus - less wider class ( less freedom, specification )
//   def produce(): A  // contrvariant position
// }
trait Consumer[-A]{
  def consume(value: A) // minus - less wider class
}
class ProductConsumer extends Consumer[Product]{
  override def consume(value: Product): Unit = println(value)
}
// new ProductConsumer().consume(new BaseProduct) - nicht moglich
new ProductConsumer().consume(new Product)
new ProductConsumer().consume(new SpecificProduct)


println(">>> covariant")
trait Producer[+A]{
  def produce(option:Int):A
}
class ProductProducer extends Producer[Product]{
  def produce(option:Int): Product = option match {
      // case 0 => new BaseProduct
      case 1=> new Product
      case _ => new SpecificProduct
  }
}
new ProductProducer().produce(1)
new ProductProducer().produce(2)

// ------------------------------
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


println(">>> co-variant")
def produceSound[T <: AirTubeProducer](target:T): Unit ={
  target.airOut()
  target.produce()
}
produceSound(new Horn())

println(">>> invariant")
// def player[T : Horn](target:T):Unit = {
  // not visible
  // target.produce()
  // target.airOut()
// }
// class AirMusicPlayer[T:AirTubeProducer] {
//   def player(target:T)= println(target)
// }

println(">>> contr-variant")
def checkSound[T >: Horn](target:T): Unit ={
  // not visible
  // target.airOut()
  // target.produce()
}
// ------------------------

