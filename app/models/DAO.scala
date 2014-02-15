package models

/**
 * Created by AMoroz on 14/02/14.
 */

import scala.slick.driver.JdbcProfile
import scala.slick.lifted.TableQuery
import play.api.db.slick.Profile
import play.api.db.slick.DB

class DAO(override val profile: JdbcProfile) extends LanguageComponent with Profile{
  val Languages = TableQuery[Languages]
}

object current {
  val dao = new DAO(DB(play.api.Play.current).driver)
}