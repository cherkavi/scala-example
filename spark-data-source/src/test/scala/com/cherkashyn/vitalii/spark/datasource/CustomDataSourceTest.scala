package com.cherkashyn.vitalii.spark.datasource

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, IntegerType, StringType, StructField}
import org.scalatest.FunSuite

class CustomDataSourceTest extends FunSuite {

  val spark = SparkSession.builder
    .appName("test01")
    .master("local")
    .getOrCreate
  val df = spark.sqlContext
    .read
    .format("com.cherkashyn.vitalii.spark.datasource")
    .load("/home/cherkavi/temp/data")


  test("check schema"){

    // when
    // DataFrame

    assert(df.schema.fields.size==2)

    for(field<-df.schema.fields) assert( field match {
      case StructField(_, IntegerType, _, _) => true
      case StructField(_, StringType, _, _) => true
      case _ => false
    })
  }

  test("read data from DataSource"){

    // when
    val data = df.take(10)

    // then
    assert(data.size==3)
  }

}
