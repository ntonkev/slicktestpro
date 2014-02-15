package models

/**
 * Created by AMoroz on 14/02/14.
 */

import play.api.db.slick.Profile

case class Language(id: Int, name: String, description: String, code: String)

trait LanguageComponent { this: Profile =>
  import profile.simple._

  class Languages(tag: Tag) extends Table[Language](tag,"dict.Language") {
    def id = column[Int]("languageid",O.PrimaryKey)
    def name = column[String]("name",O.NotNull)
    def description = column[String]("description",O.Nullable)
    def code = column[String]("code",O.NotNull)

    def * = (id, name, description, code) <> (Language.tupled, Language.unapply _)
  }

}