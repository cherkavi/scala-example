package com.cherkashyn.vitalii.solr_api


/**
  */
object SolrRestApi {

  def getSolrVersion(): String = {
    "version"
  }

  def main(args: Array[String]): Unit ={
    println(getSolrVersion())
  }
}