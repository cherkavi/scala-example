import java.io.{IOException, InputStream}

import scala.io.{BufferedSource, Source}
import scala.util.Try

val myAttempt = Try(throw new IllegalArgumentException("hard-coded exception"))

val resultOfAttempt = myAttempt match{
  case scala.util.Success(value) => "success"
  case scala.util.Failure(exception) => exception.getMessage
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


// try catch is returning value

val intConverter = (s:String) =>
try{
  s.toInt
}catch{
  case _:Throwable => 0
}
intConverter("13")
intConverter("a")