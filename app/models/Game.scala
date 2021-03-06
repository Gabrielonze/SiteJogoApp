package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SQL
import anorm.SqlParser._

case class Game(nome: String, finalizado: String, descricao: String, nota: String, genero: String)
case class GameDB(id: Int, nome: String, finalizado: String, descricao: String, nota: String, genero: String)


object Game {

  val sql: SqlQuery = SQL("select * from game")


  val simple = {
    get[String]("nome") ~
    get[String]("finalizado") ~
    get[String]("descricao") ~
    get[String]("nota") ~
    get[String]("genero") map {
    case nome~finalizado~descricao~nota~genero => Game(nome,finalizado,descricao,nota,genero)
    }
  }

  val simpleDB = {
    get[Int]("id") ~
    get[String]("nome") ~
    get[String]("finalizado") ~
    get[String]("descricao") ~
    get[String]("nota") ~
    get[String]("genero") map {
    case id~nome~finalizado~descricao~nota~genero => GameDB(id,nome,finalizado,descricao,nota,genero)
    }
  }

  def getAll: List[GameDB] = DB.withConnection {

    implicit connection =>
      sql().map(row =>
        GameDB(row[Int]("id"), row[String]("nome"), row[String]("finalizado"), row[String]("descricao"), row[String]("nota"), row[String]("genero"))
      ).toList
  }

  def create(game: Game): Unit = {
    DB.withConnection { implicit connection =>
      SQL("insert into game(nome,finalizado,descricao,nota,genero) values ({nome}, {finalizado}, {descricao}, {nota}, {genero})").on(
        'nome -> game.nome,
        'finalizado -> game.finalizado,
        'descricao -> game.descricao,
        'nota -> game.nota,
        'genero -> game.genero
      ).execute()
    }
  }

  def delGame(id_pego:Int){
    DB.withConnection { implicit connection =>
    val delObjs = SQL("DELETE FROM game WHERE id = {id}; ").on('id -> id_pego).executeUpdate()
    }
  }

  def modGameGet(id_pego:Int): Option[GameDB] = {
    DB.withConnection { implicit connection =>
    val modObj = SQL("SELECT * FROM game WHERE id = {id};")
    modObj.on('id -> id_pego).as(simpleDB.singleOpt)
    }
  }

  def modGameUpdate(game: GameDB): Unit = {
    DB.withConnection { implicit connection =>
    val modObjUp = SQL("UPDATE game set nome = {nome}, finalizado = {finalizado}, descricao = {descricao}, nota ={nota}, genero = {genero} WHERE id = {id}").on(
        'nome -> game.nome,
        'finalizado -> game.finalizado,
        'descricao -> game.descricao,
        'nota -> game.nota,
        'genero -> game.genero,
        'id -> game.id
      ).executeUpdate()
    }
  }









  def findAll(): Seq[GameDB] = {
    DB.withConnection { implicit connection =>
      SQL("select * from game").as(Game.simpleDB *)
    }
  }

  def gameList() = {
    DB.withConnection { implicit connection =>
    val listObjs = SQL("Select * from game").as(Game.simple *)
    }
  }

  
  



}