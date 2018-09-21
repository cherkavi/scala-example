package com.cherkashyn.vitalii.solr_api

import com.google.gson.{JsonObject, JsonParser, JsonPrimitive}
import org.apache.http.client.methods.{HttpGet, HttpPost, HttpRequestBase}
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder

import scala.io.Source
import scala.util.Try

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

  private def postRequestAsJson(url:String, payload: String): HttpRequestBase = {
    val post = new HttpPost(url)
    post.setHeader("Content-Type", "text/json");
    post.setEntity(new StringEntity(payload))
    post
  }

  private def getRequestAsJson(url: String): HttpRequestBase = {
    val request = new HttpGet(url)
    request.setHeader("Content-Type", "text/json");
    request
  }

  /**
    * insert record into default core/collection
    * @param args
    */
  def insertRecordAsJson(data : Map[String, String]): Boolean = {
    val dataObject = new JsonObject()
    for ((k, v) <- data) dataObject.add(k, new JsonPrimitive(v))
    val client = HttpClientBuilder.create().build()
    try {
      val attempt = Try(client.execute(postRequestAsJson(s"${URL}/solr/update?commit=true",s"[${dataObject.toString}]")))
      attempt match {
        case scala.util.Success(response) => {
          try {
            return (response.getStatusLine.getStatusCode >= 200 && response.getStatusLine.getStatusCode < 300)
          } finally {
            response.close
          }
        }
        case scala.util.Failure(exception) => {
          return false
        }
      }
    } finally {
      client.close()
    }
  }

  /**
    * http://localhost:8983/solr/collection1/select?q=*%3A*&wt=json&indent=true
    * @return
    */
  def readRecords():String = {
    val client = HttpClientBuilder.create().build()
    try {
      val attempt = Try(client.execute(getRequestAsJson(s"${URL}/solr/collection1/select?q=*%3A*&wt=json&indent=true")))
        attempt match {
        case scala.util.Success(response) => {
          return Source.fromInputStream(response.getEntity.getContent).mkString
        }
        case scala.util.Failure(exception) => {
          null
        }
      }
    } finally {
      client.close()
    }

  }

  def main(args: Array[String]): Unit ={
    println(getSolrVersion())
    println(s"is collection 'collection1' exists: ${isCollectionExists("collection1")}")
    println(s"is collection 'collection1' exists: ${isCollectionExists("my_collection")}")
    // println(insertRecordAsJson(Map("id"->"01", "title"-> "title #01")))
    println(readRecords())
  }

}
