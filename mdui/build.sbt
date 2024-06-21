import VersionHelper.{versionFmt, fallbackVersion}

ThisBuild / scalaVersion := Versions.Scala_3

resolvers ++= Resolver.sonatypeOssRepos("public")

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
      name := "Laminar MDUI",
      normalizedName := "laminar-mdui",
      organization := "elgca",
      homepage := Some(url("https://github.com/elgca/laminar-mdui-components")),
      developers := List(
          Developer(
              id = "elgca",
              name = "Kewenchao",
              email = "modtekent@live.com",
              url = url("https://github.com/elgca"),
          ),
      ),
      licenses := List("MIT" -> url("https://opensource.org/license/MIT")),
      (Test / publishArtifact) := false,
      pomIncludeRepository := { _ => false },
      sonatypeCredentialHost := "s01.oss.sonatype.org",
      sonatypeRepository := "https://s01.oss.sonatype.org/service/local",
  )
