package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current

import models.current.dal._

import scala.slick.driver.PostgresDriver.simple._
import play.api.db.DB

object Application extends Controller{

  def index = Action { implicit rs =>

    lazy val database = Database.forDataSource(DB.getDataSource())

    val query = for (l <- entities) yield l.name

    val result = database.withSession {
      session =>
        query.list()( session )
    }

    Ok(views.html.index("Reading first entity from database: " + result(0)))
  }

}