package models
/*
/**
 * Created by AMoroz on 16/02/14.
 */
import play.api.db.slick.Config.driver.simple._
import java.util.UUID

case class Role(id: UUID, rolename: String, roledescription: Option[String], systemstatusid: Int)

class RoleComponent(tag: Tag) extends Table[Role](tag,Some("auth"),"roles") {
  def id = column[UUID]("roleid",O.PrimaryKey)
  def rolename = column[String]("rolename",O.NotNull)
  def roledescription = column[Option[String]]("roledescription",O.Nullable)
  def systemstatusid = column[Int]("systemstatusid",O.NotNull)

  def * = (id, rolename, roledescription, systemstatusid) <> (Role.tupled, Role.unapply _)
}
*/