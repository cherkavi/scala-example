// package com.cherkashyn.vitalii

class Garage{

  class Car {

    // visible only inside certain instance of the class
    private[this] var privateThisField:String = ""

    // visible only inside class
    private var privateField :String = "";

    // visible only inside this class and specified outer class
    private[Garage] var privateForPackage:String = ""

    def f={
      this.privateForPackage+=10
    }

  }

  protected var protectedField:String = ""

  // default visibility - public
  var carPrivateField = new Car().privateForPackage

}

class GarageExt extends Garage{
  def usingProtectedField = {
    // protected field visible inside child classed
    // inside package is not visible !!!
    this.protectedField
  }
}

val garage = new Garage()

// public field is visible
garage.carPrivateField
