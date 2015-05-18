package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Game(id: Int, nome: String, finalizado: String, descricao: String, nota: String, genero: String)

object Game {

  val simple = {
    get[Int]("id") ~
    get[String]("nome") ~
    get[String]("finalizado") ~
    get[String]("descricao") ~
    get[String]("nota") ~
    get[String]("genero") map {
    case id~nome~finalizado~descricao~nota~genero => Game(id,nome,finalizado,descricao,nota,genero)
    }
  }

  def findAll(): Seq[Game] = {
    DB.withConnection { implicit connection =>
      SQL("select * from game").as(Game.simple *)
    }
  }

  val getObjects = SQL("Select * from game")

  val gameList = getObjects.map(row =>
    List(
      row[Int]("id"),
      row[String]("nome"),
      row[String]("finalizado"),
      row[String]("descricao"),
      row[String]("nota"),
      row[String]("genero")
    )
  )

  def create(game: Game): Unit = {
    DB.withConnection { implicit connection =>
      SQL("insert into game(id, nome,finalizado,descricao,nota,genero) values (10, {nome}, {finalizado}, {descricao}, {nota}, {genero})").on(
        'nome -> game.nome,
        'finalizado -> game.finalizado,
        'descricao -> game.descricao,
        'nota -> game.nota,
        'genero -> game.genero
      ).executeUpdate()
    }
  }

}