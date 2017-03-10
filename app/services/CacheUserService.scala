package services

import com.google.inject.Inject
import models.UserData
import play.api.cache.CacheApi

class CacheUserService @Inject()(cache: CacheApi) extends UserService {

  def getUsers(userName: String): UserData = {
    val user = cache.get[List[UserData]]("user").toList.flatten
    println("User List : " + user)
    val regUser: Option[UserData] = user.find(x => x.userName.equals(userName))
    regUser match {
      case Some(data) => data
      case None => throw new Exception("No User Exception!!")
    }
  }

  def checkUserName(userName: String): Boolean = {
    val usersList = cache.get[List[UserData]]("user").toList.flatten
    val user: List[UserData] = usersList.filter(user => user.userName == userName)
    if(user.nonEmpty) true else false
  }

  def write(userData: UserData): UserData = {
    println("Before storing")
    val usersList = cache.get[List[UserData]]("user").toList.flatten
    println("Storing user : " + usersList)
    cache.remove("user")
    cache.set("user", usersList :+ userData)
    println(s"Stored data : ${usersList :+ userData}")
    userData
  }

  def usersList(): List[UserData] = {
    cache.get[List[UserData]]("user").toList.flatten
  }

}
