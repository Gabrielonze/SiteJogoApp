package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Game(id: Int, nome: String, descricao: String, nota: Float, genero: String)

object Game {

  val simple = {
    get[Int]("id") ~
    get[String]("nome") ~
    get[String]("descricao") ~
    get[Float]("nota") ~
    get[String]("genero") map {
      case id~nome~descricao~nota~genero => Game(id, nome, descricao, nota, genero)
    }
  }

  def findAll(): Seq[Game] = {
    DB.withConnection { implicit connection =>
      SQL("select * from game").as(Game.simple *)
    }
  }

  def create(game: Game): Unit = {
    DB.withConnection { implicit connection =>
      SQL("insert into game(nome, descricao, nota, genero) values ({nome}, {descricao}, {nota}, {genero})").on(
        'nome -> game.nome,
        'descricao -> game.descricao,
        'nota -> game.nota,
        'genero -> game.genero,
      ).executeUpdate()
    }
  }

}