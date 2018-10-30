def detectValue(s:Option[String]):String = {
  s match {
    case None => "none"
    case Some(x) => s">${x}<"
  }
}

detectValue(Some("some value"))
detectValue(Option("option value"))
detectValue(None)

for{
  i <- Option("-one-")
  j <- Option("-two-")
}println(s"${i} and ${j} ")

// no output - k is None
for{
  i <- Option("-one-")
  j <- Option("-two-")
  k <- None
}println(s"${i} and ${j} and ${k}")
