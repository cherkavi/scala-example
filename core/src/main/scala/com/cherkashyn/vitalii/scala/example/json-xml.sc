import com.google.gson.JsonParser

import scala.collection.immutable.HashMap

val jsonString = """{"processedLabel":{"acceleration":"slight negative"},"projectName":"Audi-AD","sessionId":"9655-89bab630beea",
                    "timestamp":1533810496005817500,
                    "vin":"V714688"}
  """

class Domain(processedLabel:Map[String,String],
             projectName:String,
             sessionId:String,
             timestamp:Long,
             vin:String){
  override def toString:String={
    s"$projectName  $vin  $sessionId"
  }
}

// not working example - strange error with ClassNotFound
// import scala.util.parsing.json._
// val jsonObject = JSON.parseRaw(jsonString)// .asInstanceOf[JSONObject]

val json= new JsonParser().parse(jsonString).getAsJsonObject
json.get("vin").getAsString
// jsonObject("vin")