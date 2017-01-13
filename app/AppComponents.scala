import config.LogConfig
import play.api._
import play.api.ApplicationLoader.Context
import router.Routes
import config._

class AppComponents(context: Context)
  extends BuiltInComponentsFromContext(context) {


  val config = new Config(context.initialConfiguration)
  val logger = new LogConfig(config)




  lazy val router = new Routes(httpErrorHandler, appController, healthcheckController, assets)
  lazy val assets = new controllers.Assets(httpErrorHandler)
  lazy val appController = new controllers.App(config)
  lazy val healthcheckController = new controllers.Healthcheck()
}


