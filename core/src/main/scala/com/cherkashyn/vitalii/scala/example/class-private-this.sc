class Zug(){

  private var name:String = _
  private[this] var uniqueName:String = _

  override def toString:String = s"Zug[name:$name  uniqueName:$uniqueName]"

  def setUniqueName(newUniqueName:String): Unit ={
    this.uniqueName = newUniqueName
  }

}

// companion object
object Zug{
  def changeName(zug:Zug, newName:String): Unit ={
    // private field is accessible
    zug.name = newName
    // can't access field uniqueName - strong private
    // zug.uniqueName =
    // using mutator instead off
    zug.setUniqueName("__"+newName+"__")
  }
}

object Aircraft{
  def changeName(zug:Zug, newName:String): Unit ={
    // private field is not accessible for another objects ( nor itself, not companion )
    // zug.name = newName
    // can't access field uniqueName - strong private
    zug.setUniqueName("__"+newName+"__")
  }
}


val z = new Zug()
println(s"default values $z")

Zug.changeName(z, "another unique name")

println(s"values after Zug.changename: $z")

println("-----------")

val z2 = new Zug()
println(s"default vales: $z2")

Aircraft.changeName(z2, "another unique name")

println(s"values after Aircraft.changeName: $z2")