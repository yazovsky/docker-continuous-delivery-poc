package com.ayazovskiy.hr.etl

import com.typesafe.config.{Config, ConfigFactory}
import org.scalatest._

/**
 * User: ayazovskiy
 */
class ETLTest extends FeatureSpec with GivenWhenThen with BeforeAndAfterEach {

  override protected def beforeEach() = TestUtils.initTestDataSet

  override protected def afterEach() = TestUtils.cleanUp

  info("As ETL client")
  info("I want to be able to start ETL process")
  info("So I can watch data copied from Source to Target")
  info("And get use of data in Target")

  feature("Normal/simple ETL scenario") {
    scenario("ETL initialization") {
      When("a configuration is correct")
      val conf: Config = ConfigFactory.load()

      Then("initialization goes well")
      val source: SourceJDBC = new SourceJDBC(conf)
      val target: TargetMongo = new TargetMongoMock(conf)
      assert(source != null)
      assert(target != null)
    }

    scenario("run ETL when data is correct and no errors happen") {

      Given("a configuration is correct")
      val conf: Config = ConfigFactory.load()
      val source: SourceJDBC = new SourceJDBC(conf)
      val target: TargetMongoMock = new TargetMongoMock(conf)

      And("a Source storage has data")
      assert(source.select != null)
      assert(source.select.size > 0)

      When("the ETL process is started")
      new ETL(source, target).doETL()

      Then("the Target storage must get copy of data")
      assert(target.countAll > 0)
    }
  }
}
