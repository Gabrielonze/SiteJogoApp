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

  def gameList() = {
    DB.withConnection { implicit connection =>
    val listObjs = SQL("Select * from game").as(Game.simple *)
    }
  }

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

  def delGame(id_pego:Int){
    DB.withConnection { implicit connection =>
    val delObjs = SQL("DELETE FROM game WHERE id = {id}; ").on('id -> id_pego).executeUpdate()
    }
  }

  def modGameGet(id_pego:Int){
    DB.withConnection { implicit connection =>
    val modObj = SQL("SELECT * FROM game WHERE id = {id}; ").on('id -> id_pego).execute()
    
    /*val modList = modObj.map(row =>
        List(
          row[Int]("id"),
          row[String]("nome"),
          row[String]("finalizado"),
          row[String]("descricao"),
          row[String]("nota"),
          row[String]("genero")
        )
      )
*/
    }
  }

  def modGameUpdate(id_pego:Int){
    DB.withConnection { implicit connection =>
    val modObjUp = SQL("UPDATE game set nome = {nome}, finalizado = {finalizado}, descricao = {descricao}, nota ={nota}, genero = {genero} WHERE id = {id}").on(
        'nome -> game.nome,
        'finalizado -> game.finalizado,
        'descricao -> game.descricao,
        'nota -> game.nota,
        'genero -> game.genero,
        'id -> id_pego
      ).executeUpdate()
    }
  }}