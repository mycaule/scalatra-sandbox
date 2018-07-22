package com.sandbox
package teams

import org.scalatra._

import org.scalatra.swagger._
import org.scalatra.swagger.ResponseMessage

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.json._

class TeamsController(implicit val swagger: Swagger) extends ScalatraServlet with NativeJsonSupport with SwaggerSupport with ContentEncodingSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription = "The championship API. It exposes operations for browsing and searching lists of teams"

  before() {
    contentType = formats("json")
  }

  val getTeams =
    (apiOperation[List[Team]]("getTeams")
      summary "Show all teams"
      tags ("Teams")
      description "Shows all the teams in the team shop. You can search it too."
      parameter queryParam[Option[String]]("name").description("A name to search for"))

  get("/", operation(getTeams)) {
    params.get("name") match {
      case Some(name) => TeamData.all filter (_.name.toLowerCase contains name.toLowerCase())
      case None       => TeamData.all
    }
  }

  val findBySlug =
    (apiOperation[Team]("findBySlug")
      summary "Find by a team by its slug"
      tags ("Teams")
      parameters (
        pathParam[String]("slug").description("Slug of team that needs to be fetched"))
        responseMessage ResponseMessage(404, "Slug Not Found"))

  get("/:slug", operation(findBySlug)) {
    TeamData.all find (_.slug == params("slug")) match {
      case Some(b) => b
      case None    => halt(404)
    }
  }

  post("/", operation(findBySlug)) {
    TeamData.all find (_.slug == params("slug")) match {
      case Some(b) => b
      case None    => halt(404)
    }
  }
}

case class Team(slug: String, name: String)

object TeamData {
  var all = List(
    Team("yellow-tulip", "Yellow Tulip"),
    Team("red-rose", "Red Rose"),
    Team("black-rose", "Black Rose"))
}
