import scala.util.{Try, Failure, Success}
val rootFolder = "/home/technik/projects/temp/orc-emulator/"
val subFolders = Array("Can", "Lidar", "MDF", "MobileEye", "EmptyDir")
var amount:Long = 0
for( subFolder <- subFolders){
	val nextFolder = s"$rootFolder$subFolder"
	Try[Long]{
		spark.read.format("orc").load(nextFolder).count()
	} match {
		case Success(nextAmount) => amount = amount + nextAmount
		// example of empty implementation
		// analogue of "pass" in python 		
		case Failure(ex) => Unit
	}
}


