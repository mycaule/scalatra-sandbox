import scalariform.formatter.preferences._

scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(DanglingCloseParenthesis, Preserve)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard"
)

val ScalatraVersion = "2.7.0-RC1"

lazy val root = (project in file(".")).
  enablePlugins(JavaAppPackaging, BuildInfoPlugin, ScalatraPlugin).
  settings(
    inThisBuild(List(
      organization := "com.sandbox",
      scalaVersion := "2.13.0",
      version := "0.2.0-SNAPSHOT"
    )),
    name := "scalatra-sandbox",
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "com.sandbox",
    buildInfoOptions += BuildInfoOption.BuildTime,
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-swagger" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % Test,
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.19.v20190610" % Compile,
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % Compile,
      "org.json4s" %% "json4s-native" % "3.6.7"
    )
  )
