package com.cherkashyn.vitalii.finch

import io.finch._
import com.twitter.finagle.Http
import com.twitter.util.Await

object Finchwebapp extends App {
  val api: Endpoint[String] = get("hello") { Ok("Hello, World!") }

  println("started http://localhost:8080")
  Await.ready(Http.server.serve(":8080", api.toServiceAs[Text.Plain]))
}
