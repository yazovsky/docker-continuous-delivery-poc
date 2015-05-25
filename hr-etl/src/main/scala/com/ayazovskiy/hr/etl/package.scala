package com.ayazovskiy.hr

import scalikejdbc.AutoSession

import scala.concurrent.ExecutionContext
import scala.concurrent.forkjoin.ForkJoinPool

/**
 * User: ayazovskiy
 */
package object etl {
  implicit val ec = ExecutionContext.fromExecutor(new ForkJoinPool(8))
  implicit val session = AutoSession
}
