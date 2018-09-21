import scala.util.Try

val myAttempt = Try(throw new IllegalArgumentException("hard-coded exception"))

val resultOfAttempt = myAttempt match{
  case scala.util.Success(value) => "success"
  case scala.util.Failure(exception) => exception.getMessage
}

try{
  println("throw exception")
  throw new IllegalArgumentException("custom message")
} catch {
  case re: RuntimeException => println(s"catch RuntimeException ${re.getMessage}")
  case th: Throwable => println(s"catch Throwable ${th.getMessage}")
}finally{
  println("finally")
}