class TransformerTest extends org.scalatest.FunSuite {

  test("create object from JSON "){
    // given
    val source = """  {"projectName":"audi-1","vin":"V688","sessionId":"4152-9655","timestamp":1533810496005817500,"processedLabel":{"accelerationLongitudinal":"slight negative-s"}} """

    // when
    val result = Transformer.fromJson(source)

    // then
    assert(result.isDefined)
    assert(result.get.id.isEmpty)
    assert(result.get.projectName.isDefined)
    assert(result.get.projectName.get == "audi-1")
    assert(result.get.vin.get == "V688")
    assert(result.get.sessionId.get == "4152-9655")
  }

  test("serialize object into JSON "){
    // given
    val v = new SourceDomain(Some("id-1"), Some("proj-1"), Some("vin-1"), Some("sess-1"), Some(1533810496005817500L), Map("one"->"two", "three"->"four"))

    // when
    val result:String = Transformer.toJson(v)

    // then
    assert(!result.isEmpty)
    println(result)
  }

  test(" from SourceDomain to DestinationDomain"){
    // given
    val source = new SourceDomain(Some("id-1"), Some("proj-1"), Some("vin-1"), Some("sess-1"), Some(1533810496005817500L),
      Map("vehicleSpeed"->"two three", "accelerationLongitudinal"->"four five"))

    // when
    val result = Transformer.convert(source)

    // then
    assert(result.id.isDefined)
    assert(result.id.get=="id-1")
    assert(result.projectName.isDefined)
    assert(result.projectName.get=="proj-1")
    assert(result.sessionId.isDefined)
    assert(result.sessionId.get=="sess-1")
    assert(result.vehicleSpeed.isDefined)
    assert(result.vehicleSpeed.get.size==2)
    assert(result.vehicleSpeed.get.contains("two"))
    assert(result.vehicleSpeed.get.contains("three"))

    assert(result.accelerationLongitudinal.isDefined)
    assert(result.accelerationLongitudinal.get.size==2)
    assert(result.accelerationLongitudinal.get.contains("four"))
    assert(result.accelerationLongitudinal.get.contains("five"))
  }

  test(" from DestinationDomain to SourceDomain"){
    // given
    val source = new DestinationDomain(Some("id-1"), Some("proj-1"), Some("vin-1"), Some("sess-1"), Some(1533810496005817500L),
      Some(Array[String]("two", "three")),
      Some(Array[String]("four", "five"))
    )

    // when
    val result = Transformer.convert(source)

    // then
    assert(result.id.isDefined)
    assert(result.id.get=="id-1")
    assert(result.projectName.isDefined)
    assert(result.projectName.get=="proj-1")
    assert(result.sessionId.isDefined)
    assert(result.sessionId.get=="sess-1")
    assert(result.processedLabel.size==2)
    assert(result.processedLabel.contains("accelerationLongitudinal"))
    assert(result.processedLabel.contains("vehicleSpeed"))
  }

}
