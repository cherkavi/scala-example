// -------- class - class
class Outer{
  class Inner{
    var x = 1
  }
}

// DON'T use "var" !!!
val outer = new Outer()
new outer.Inner()


// -------- object - class ------
object Garage{
  class Car{
  }
}

new Garage.Car()

// -------- class - object -----
class Train{
  object Seat{
    val numbers = 10
  }
}

println(new Train().Seat.numbers)