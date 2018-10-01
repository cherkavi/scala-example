// throws exception exists not in the signature
// can be written:
//@throws(classOf[NumberFormatException])
@throws[NumberFormatException]
def convertToInt(v:String):Int = {
  v.toInt
}

convertToInt("10")
convertToInt("f")