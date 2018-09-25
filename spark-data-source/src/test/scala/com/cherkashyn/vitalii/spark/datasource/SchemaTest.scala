package com.cherkashyn.vitalii.spark.datasource

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, IntegerType, StringType, StructField}
import org.scalatest.FunSuite

class SchemaTest extends FunSuite {

  test("check schema"){

    val spark = SparkSession.builder
      .appName("test01")
      .master("local")
      .getOrCreate


    val df = spark.sqlContext
      .read
      .format("com.cherkashyn.vitalii.spark.datasource")
      .load("/home/cherkavi/temp/data")

    assert(df.schema.fields.size==2)

    for(field<-df.schema.fields) assert( field match {
      case StructField(_, IntegerType, _, _) => true
      case StructField(_, StringType, _, _) => true
      case _ => false
    })
  }

}
