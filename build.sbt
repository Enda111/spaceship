ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "spaceship"
  )

libraryDependencies += "org.processing" % "core" % "3.3.7"
