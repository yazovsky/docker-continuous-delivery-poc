name := "hr-etl"

version := "1.0"

scalaVersion := "2.11.6"

mainClass in assembly := some("com.ayazovskiy.hr.App")
assemblyJarName in assembly := s"${name.value}-${version.value}.jar"

libraryDependencies += "com.sun.jersey" % "jersey-server" % "1.2"
//libraryDependencies += "com.sun.jersey" % "jersey-json" % "1.2"
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
