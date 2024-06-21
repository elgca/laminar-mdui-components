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

//导出到这个项目中
lazy val mdui = project
  .enablePlugins(ScalaJSPlugin)
  .settings(
      libraryDependencies ++= List(
          "com.raquo" %%% "laminar" % Versions.Laminar % "provided",
      ),
      (Compile / doc / scalacOptions) ++= Seq(
          "-no-link-warnings", // Suppress scaladoc "Could not find any member to link for" warnings
      ),
      scalacOptions ++= Seq(
          "-deprecation",
      ),
//    scalacOptions ++= sys.env.get("CI").map { _ =>
//      val localSourcesPath = (LocalRootProject / baseDirectory).value.toURI
//      val remoteSourcesPath =
//        s"https://raw.githubusercontent.com/raquo/laminar-shoelace-components/${git.gitHeadCommit.value.get}/"
//      val sourcesOptionName =
//        if (scalaVersion.value.startsWith("2.")) "-P:scalajs:mapSourceURI"
//        else "-scalajs-mapSourceURI"
//
//      s"${sourcesOptionName}:$localSourcesPath->$remoteSourcesPath"
//    },
  )
  .settings(
      name := "Laminar WebComponents",
      normalizedName := "laminar-web-components",
      organization := "com.raquo",
//    homepage := Some(
//      url("https://github.com/raquo/laminar-shoelace-components"),
//    ),
//    licenses += ("MIT", url(
//      "https://github.com/raquo/laminar-shoelace-components/blob/master/LICENSE.md",
//    )),
//    scmInfo := Some(
//      ScmInfo(
//        url("https://github.com/raquo/laminar-shoelace-components"),
//        "scm:git@github.com/raquo/laminar-shoelace-components.git",
//      ),
//    ),
//    developers := List(
//      Developer(
//        id = "raquo",
//        name = "Nikita Gazarov",
//        email = "nikita@raquo.com",
//        url = url("https://github.com/raquo"),
//      ),
//    ),
//    (Test / publishArtifact) := false,
//    pomIncludeRepository := { _ => false },
//    sonatypeCredentialHost   := "s01.oss.sonatype.org",
//    sonatypeRepository       := "https://s01.oss.sonatype.org/service/local",
  )
