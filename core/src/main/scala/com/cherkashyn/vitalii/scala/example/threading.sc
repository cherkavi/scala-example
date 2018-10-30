println("> example of using 'var' type of variable into multithreading ")
object Holder{
  @volatile var core = new String("some string ")
}
Holder.core = "new String"

println("> using Future ")
import java.util.concurrent.{ForkJoinPool, TimeUnit}

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}


implicit val executionContext:ExecutionContext = ExecutionContext.fromExecutor(new ForkJoinPool())
// import scala.concurrent.ExecutionContext.Implicits.global

val future:Future[Int] = Future{
  scala.math.rint(scala.math.random*50).toInt
} // implicit (executionContext)

val futureString = future.map(f=>f.toString()+" val.")

import scala.concurrent.duration._
Await.result(futureString, 1.second)
// executionContext.execute(new Thread())

futureString.onComplete{
  case Success(i) => i
  case Failure(_) => ""
}