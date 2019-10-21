import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.bob"
ThisBuild / organizationName := "bob"

lazy val root = (project in file("."))
  .settings(
    name := "fp-in-scala",
    libraryDependencies += scalaTest % Test
  )
