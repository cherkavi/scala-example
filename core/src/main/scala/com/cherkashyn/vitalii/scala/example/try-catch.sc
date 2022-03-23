import java.io.IOException

import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try}

// sourcecode: https://github.com/scala/scala/blob/v2.13.6/src/library/scala/util/Try.scala
val myAttempt = Try[String](throw new IllegalArgumentException("hard-coded exception"))

val resultOfAttempt = myAttempt match{
  case Success(value) => s"success: ${value}"
  case Failure(exception) => exception.getMessage
}


var source:Option[BufferedSource] = None
try{
  source = Some(Source.fromFile("/not/existing/path","UTF-8"))
} catch {
  case re: RuntimeException => println(s"catch RuntimeException ${re.getMessage}")
  case io: IOException => println(s"can't read the file: ${io}")
  case th: Throwable => println(s"catch Throwable ${th.getMessage}")
}finally{
  if(source.isDefined)source.get.close()
}


println("> try catch is returning value")
val intConverter = (s:String) =>
try{
  s.toInt
}catch{
  case _:Throwable => 0
}
intConverter("13")
intConverter("a")


Try("abcd".toInt).toOption
Try("abcd".toInt).toOption.isDefined
Try("abcd".toInt).failed.get
Try("15".toInt).get
Try("20".toInt).isSuccess
Try("abcd".toInt).map[Int](x => x+13)
  .transform[String](x=>Try(x.toString),_=>Try("wrong number")).get

println("> yield example ")
for{
  i <- Success("-one-")
  j <- Success("-two-")
}println(s" $i  $j")
