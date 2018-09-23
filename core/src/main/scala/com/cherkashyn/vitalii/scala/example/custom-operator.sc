
def customWhile(expression: =>Boolean)(body: =>Unit): Unit ={
  println(expression)
  println(body)
  while(expression){
    println("_being next iteration_")
    body
    println("_end_ next iteration")
  }
}

var i=1
customWhile{i<5}{
  i+=1
  println(s"next value : ${i}")
}