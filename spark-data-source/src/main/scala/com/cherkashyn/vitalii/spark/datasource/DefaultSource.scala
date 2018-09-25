package com.cherkashyn.vitalii.spark.datasource

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.{BaseRelation, RelationProvider, SchemaRelationProvider}
import org.apache.spark.sql.types.StructType

/**
  * core class that spark will pick up and will use by package name
  */
class DefaultSource extends RelationProvider with SchemaRelationProvider {

  override def createRelation(sqlContext: SQLContext,
                              parameters: Map[String, String]): BaseRelation = {
    createRelation(sqlContext, parameters, null)
  }

  override def createRelation(sqlContext: SQLContext,
                              parameters: Map[String, String],
                              schema: StructType): BaseRelation = {
    val pathToFile = parameters.getOrElse("path", throw new IllegalArgumentException("'path' must be specified for our data."))
    return new Schema(pathToFile, schema)(sqlContext)
  }

}