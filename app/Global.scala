/**
 * Created by AMoroz on 13/02/14.
 */

import play.api.GlobalSettings
import scala.slick.driver.PostgresDriver.simple._
import play.api.Application
import play.api.db._
import play.api.db.DB
import play.api.Play.current

import models.current.dao._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    lazy val database = Database.forDataSource(DB.getDataSource())

    val query = for (l <- Languages) yield l.name

    val result = database.withSession {
      session =>
        query.list()( session )
    }

  }

}