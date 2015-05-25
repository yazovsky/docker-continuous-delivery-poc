package com.ayazovskiy.hr.etl

import com.typesafe.config.{ConfigFactory, Config}
import org.slf4j.LoggerFactory

import scala.util.{Success, Failure}

/**
  * User: ayazovskiy
 */
class ETL(val source: SourceJDBC, val target: TargetMongo) {

  val logger = LoggerFactory.getLogger("ELT")

  def this(conf: Config) {
    this(new SourceJDBC(conf), new TargetMongo(conf))
  }

  def doETL() = {
    logger.info("ETL Started!")

    source.select.map(
      (row: Map[String, Any]) => target.save(row)
    )

    logger.info("ETL Finished: " + target)
  }

}
