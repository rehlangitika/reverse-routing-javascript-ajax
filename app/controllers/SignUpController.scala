package controllers

import javax.inject.Inject

import com.google.inject.name.Named
import models.UserData
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}
import services.UserService

class SignUpController @Inject()(@Named("cache") userService: UserService)(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def createUser(name: String, gender: String, email: String, userName: String,
                 password: String, confirmPassword: String) = {
    Action { implicit request =>
      val user = UserData(name, gender, email, userName, password, confirmPassword)
      if (!userService.checkUserName(userName)) {
        userService.write(user)
        Ok(views.html.profilePage(user))
      }
      else {
        Ok(views.html.signUpForm())
      }
    }
  }
}
