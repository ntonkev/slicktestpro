package models

/**
 * Created by AMoroz on 14/02/14.
 */

import play.api.db.slick.Config.driver.simple._
import scala.slick.lifted.TableQuery
import java.util.UUID

// Paging helper
case class Page[A] (items: Seq[A], page: Int, offset: Long, total: Long) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}

class DAL {

// dict.language model
  case class Language(id: Int, name: String, description: Option[String], code: String)
  class LanguageComponent(tag: Tag) extends Table[Language](tag,Some("dict"),"language") {
    def id = column[Int]("languageid",O.PrimaryKey)
    def name = column[String]("name",O.NotNull)
    def description = column[Option[String]]("description",O.Nullable)
    def code = column[String]("code",O.NotNull)

    def * = (id, name, description, code) <> (Language.tupled, Language.unapply _)
  }
  val languages = TableQuery[LanguageComponent]

// dict.entity model
  case class Entity(id: Int, name: String, description: Option[String])
  class EntityComponent(tag: Tag) extends Table[Entity](tag,Some("dict"),"entity") {
    def id = column[Int]("entityid",O.PrimaryKey)
    def name = column[String]("name",O.NotNull)
    def description = column[Option[String]]("description",O.Nullable)

    def * = (id, name, description) <> (Entity.tupled, Entity.unapply _)
  }
  val entities = TableQuery[EntityComponent]

// auth.users model
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
  val users = TableQuery[UserComponent]

// auth.roles model
  case class Role(id: UUID, rolename: String, roledescription: Option[String], systemstatusid: Int)
  class RoleComponent(tag: Tag) extends Table[Role](tag,Some("auth"),"roles") {
    def id = column[UUID]("roleid",O.PrimaryKey)
    def rolename = column[String]("rolename",O.NotNull)
    def roledescription = column[Option[String]]("roledescription",O.Nullable)
    def systemstatusid = column[Int]("systemstatusid",O.NotNull)

    def * = (id, rolename, roledescription, systemstatusid) <> (Role.tupled, Role.unapply _)
  }
  val roles = TableQuery[RoleComponent]

// auth.userinrole model
  case class UserInRole(userid: UUID, roleid: UUID, systemstatusid: Int)
  class UserInRoleComponent(tag: Tag) extends Table[UserInRole](tag,Some("auth"),"userinrole") {
    def userid = column[UUID]("userid",O.PrimaryKey)
    def roleid = column[UUID]("roleid",O.PrimaryKey)
    def systemstatusid = column[Int]("systemstatusid",O.NotNull)

    def * = (userid, roleid, systemstatusid) <>
      (UserInRole.tupled, UserInRole.unapply _)

    def user = foreignKey("auth_usersinroles_userid", userid, users)(_.id)
    def role = foreignKey("auth_usersinroles_roleid", roleid, roles)(_.id)
  }
  val usersInRoles = TableQuery[UserInRoleComponent]

  // Main trait for data binding. DAL is implemented as a trait to allow for mix-ins
/*
  trait DAL {
  val languages = TableQuery[LanguageComponent]
  val entities = TableQuery[EntityComponent]
  val users = TableQuery[UserComponent]
  val roles = TableQuery[RoleComponent]
  val usersInRoles = TableQuery[UserInRoleComponent]
}
*/
}

object current {
  // Parameter PAGE_SIZE defines the default number of records retrieved in a page
  val PAGE_SIZE = 10
  // Introducing DAL to the current application context
  val dal = new DAL
}
