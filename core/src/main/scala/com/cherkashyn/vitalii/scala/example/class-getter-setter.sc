class Zug(private var _name:String = "unknown"){

  // accessor
  def name:String = {
    this._name
  }

  // mutator
  // def name_=(newName: String): Unit ={
  def name_$eq(newName: String): Unit ={
    this._name = newName
  }

  override def toString: String = {
    this._name
  }

}


val currentZug = new Zug("U4")
println(currentZug.name)
currentZug.name = "U2"
println(currentZug.name)

// default parameter example
println(new Zug())