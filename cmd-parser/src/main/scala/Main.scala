import scala.reflect.api._

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Target(Array(ElementType.TYPE))
@Retention(RetentionPolicy.RUNTIME)
class CmdParam (var text: String)

// case class CmdParam(val text:String, val nameOverride: String = "") extends scala.annotation.StaticAnnotation

case class Config( @CmdParam(text = "inputPath")
                   var inputFilePath: String = "",
                   @CmdParam(text = "outputPath")
                  var outputPath: String = "",
                   @CmdParam(text = "session")
                  var session: String = "")



object Main {

  val APP_NAME = "Application Name"
  val APP_DESCRIPTION = "Application description"

  // configuration parameter keys
  val INPUT_FILE_PATH = "inputPath"
  val SESSION = "session"
  val OUTPUT_PATH = "outputPath"

  def parseAnnotations(v:AnyRef):Unit = {
    val ann = v.getClass.getDeclaredField("session").getDeclaredAnnotations
    println(ann)
  }
  // example of using return value as null, return value null, null return value
  // def returnNull[T>:Null]():T = {null}




//  import scala.reflect.runtime.universe._
//  def parseArguments[T:TypeTag]():Unit = {
    // ------------------------
//    val accessors = typeOf[T].members.collect {
//      // case m: MethodSymbol if m.isGetter && m.isPublic  => m
//      case m: MethodSymbol if m.isVal || m.isVar  => m
//    }
//    for(each<-accessors){
//      val field = each.asTerm.accessed.asTerm
//      println(s"$field  ${each.annotations}   ${field.annotations}")
//    }

//    val clazz = typeOf[T].getClass
//    for(a<-clazz.getDeclaredFields()){
//      println(s" $a  ${a.getAnnotations}")
//    }

    // --------------------------
    // val ru = scala.reflect.runtime.universe
    // https://www.scala-lang.org/api/2.12.0/scala-reflect/scala/reflect/api/Mirrors.html
//    val m = scala.reflect.runtime.universe.runtimeMirror(getClass.getClassLoader)
//    val fieldSession = typeOf[T].declaration(TermName("session")).asTerm.accessed.asTerm
//    val annotations = fieldSession.annotations
//    println(annotations)
//    val reflectField = m.reflect(typeOf[T]).reflectField(fieldSession)
//    reflectField.set("hello")

  //  }

  def parseArgs(args: Array[String]): Config = {

    val parser = new scopt.OptionParser[Config](APP_NAME) {
      head(APP_NAME, APP_DESCRIPTION)

      opt[String](INPUT_FILE_PATH)
        .required()
        // .action((x, c) => c.copy(inputFilePath = x))
        .text("input file ")

      opt[String](SESSION)
        .required()
        // .action((x, c) => c.copy(session = x))
        .text("Session")

      opt[String](OUTPUT_PATH)
        .required()
        // .action((x, c) => c.copy(outputPath = x))
        .text("output file")

      help("help").text("using this app")
    }

//    parser.parse(args, Config()) match {
//      case Some(config) => config
//      case None => println("use --help for usage "); sys.exit(0)
//    }
    new Config("","","")
  }

}