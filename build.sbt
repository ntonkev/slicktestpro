name := "slicktestpro"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.postgresql" % "postgresql" % "9.2-1003-jdbc4",
  "com.typesafe.slick" % "slick_2.10" % "2.0.0",
  "com.typesafe.play" %% "play-slick" % "0.5.0.9"
)     

play.Project.playScalaSettings
