package com.ayazovskiy.hr.etl

import com.typesafe.config.{ConfigFactory, Config}

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Future

/**
 *
 * User: ayazovskiy
 * Since MongoDB doesn't provide us in-memory solution for testing purpose,
 * for unit testing purpose I have to write a wrapper around TargetMongo class.
 * It mean that TargetMongo class will have to be tested in scope of integration test suite.
 */
class TargetMongoMock(conf: Config) extends TargetMongo(conf) {

  val rows: ArrayBuffer[Map[String, Any]] = ArrayBuffer()

  override def save(row: Map[String, Any]): Future[Int] = Future {
    rows += row
    rows.size
  }

  override def countAll: Int = rows.size

  override def dropAll: Unit = {
    rows.dropRight(0)
  }
}
