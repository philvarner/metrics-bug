lazy val root = (project in file("."))
  .settings(
    name := "Foo",
    organization := "com.example",
    scalaVersion := "2.12.10",
    libraryDependencies ++= Seq(
      akka("actor"),
      akka("http-core"),
      akka("http"),
      akka("stream"),
      "fr.davit" %% "akka-http-metrics-core" % "0.6.0",
      "fr.davit" %% "akka-http-metrics-prometheus" % "0.6.0",
      "io.prometheus" % "simpleclient" % "0.6.0",
      "io.prometheus" % "simpleclient_hotspot" % "0.6.0"
    ),
    scalacOptions ++= Seq("-unchecked", "-deprecation")
  )

val akkaVersion = "2.5.27"
val akkaHttpVersion = "10.1.11"

def akka(module: String): ModuleID =
  "com.typesafe.akka" %% s"akka-$module" % (if (module.contains("http")) akkaHttpVersion
                                            else akkaVersion)

