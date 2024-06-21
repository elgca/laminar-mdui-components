ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := Versions.Scala_3

lazy val root = (project in file("."))
  .settings(
      name := "Laminar-WebComponents-importer",
  )
  .settings(
      libraryDependencies ++= Seq(
          "com.raquo" %% "domtypes" % Versions.DomTypes,
          "com.lihaoyi" %% "upickle" % "3.1.3",
          "com.lihaoyi" %% "pprint" % "0.7.0",
          "org.json4s" %% "json4s-native" % "4.1.0-M6",
          "com.github.erosb" % "json-sKema" % "0.15.0",
          "io.vertx" % "vertx-json-schema" % "4.5.8",
          "org.scala-lang" %% "scala3-compiler" % Versions.Scala_3,
//          "com.lihaoyi" % "ammonite_3.4.2" % "3.0.0-M2-10-f6e2c001",
          ("com.eed3si9n.eval" % "eval_3.4.0" % "0.3.0"), // .cross(CrossVersion.full),
      ),
  )