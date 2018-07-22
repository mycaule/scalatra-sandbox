package com.sandbox
package status

import org.scalatra._

import org.scalatra.swagger._

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.json._

class StatusController(implicit val swagger: Swagger) extends ScalatraServlet with NativeJsonSupport with SwaggerSupport with ContentEncodingSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription = "The championship API"

  before() {
    contentType = formats("json")
  }

  val getStatus =
    (apiOperation[Status]("getStatus")
      summary "Show app status"
      tags ("Status")
      description "Shows the status of the application.")

  get("/", operation(getStatus)) {
    val info = com.sandbox.BuildInfo
    Status(
      info.name,
      info.version,
      info.scalaVersion,
      info.sbtVersion,
      info.builtAtString,
      "autres infos..."
    )
  }
}

case class Status(name: String, version: String, scalaVersion: String, sbtVersion: String, builtAt: String, other: String)
