import org.json4s._
import org.json4s.jackson.JsonMethods._
implicit val formats = DefaultFormats

val jsonObject:JObject = parse("""{"foo":"bar"}""").asInstanceOf[JObject]


class Car(name:String, hasWheels:Boolean, wheelsCount:Int)

val jsValue = parse(""" {"name":"audi", "hasWheels":true, "age": 2}  """)

val extractedCar = jsValue.extract[Car]
val tryExtractCar = jsValue.extractOpt[Car]

