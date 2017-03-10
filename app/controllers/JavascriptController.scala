package controllers

import play.api.mvc.{Action, Controller}
import play.api.routing.JavaScriptReverseRouter

class JavascriptController extends Controller {

  def javascriptRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.CountController.count,
        routes.javascript.HomeController.index,
        routes.javascript.HomeController.signUp,
        routes.javascript.HomeController.signIn,
        routes.javascript.SignUpController.createUser,
        routes.javascript.SignInController.getAccess
      )
    ).as("text/javascript")
  }
}
