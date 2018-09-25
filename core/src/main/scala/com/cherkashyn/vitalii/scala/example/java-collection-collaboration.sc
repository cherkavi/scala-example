import java.util

val javaSet = new util.HashSet[String](util.Arrays.asList("one", "two", "three"))

import scala.collection.JavaConversions._
for(each<-javaSet)println(each)