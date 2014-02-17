package models
/*
/**
 * Created by AMoroz on 16/02/14.
 */
import play.api.db.slick.Config.driver.simple._
import java.util.UUID

case class UserInRole(userid: UUID, roleid: UUID, systemstatusid: Int)

class UserInRoleComponent(tag: Tag) extends Table[UserInRole](tag,Some("auth"),"userinrole") with DAL {
  def userid = column[UUID]("userid",O.PrimaryKey)
  def roleid = column[UUID]("roleid",O.PrimaryKey)
  def systemstatusid = column[Int]("systemstatusid",O.NotNull)

  def * = (userid, roleid, systemstatusid) <>
    (UserInRole.tupled, UserInRole.unapply _)

  def user = foreignKey("auth_usersinroles_userid", userid, users)(_.id)
  def role = foreignKey("auth_usersinroles_roleid", roleid, roles)(_.id)

}
*/