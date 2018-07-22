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
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Ywarn-unused-import"
)

lazy val root = (project in file(".")).
  enablePlugins(BuildInfoPlugin, ScalatraPlugin).
  settings(
    inThisBuild(List(
      organization := "com.sandbox",
      scalaVersion := "2.12.4",
      version      := "0.2.0-SNAPSHOT"
    )),
    name := "scalatra-sandbox",
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "com.sandbox",
    buildInfoOptions += BuildInfoOption.BuildTime,
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % "2.6.+",
      "org.scalatra" %% "scalatra-swagger" % "2.6.+",
      "org.scalatra" %% "scalatra-scalate" % "2.6.+",
      "org.scalatra" %% "scalatra-specs2" % "2.6.+" % Test,
      "org.json4s" %% "json4s-native" % "3.5.3",
      "ch.qos.logback" % "logback-classic" % "1.2.3" % Provided,
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.7.v20170914" % Provided,
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % Provided
    )
  )
