package com.ayazovskiy.hr.etl

import com.typesafe.config.{ConfigFactory, Config}
import org.slf4j.LoggerFactory

import scala.concurrent.Future
import scala.util.{Success, Failure}

/**
  * User: ayazovskiy
 */
class ETL(val source: SourceJDBC, val target: TargetMongo) {

  val logger = LoggerFactory.getLogger("ELT")

  def this(conf: Config) {
    this(new SourceJDBC(conf), new TargetMongo(conf))
  }

  def doETL(callback: Option[(AnyRef) => Unit] = None) = {
    logger.info("ETL Started!")

    source.select.foreach(
      (row: Map[String, Any]) => {
        val save: Future[Int] = target.save(row)
        if (callback.isDefined) save.onComplete(callback.get)
      }
    )

    logger.info("ETL Finished: " + target)
  }

}
