class Zug(){

  private var name:String = _
  private[this] var uniqueName:String = _
  protected var innerName:String = _

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

    // "protected" field accessible for companion object and for all children
    zug.innerName = ""
  }
}

object Aircraft{
  def changeName(zug:Zug, newName:String): Unit ={
    // private field is not accessible for another objects ( nor itself, not companion )
    // zug.name = newName
    // can't access field uniqueName - strong private
    zug.setUniqueName("__"+newName+"__")

    // "protected" field not accessible for non-companion object
    // zug.innerName
  }
}


// create anonymous class extended from Zug
val z = new Zug(){
  // protected field is accessible into child classes
  this.innerName = "besonders zug"
}
println(s"default values $z")

Zug.changeName(z, "another unique name")

println(s"values after Zug.changename: $z")

println("-----------")

val z2 = new Zug()
println(s"default vales: $z2")

Aircraft.changeName(z2, "another unique name")

println(s"values after Aircraft.changeName: $z2")