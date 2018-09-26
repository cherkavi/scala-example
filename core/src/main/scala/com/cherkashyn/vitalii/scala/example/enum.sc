object Transport extends Enumeration{
  // type Transport = Value
  val car, train, airplaine = Value
}


val elements = for( each <- Transport.values) yield each

if (elements.contains(Transport.car)){
  println(s"car into list: ${elements}")
}