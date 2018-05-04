name := "alexa-whats-on"

version := "0.1"

scalaVersion := "2.12.5"

assemblyJarName in assembly := "alexa-whats-on.jar"


val circeVersion = "0.9.3"

libraryDependencies ++= Seq(
  "io.github.mkotsur" %% "aws-lambda-scala" % "0.0.13",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
//  "io.circe" %% "circe-java8" % circeVersion,
  "org.scalaj" %% "scalaj-http" % "2.4.0",
  "com.amazonaws" % "aws-lambda-java-log4j2" % "1.1.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  "org.apache.logging.log4j" % "log4j-core" % "2.11.0",
  "org.apache.logging.log4j" % "log4j-api" % "2.11.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
)

// Assembly config

target in assembly := baseDirectory.value
test in assembly := {}

assemblyMergeStrategy in assembly := {
  case PathList(ps@_*) if ps.last == "Log4j2Plugins.dat" => MergeStrategy.last
  case x                                                 =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}