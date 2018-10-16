
val function = new Function1[Int, String] {
  def apply(index:Int):String = {
    index.toString
  }
}
println(function(10))

function.andThen[Int]( (x:String)=>{Integer.parseInt(x)})(12)
function.andThen[Int](x=>Integer.parseInt(x))(12)
function.andThen[Int](Integer.parseInt(_))(12)
function.andThen[Int](Integer.parseInt)(12)


val sameFunction = (index:Int)=>index.toString
println(sameFunction(10))
sameFunction.compose[Int]((x)=>x+5)(10)
