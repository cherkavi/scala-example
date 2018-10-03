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

}
