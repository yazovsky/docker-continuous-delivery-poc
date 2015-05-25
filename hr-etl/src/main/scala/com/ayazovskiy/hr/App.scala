package com.ayazovskiy.hr

import com.sun.jersey.spi.container.servlet.ServletContainer
import com.typesafe.config.{Config, ConfigFactory}
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}

/**
 * User: ayazovskiy
 */
object App {
  
  def main(args: Array[String]) {
    startServer()
  }

  def startServer() = {
    val conf: Config = ConfigFactory.load()
    val server = new Server(8081)
    val connector = new SelectChannelConnector()
    server.addConnector(connector)

    val holder: ServletHolder = new ServletHolder(classOf[ServletContainer])
    holder.setInitParameter(
      "com.sun.jersey.config.property.resourceConfigClass",
      "com.sun.jersey.api.core.PackagesResourceConfig")
    holder.setInitParameter("com.sun.jersey.config.property.packages", "com.ayazovskiy.hr.web")

    val context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)
    context.addServlet(holder, "/*")

    server.start
  }
}