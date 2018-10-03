import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.DefaultFormats

object Transformer {
  def toJson(v:SourceDomain): String ={
    implicit val formats = DefaultFormats
    compact(org.json4s.jackson.JsonMethods.render(Extraction.decompose(v)))
  }

  def fromJson(jsonString:String):Option[SourceDomain] = {
    implicit val formats = DefaultFormats
    val jsValue = parse(jsonString)
    jsValue.extractOpt[SourceDomain]
  }

}
