import config.LogConfig
import play.api.ApplicationLoader.Context
import play.api.libs.ws.ahc.AhcWSComponents
import router.Routes
import play.api.BuiltInComponentsFromContext
import controllers.AssetsComponents
import play.filters.HttpFiltersComponents

class AppComponents(context: Context)
  extends BuiltInComponentsFromContext(context) with AhcWSComponents with AssetsComponents with HttpFiltersComponents {

  val logger = new LogConfig

  lazy val router = new Routes(httpErrorHandler, appController, healthcheckController, loginController, assets)
  lazy val appController = new controllers.App(wsClient, controllerComponents)
  lazy val loginController = new controllers.Login(wsClient, controllerComponents)
  lazy val healthcheckController = new controllers.Healthcheck(controllerComponents)
}


