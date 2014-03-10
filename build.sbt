name := "play-test"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)

libraryDependencies += "mysql" % "mysql-connector-java" % "+"

play.Project.playJavaSettings
