package org.zyq

import org.apache.spark.{SparkConf, SparkContext}
import org.neo4j.spark.Neo4j

//import javafx.application.Application

/**
 * Hello world!
 *Error:(22, 65) bad symbolic reference to org.apache.spark.sql encountered in class file 'Neo4j.class'.
Cannot access term sql in package org.apache.spark. The current classpath may be
missing a definition for org.apache.spark.sql, or Neo4j.class may have been compiled against a version that's
incompatible with the one found on the current classpath.
  val rdd = neo.cypher("MATCH (n:IPCNode) RETURN id(n) as id ").loadRowRdd
 */
object App  {
//  println( "Hello World!" )
def main(args: Array[String]): Unit = {

  var conf = new SparkConf().setAppName("testNeo4jWithSpark")
//      .setMaster("local")
      .setMaster("spark://10.10.1.8:17077")
      .set("spark.executor.cores","3")
    .set("spark.neo4j.bolt.url","bolt://10.10.1.8:7687")
    .set("spark.neo4j.bolt.user","neo4j")
    .set("spark.neo4j.bolt.password","123456")
//    .set("spark.neo4j.bolt.url","bolt://neo4j:123456@10.10.1.8")
  var sc:SparkContext = new SparkContext(conf)

  val neo = Neo4j(sc)
  //
  val rdd = neo.cypher("MATCH (n:IPCNode) RETURN id(n) as id LIMIT 10 ").loadRowRdd
  println("count:" + rdd.count())
}
}
