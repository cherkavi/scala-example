import java.lang.reflect.Method

class Sample(var stringValue:String, val intValue:Int){
  override def toString: String = s" ${stringValue}  ${intValue}"
}
val s1 = new Sample("hello", 13)

/** reflection read */
def readValueFromProperty[S](target: AnyRef, propertyName:String):S = {
  target.getClass.getDeclaredMethods
    .filter(m => m.getName==propertyName)
    .collectFirst(new PartialFunction[Method, S] {
      override def isDefinedAt(x: Method):Boolean = true
      override def apply(method: Method):S = {
        method.invoke(target).asInstanceOf[S]
      }
    }).get
}

readValueFromProperty[String](s1, "stringValue")
readValueFromProperty[Int](s1, "intValue")

/** reflection write */
def writeValueToProperty[S](target: AnyRef, propertyName:String, value:S):Unit = {
  target.getClass.getDeclaredMethods
    .filter(m => m.getName==propertyName+"_$eq")
    .collectFirst(new PartialFunction[Method, Unit] {
      override def isDefinedAt(x: Method):Boolean = true
      override def apply(method: Method):Unit = {
        method.invoke(target, value)
      }
    }).get
}

writeValueToProperty[String](s1, "stringValue", "done")
