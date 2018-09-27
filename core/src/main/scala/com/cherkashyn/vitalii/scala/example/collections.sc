val list = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)

list.map(s=>s"-$s-")
// list.asInstanceOf[List[String]].partition(_.length>3)
list.partition(_.length>3)
list.filter(_.length>0)


def checkLength(s:String):Boolean = {
  s.length>3
}
list.filter(checkLength(_))


