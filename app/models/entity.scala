package models

import play.api.db.slick.Config.driver.simple._

/**
 * Created by AMoroz on 16/02/14.
 */
/*
case class Entity(id: Int, name: String, description: Option[String])

class EntityComponent(tag: Tag) extends Table[Entity](tag,Some("dict"),"entity") {
  def id = column[Int]("entityid",O.PrimaryKey)
  def name = column[String]("name",O.NotNull)
  def description = column[Option[String]]("description",O.Nullable)

  def * = (id, name, description) <> (Entity.tupled, Entity.unapply _)
}
*/
object Entities extends DAL {
  // CRUD operations
  def insert(entity: Entity)(implicit s: Session) {
    entities.insert(entity)
  }

  def update(id: Int, entity: Entity)(implicit s: Session) {
    entities.where(_.id === id).update(entity)
  }

  def delete(id: Int)(implicit s: Session) {
    entities.where(_.id === id).delete
  }

  // SEARCH operations
  def findById (id: Int)(implicit s: Session): Option[Entity] =
    entities.where(_.id === id).firstOption

  def findByName (name: String)(implicit s: Session): Option[Entity] =
    entities.where(_.name === name).firstOption

  // COUNT operations
  def count(implicit s: Session): Int =
    Query(entities.length).first

  def count(filter: String)(implicit s: Session): Int =
    Query(entities.where(_.name.toLowerCase like filter.toLowerCase).length).first

  // PAGING operation
  def list(page: Int = 0, pageSize: Int = current.PAGE_SIZE, orderBy: Int = 1, filter: String = "%")
    (implicit s: Session): Page[(Any, Any, Any)] = {

    val offset: Int = pageSize * page

    val result = (for (e <- entities) yield e).drop(offset).take(pageSize).list.map(row => (row.id,row.name,row.description))

    val totalRows = count(filter)

    Page(result, page, offset, totalRows)
  }
}