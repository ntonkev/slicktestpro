package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.Play.current

import play.api.db.slick._
import scala.slick.driver.PostgresDriver.simple._

import models.current.dao._
import models.current.dao.profile.simple._

object Application extends Controller{

  def index = DBAction { implicit rs =>
    Ok(views.html.index(Languages.length.toString()))
  }

}