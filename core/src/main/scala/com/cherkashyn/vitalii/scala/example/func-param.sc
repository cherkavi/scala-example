val list = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)

// return value - function
def lengthThree:  (String)=>Boolean = {
  v=>v.length>3
}
list.filter(lengthThree)


// parameter - function
def applyFilter(values:List[String], func: (String)=>Boolean ): List[String] ={
  values.filter(func)
}

applyFilter(list, _.length>3)
