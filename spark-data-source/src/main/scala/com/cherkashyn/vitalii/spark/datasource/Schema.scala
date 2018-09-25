package com.cherkashyn.vitalii.spark.datasource

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

import scala.collection.mutable.ListBuffer

/**
  * list of the fields to be used as a schema
  * @param pathToFile - path to file with data ( header can be read )
  * @param userSchema
  * @param sqlContext
  */
class Schema (pathToFile: String, userSchema: StructType)
             (@transient val sqlContext: SQLContext)
  extends BaseRelation with Serializable {

  override def schema: StructType = {
    if (this.userSchema != null) this.userSchema else defineSchema
  }


  private def defineSchema:StructType = {
    val fields = new ListBuffer[StructField]
    fields += StructField("name", StringType, true)
    fields += StructField("age", IntegerType, true)
    StructType( fields.toList )
  }

}