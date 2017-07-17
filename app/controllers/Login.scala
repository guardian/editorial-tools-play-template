package controllers

import play.api.libs.ws.WSClient
import play.api.mvc._

class Login(val wsClient: WSClient, val controllerComponents: ControllerComponents) extends BaseController with PanDomainAuthActions {

  def reauth = AuthAction {
    Ok("auth ok")
  }

  def oauthCallback = Action.async { implicit request =>
    processGoogleCallback()
  }
}
