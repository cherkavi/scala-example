package com.cherkashyn.vitalii.solr_api

import scala.collection.immutable.HashMap
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser

/**
  */
object SolrRestApi {
  private val URL = "http://localhost:8983"

  def getSolrVersion(): Any = {
    import scala.io.Source
    val html = Source.fromURL(s"${URL}/solr/admin/info/system?wt=json")
    val json= new JsonParser().parse(html.mkString).getAsJsonObject
    json.get("lucene").asInstanceOf[JsonObject].get("solr-spec-version")
  }



  def main(args: Array[String]): Unit ={
    println(getSolrVersion())
  }
}