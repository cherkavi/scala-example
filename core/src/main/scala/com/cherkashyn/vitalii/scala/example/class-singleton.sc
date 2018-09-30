class MySingleton private(n:String){

}

object MySingleton{
  val instance = new MySingleton("")
  // def instance:MySingleton = _instance
}

MySingleton.instance
MySingleton.instance
MySingleton.instance
