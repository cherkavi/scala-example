package com.cherkashyn.vitalii.solr_api

import scala.collection.immutable.HashMap
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import scala.io.Source

/**
  * http://www.mtitek.com/tutorials/solr/collectionsAPI.php
  * create core:
  *     cd /opt/apps/solr/bin/solr create -c {collectionName} -n {configName} -p 8983
  */
object SolrRestApi {
  private val URL = "http://localhost:8983"

  /**
    * curl -s localhost:8983/solr/admin/info/system?wt=json
    * @return
    */
  def getSolrVersion(): Any = {
    val html = Source.fromURL(s"${URL}/solr/admin/info/system?wt=json")
    val json= new JsonParser().parse(html.mkString).getAsJsonObject
    json.get("lucene").asInstanceOf[JsonObject].get("solr-spec-version")
  }


  /**
    * curl -s localhost:8983/solr/admin/cores?wt=json
    * @return
    */
  def isCollectionExists(name:String):Boolean ={
    val html = Source.fromURL(s"${URL}/solr/admin/cores?wt=json")
    val json= new JsonParser().parse(html.mkString).getAsJsonObject
    json.get("status").asInstanceOf[JsonObject].get(name)!=null
  }


  def main(args: Array[String]): Unit ={
    println(getSolrVersion())
    println(s"is collection 'collection1' exists: ${isCollectionExists("collection1")}")
    println(s"is collection 'collection1' exists: ${isCollectionExists("my_collection")}")
  }

}
