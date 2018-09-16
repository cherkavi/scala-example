package com.cherkashyn.vitalii.scala.example


object EntryPoint {

  def main(args: Array[String]): Unit ={
    if (args.exists(_.toUpperCase == "--help"))
      System.out.println(" no help description exists ")

    System.out.println("Scala entry point")
  }

}