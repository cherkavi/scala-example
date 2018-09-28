val list = ("one" +: "two" +: "three" +: "four" +: "five" +: "six" +: "seven" +: Nil)

list.map(s=>s"-$s-")
// list.asInstanceOf[List[String]].partition(_.length>3)
list.filter(_.length>0)


def checkLength(s:String):Boolean = {
  s.length>3
}
list.filter(checkLength(_))

// join both collections
list++list


val groups = list.partition(_.length>3)
// List(groups._1, groups._2).flatMap(_)


val simpleMap = Map("one"->"1", "two"->"2", "three"->"3")
for((key,value)<-simpleMap)yield key
