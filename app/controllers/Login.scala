package controllers

import play.api.libs.ws.WSClient
import play.api.mvc._
import com.gu.pandomainauth.PanDomainAuthSettingsRefresher
import config.Config

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Login(
  val wsClient: WSClient,
  val controllerComponents: ControllerComponents,
  val panDomainSettings: PanDomainAuthSettingsRefresher,
  val config: Config
)  extends BaseController with PanDomainAuthActions {

  def reauth = AuthAction {
    Ok("auth ok")
  }

  def oauthCallback = Action.async { implicit request =>
    processGoogleCallback()
  }

  def logout = Action.async { implicit request =>
    Future(processLogout)
  }
}