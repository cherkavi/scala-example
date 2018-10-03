class DestinationDomain(val id:Option[String],
                        val projectName: Option[String],
                        val vin:Option[String],
                        val sessionId: Option[String],
                        val timestamp:Option[Long],
                        val vehicleSpeed: Option[Array[String]],
                        val accelerationLongitudinal: Option[Array[String]] ) extends Serializable {
}
