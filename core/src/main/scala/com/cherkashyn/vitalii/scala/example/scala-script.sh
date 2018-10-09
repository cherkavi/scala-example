#!/bin/sh
exec scala "$0" "$@"
!#

case class Person(val name:String, val age:Int )

object MyCustomObject{
	def main(arguments:Array[String]){
		println(s"this is my program with argument size: ${arguments.length}")
		println(Person("Ekkehard", 38))	
	}
}

