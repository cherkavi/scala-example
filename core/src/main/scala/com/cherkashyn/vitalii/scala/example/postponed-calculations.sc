// example of postponed calculations
def doIfTrue(v: => Boolean) (action: => Unit): Unit = {
  if(v) action
}


// example of using different bracket with expressions
doIfTrue(5>7)(println("YES!!!"))
doIfTrue{"some text".size>5}(println("text is more than 5"))
doIfTrue{"some text".size>5}{println("text is more than 5")}


// example of postponed calculation with parameters
def doIfEquals(v:String => Boolean)(action: =>Unit):Unit = {
  if(v(""))action
}
doIfEquals(v=>v=="")(println("equals"))


// example of using function as variable
def checkIt( v:(String, String) => Boolean): Boolean = {
  v("one", "two")
}

checkIt( (x,y) => x.size==y.size)