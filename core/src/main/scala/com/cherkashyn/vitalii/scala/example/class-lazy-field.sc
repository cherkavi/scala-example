class Zug{
  var name:String = _
  lazy val description:String = {
    println(">>> calculate description<<<")
    " description for: " + name
  }

}

var z = new Zug()
println(z)

z.name = "zug name"
z.description
println(z)

