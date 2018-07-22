package com.sandbox
package teams

import org.scalatra.test.specs2._

class TeamsSpec extends ScalatraSpec {
  def is = s2"""
  GET / on Teams
    should return status 200 $root200
  GET / on Teams with a name param
    should return status 200 $nameParamWorks
  GET /:slug on Teams
    should return status 200 $slugWorks
"""

  implicit val swagger = new FootballSwagger
  addServlet(new TeamsController, "/teams/*")

  def root200 = get("/teams") {
    status must_== 200
  }

  def nameParamWorks = get("/teams/?name=rose") {
    status must_== 200
  }

  def slugWorks = get("/teams/red-rose") {
    status must_== 200
  }
}
