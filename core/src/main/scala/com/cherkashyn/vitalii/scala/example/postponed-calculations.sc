// example of postponed calculations
def doIfTrue(v: => Boolean) ( action: => Unit): Unit = {
  if(v) action
}

// example of using different bracket with expressions
doIfTrue(5>7)(println("YES!!!"))
doIfTrue{"some text".size>5}(println("text is more than 5"))
doIfTrue{"some text".size>5}{println("text is more than 5")}