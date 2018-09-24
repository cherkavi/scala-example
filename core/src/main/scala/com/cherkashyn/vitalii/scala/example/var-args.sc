import scala.collection.mutable.ListBuffer

def summarize(values: Int*): Int ={
  values.reduceRight( (v, s) => v+s)
}

println(summarize(1,2,3,4,5,6))

val listValues = new ListBuffer[Int]
listValues+=1
listValues+=2
listValues+=3
listValues+=4
listValues+=5
listValues+=6
listValues+=7

// flatMap list to var-args
summarize(listValues: _*)

