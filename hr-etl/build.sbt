name := "hr-etl"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies += "com.sun.jersey" % "jersey-server" % "1.2"
libraryDependencies += "org.eclipse.jetty" % "jetty-server" % "8.0.0.M0"
libraryDependencies += "org.eclipse.jetty" % "jetty-servlet" % "8.0.0.M0"
libraryDependencies += "org.mongodb" %% "casbah" % "2.8.1"
libraryDependencies += "com.typesafe" % "config" % "1.3.0"
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc" % "2.2.6"
libraryDependencies += "com.h2database" % "h2" % "1.4.187"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.12"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

// build "fat" jar
mainClass in assembly := some("com.ayazovskiy.hr.App")
assemblyJarName in assembly := s"${name.value}-${version.value}.jar"
artifact in (Compile, assembly) := {
  val art = (artifact in (Compile, assembly)).value
  art.copy(`classifier` = Some("assembly"))
}
addArtifact(artifact in (Compile, assembly), assembly)

// publication settings: I'll replace IP with face hostname after I integrate service discovery
publishTo := {
  val nexus = "http://45.55.142.165:8081/artifactory"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("Artifactory Realm" at s"$nexus/libs-snapshot-local")
  else
    Some("Artifactory Realm" at s"$nexus/libs-release-local")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
