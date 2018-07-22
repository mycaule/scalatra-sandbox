package com.sandbox
package status

import org.scalatra.test.specs2._

class StatusSpec extends ScalatraSpec {
  def is = s2"""
  GET / on Status
    should return status 200 $root200
"""

  implicit val swagger = new FootballSwagger
  addServlet(new StatusController, "/status/*")

  def root200 = get("/status") {
    status must_== 200
  }
}
