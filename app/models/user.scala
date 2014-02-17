package models

/**
 * Created by AMoroz on 16/02/14.
 */
/*
import play.api.db.slick.Config.driver.simple._
import java.util.UUID

case class User(id: UUID, username: String, userpassword: String, email: Option[String],
                 secretquestion: Option[String], secretanswer: Option[String], systemstatusid: Int)

class UserComponent(tag: Tag) extends Table[User](tag,Some("auth"),"users") {
  def id = column[UUID]("userid",O.PrimaryKey)
  def username = column[String]("username",O.NotNull)
  def userpassword = column[String]("userpassword",O.NotNull)
  def email = column[Option[String]]("email",O.Nullable)
  def secretquestion = column[Option[String]]("secretquestion",O.Nullable)
  def secretanswer = column[Option[String]]("secretanswer",O.Nullable)
  def systemstatusid = column[Int]("systemstatusid",O.NotNull)

  def * = (id, username, userpassword, email, secretquestion, secretanswer, systemstatusid) <>
    (User.tupled, User.unapply _)
}
*/