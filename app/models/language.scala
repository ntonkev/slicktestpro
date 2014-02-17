package models
/*
/**
 * Created by AMoroz on 14/02/14.
 */
import play.api.db.slick.Config.driver.simple._

case class Language(id: Int, name: String, description: Option[String], code: String)

class LanguageComponent(tag: Tag) extends Table[Language](tag,Some("dict"),"language") {
  def id = column[Int]("languageid",O.PrimaryKey)
  def name = column[String]("name",O.NotNull)
  def description = column[Option[String]]("description",O.Nullable)
  def code = column[String]("code",O.NotNull)

  def * = (id, name, description, code) <> (Language.tupled, Language.unapply _)
}
*/