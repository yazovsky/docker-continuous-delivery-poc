package com.ayazovskiy.hr.web

import javax.ws.rs._

import com.ayazovskiy.hr.etl.{ETL, TargetMongo}
import com.typesafe.config.{Config, ConfigFactory}

/**
 * User: ayazovskiy
 */
@Path("/etl")
class Resource {

  @GET
  @Produces(Array("application/json"))
  def healthCheck() = {
    val config: Config = ConfigFactory.load()
    new ETL(config)
    "{ 'status': 'ok' }"
  }

  @POST
  def runEtl() = {
    val config: Config = ConfigFactory.load()
    new ETL(config).doETL()
  }

  @DELETE
  def dropAll() = {
    val conf: Config = ConfigFactory.load()
    new TargetMongo(conf).dropAll
  }

}
