package controllers

import play.api.mvc.{Action, BaseController, ControllerComponents}

class Healthcheck(val controllerComponents: ControllerComponents) extends BaseController {

  def healthcheck = Action {
    Ok("Healthcheck")
  }

}
