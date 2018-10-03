import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.DefaultFormats

import scala.collection.mutable

object Transformer {
  def toJson(v:SourceDomain): String ={
    implicit val formats = DefaultFormats
    compact(org.json4s.jackson.JsonMethods.render(Extraction.decompose(v)))
  }

  def fromJson(jsonString:String):Option[SourceDomain] = {
    implicit val formats = DefaultFormats
    // parse from from Array[Byte]
    // parse(new ByteInputStream(bytes, bytes.length)).extract[SourceDomain]
    val jsValue = parse(jsonString)
    jsValue.extractOpt[SourceDomain]
  }

  def getArray(source: Map[String, String], key: String): Option[Array[String]] = {
    if (!source.contains(key)) return None
    Some(source.get(key).get.split(" "))
  }

  def convert(source:SourceDomain):DestinationDomain = {
    new DestinationDomain(
      source.id,
      source.projectName,
      source.vin,
      source.sessionId,
      source.timestamp,
      getArray(source.processedLabel, "vehicleSpeed"),
      getArray(source.processedLabel, "accelerationLongitudinal")
    )
  }

  def buildMap(accelerationLongitudinal: Option[Array[String]], vehicleSpeed: Option[Array[String]]): Map[String, String] = {
    val returnValue = mutable.Map[String, String]()
    if(accelerationLongitudinal.isDefined && accelerationLongitudinal.get.nonEmpty)
      returnValue.put("accelerationLongitudinal", accelerationLongitudinal.get.mkString(" "))
    if(vehicleSpeed.isDefined && vehicleSpeed.get.nonEmpty)
      returnValue.put("vehicleSpeed", vehicleSpeed.get.mkString(" "))
    returnValue.toMap
  }

  def convert(source:DestinationDomain):SourceDomain = {
    new SourceDomain(
      source.id,
      source.projectName,
      source.vin,
      source.sessionId,
      source.timestamp,
      buildMap(source.accelerationLongitudinal, source.vehicleSpeed)
    )

  }


}
