ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "spaceship"
  )

libraryDependencies += "org.processing" % "core" % "3.3.7"
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.3.6"
libraryDependencies += "com.learningobjects" %% "scaloi" % "0.3.1"
