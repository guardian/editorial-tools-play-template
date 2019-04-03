package controllers

import com.gu.pandomainauth.PanDomainAuthSettingsRefresher
import config.Config
import play.api.Logger
import play.api.libs.ws.WSClient
import play.api.mvc._

class App(val wsClient: WSClient,
  val controllerComponents: ControllerComponents,
  val panDomainSettings: PanDomainAuthSettingsRefresher,
  val config: Config) extends BaseController with PanDomainAuthActions {

  def index = AuthAction {
    Logger.info(s"I am the ${config.appName}")
    Ok(views.html.index())
  }

}
