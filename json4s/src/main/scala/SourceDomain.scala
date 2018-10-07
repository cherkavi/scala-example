class SourceDomain(val id:Option[String],
                   val projectName: Option[String],
                   val vin:Option[String],
                   val sessionId: Option[String],
                   val timestamp:Option[Long],
                   val processedLabel:Map[String,String]=Map[String,String]() ) extends Serializable {
}
