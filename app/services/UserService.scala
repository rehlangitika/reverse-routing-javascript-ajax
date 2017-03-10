package services

import models.UserData

trait UserService {

  def getUsers(username: String): UserData

  def write(userData: UserData): UserData

  def usersList(): List[UserData]

  def checkUserName(userName: String): Boolean

}
