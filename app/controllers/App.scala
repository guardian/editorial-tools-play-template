package controllers

import config.Config
import play.api.Logger
import play.api.mvc._

class App(config: Config) extends Controller {

  def index = Action {
    Logger.info(s"I am the ${config.appName}")
    Ok(views.html.index())
  }
}
