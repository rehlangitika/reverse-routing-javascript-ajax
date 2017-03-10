package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject() extends Controller {


  def index = Action {
    Ok(views.html.main())
  }

  def signUp=Action{
    Ok(views.html.signUpForm())
  }

  def signIn=Action{
    Ok(views.html.signInForm())
  }

}
