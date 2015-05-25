package com.ayazovskiy.hr.etl

import com.typesafe.config.Config
import scalikejdbc._

/**
 * User: ayazovskiy
 */
class SourceJDBC(conf: Config) {

  // initialize driver and connections pool if not initialized yet
  if (!ConnectionPool.isInitialized()) {
    Class.forName(conf.getString("etl.source.driver"))
    ConnectionPool.singleton(
      conf.getString("etl.source.connectionUrl"),
      conf.getString("etl.source.user"),
      conf.getString("etl.source.pass"))
  }

  val job = conf.getString("etl.job")

  def select: List[Map[String, Any]] = {
    SQL.apply(job).map(_.toMap()).list.apply()
  }

}
