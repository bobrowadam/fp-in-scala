import Dependencies._

lazy val root = (project in file("."))
  .settings(
    name := "fp-in-scala",
    organization := "bob",
    version := "0.0.1",
    scalaVersion := "2.12.9",
    maxErrors := 3,      
  )

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
