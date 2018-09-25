package com.cherkashyn.vitalii.spark.datasource

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.sources.{BaseRelation, TableScan}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

import scala.collection.mutable.ListBuffer

/**
  * list of the fields to be used as a schema
  * @param pathToFile - path to file with data ( header can be read )
  * @param userSchema
  * @param sqlContext
  */
class CustomDataSource(pathToFile: String, userSchema: StructType)
                      (@transient val sqlContext: SQLContext)
  extends BaseRelation // data schema
    with TableScan     // read data from external sources
    with Serializable {// will be executed on remote machines


  // ---------------- schema begin -----------
  override def schema: StructType = {
    if (this.userSchema != null) this.userSchema else defineSchema
  }

  private def defineSchema:StructType = {
    val fields = new ListBuffer[StructField]
    fields += StructField("name", StringType, true)
    fields += StructField("age", IntegerType, true)
    StructType( fields.toList )
  }
  // ---------------- schema end -----------

  override def buildScan(): RDD[Row] = {
    val row1 = Row.fromTuple(("one",1))
    val row2 = Row.fromTuple(("two",2))
    val row3 = Row.fromTuple(("three",3))
    sqlContext.sparkContext.makeRDD( Seq(row1, row2, row3) )
  }

}