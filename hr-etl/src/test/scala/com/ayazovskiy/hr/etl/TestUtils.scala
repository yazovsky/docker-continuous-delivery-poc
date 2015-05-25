package com.ayazovskiy.hr.etl

import com.typesafe.config.{Config, ConfigFactory}
import scalikejdbc._

/**
 * User: ayazovskiy
 */
object TestUtils {

  implicit val session = AutoSession
  
  { // initialize driver
  val conf: Config = ConfigFactory.load()
    Class.forName(conf.getString("etl.source.driver"))
    ConnectionPool.singleton(
      conf.getString("etl.source.connectionUrl"),
      conf.getString("etl.source.user"),
      conf.getString("etl.source.pass"))
  }

  def initTestDataSet: Unit = {

    sql"""
    CREATE TABLE IF NOT EXISTS ttable (
      a varchar(255) NOT NULL DEFAULT '',
      b int(11) NOT NULL,
      c varchar(255) NOT NULL,
      PRIMARY KEY (a)
    )
    """.execute.apply()

    val rs = sql"SELECT a FROM ttable WHERE a in (1, 2, 3)".map(_.toMap()).list.apply()
    if (rs.size > 0) cleanUp

    (1 to 3).map((id) => {
      SQL(s"INSERT INTO ttable (a, b, c) VALUES ('$id', 1, 'test project')").update().apply()
    })
  }

  def cleanUp = {
    (1 to 3).map((id) => {
      SQL(s"DELETE FROM ttable WHERE a = '$id'").execute().apply()
    })
  }
}
