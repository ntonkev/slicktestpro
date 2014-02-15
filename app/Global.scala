/**
 * Created by AMoroz on 13/02/14.
 */

import play.api.GlobalSettings
import scala.slick.driver.PostgresDriver.simple._
import play.api.Application
import play.api.db._
import play.api.db.DB
import play.api.Play.current

import models.{Language, DAO}

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    lazy val database = Database.forDataSource(DB.getDataSource())
  }

}