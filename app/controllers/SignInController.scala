package controllers

import javax.inject.Inject

import com.google.inject.name.Named
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}
import services.UserService

class SignInController @Inject()(@Named("cache") userService: UserService)(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def getAccess(userName: String) = Action { implicit request =>
    if (userService.checkUserName(userName)) {
      val userData = userService.getUsers(userName)
      Ok(views.html.profilePage(userData))
    }
    else {
      Ok(views.html.signInForm())
    }
  }
}
