import VersionHelper.{versionFmt, fallbackVersion}

ThisBuild / scalaVersion := Versions.Scala_3

resolvers ++= Resolver.sonatypeOssRepos("public")
credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")

ThisBuild / version := dynverGitDescribeOutput.value
  .mkVersion(out => versionFmt(out, dynverSonatypeSnapshots.value),
      fallbackVersion(dynverCurrentDate.value))

ThisBuild / dynver := {
  val d = new java.util.Date
  sbtdynver.DynVer
    .getGitDescribeOutput(d)
    .mkVersion(out => versionFmt(out, dynverSonatypeSnapshots.value),
        fallbackVersion(d))
}

//导出到这个项目中
lazy val mdui = (project in file("."))
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
  )
  .settings(
      //   versionScheme := Some("early-semver"),
      version := "0.1.0",
      name := "Laminar MDUI",
      normalizedName := "laminar-mdui",
      organization := "io.github.elgca",
      homepage := Some(url("https://github.com/elgca/laminar-mdui-components")),
      scmInfo := Some(
          ScmInfo(
              url("https://github.com/elgca/laminar-mdui-components"),
              "scm:git@github.com:elgca/laminar-mdui-components.git",
          ),
      ),
      developers := List(
          Developer(
              id = "io.github.elgca",
              name = "Kewenchao",
              email = "modtekent@live.com",
              url = url("https://github.com/elgca"),
          ),
      ),
      licenses := List("MIT" -> url("https://opensource.org/license/MIT")),
      (Test / publishArtifact) := false,
      pomIncludeRepository := { _ => false },
      //   sonatypeCredentialHost := "s01.oss.sonatype.org",
      //   sonatypeRepository := "https://s01.oss.sonatype.org/service/local",
      //   publishTo := {
      //     // For accounts created after Feb 2021:
      //     val nexus = "https://s01.oss.sonatype.org/"
      //     // val nexus = "https://oss.sonatype.org/"
      //     if (isSnapshot.value)
      //       Some("snapshots" at nexus + "content/repositories/snapshots")
      //     else Some("releases" at nexus + "service/local/staging/deploy/maven2")
      //   },
      publishMavenStyle := true,
  )
