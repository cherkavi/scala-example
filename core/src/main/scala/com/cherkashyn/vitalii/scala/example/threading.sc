println("> example of using 'var' type of variable into multithreading ")
object Holder{
  @volatile var core = new String("some string ")
}
Holder.core = "new String"