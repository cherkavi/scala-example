def detectValue(s:Option[String]):String = {
  s match {
    case None => "none"
    case Some(x) => s">${x}<"
  }
}

detectValue(Some("value"))
detectValue(None)