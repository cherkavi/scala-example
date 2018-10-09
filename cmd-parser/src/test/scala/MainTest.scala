import org.scalatest.FunSuite

class MainTest extends FunSuite {
  ignore("first test"){
    // given
    val cmd:Array[String] = Array[String]("--inputPath", "/my/personal/path","--session","xxxx-yyyy-zzzz", "--outputPath", "/my/output/path")

    // when
    val output = Main.parseArgs(cmd)

    // then
    assert(output.inputFilePath=="/my/personal/path")
    assert(output.outputPath=="/my/output/path")
    assert(output.session=="xxxx-yyyy-zzzz")
  }

  test("custom implementation test"){
    // given
    // when
    // then
    // Main.parseArguments[Config]()
    Main.parseAnnotations(new Config())
  }

}
