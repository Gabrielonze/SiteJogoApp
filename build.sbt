name := """SiteJogo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache, 
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.webjars" % "jquery" % "1.11.2",
  ws
)
