package com.cherkashyn.vitalii.spark.datasource

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.{BaseRelation, DataSourceRegister, RelationProvider, SchemaRelationProvider}
import org.apache.spark.sql.types.StructType

/**
  * core class that spark will pick up and will use by package name
  */
class DefaultSource
  extends RelationProvider
    with DataSourceRegister
    with SchemaRelationProvider {

  // -------- RelationProvider -----------
  override def createRelation(sqlContext: SQLContext,
                              parameters: Map[String, String]): BaseRelation = {
    createRelation(sqlContext, parameters, null)
  }

  // -------- RelationProvider -----------
  override def createRelation(sqlContext: SQLContext,
                              parameters: Map[String, String],
                              schema: StructType): BaseRelation = {
    val pathToFile = parameters
      .getOrElse("path", throw new IllegalArgumentException("'path' must be specified for our data."))
    return new CustomDataSource(pathToFile, schema)(sqlContext)
  }


  /**
    * DataSource registeration with short name
    * @return
    */
  override def shortName(): String = {
    "stub-datasource"
  }

}