name := "spark-neo4j"

version := "1.0"

scalaVersion := "2.11.1"

resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"
libraryDependencies += "neo4j-contrib" % "neo4j-spark-connector" % "2.0.0-M2"
libraryDependencies += "org.apache.spark" % "spark-core" % "2.1.0"