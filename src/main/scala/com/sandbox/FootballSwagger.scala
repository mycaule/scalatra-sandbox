package com.sandbox

import org.scalatra.ScalatraServlet
import org.scalatra.swagger.{ ApiInfo, NativeSwaggerBase, Swagger }

class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase

object FootballSwagger {
  val Info = ApiInfo(
    "The Football API",
    "Docs for the Football API",
    "http://scalatra.org",
    "github.com/mycaule",
    "MIT",
    "http://opensource.org/licenses/MIT"
  )
}

class FootballSwagger extends Swagger(Swagger.SpecVersion, "1", FootballSwagger.Info)
