package com.ayazovskiy.hr.etl

import com.mongodb.casbah.Imports._
import com.typesafe.config.Config
import org.slf4j.LoggerFactory

import scala.concurrent.Future

/**
 * User: ayazovskiy
 */
class TargetMongo(conf: Config) {

  val logger = LoggerFactory.getLogger("TargetMongo")

  val client = MongoClient(conf.getString("etl.target.host"), conf.getInt("etl.target.port"))
  val coll = client(conf.getString("etl.target.db"))(conf.getString("etl.target.collection"))

  def save(row: Map[String, Any]): Future[Int] = Future {
    logger.debug("saving... {}", row)
    coll.insert(MongoDBObject(("_id", row.hashCode()) :: row.toList)).getN
  }

  def countAll: Int = {
    coll.size
  }

  def dropAll: Unit = {
    coll.dropCollection()
  }

}
