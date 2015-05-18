package controllers

import play.api.data.Forms._
import play.api.data.Form
import play.api.data.Forms.{single, nonEmptyText}
import play.api.mvc.{Action, Controller}

import models.Game
import play.api.libs.json.Json


object Application extends Controller {

  implicit val gameWrites = Json.writes[Game]

  val gameForm = Form(
    mapping(
      "num" -> number,
      "nome" -> text,
      "finalizado" -> text,
      "descricao" -> text,
      "nota" -> text,
      "genero" -> text
    )(Game.apply)(Game.unapply)
  )

  def addGame() = Action { implicit request =>
    gameForm.bindFromRequest.fold(
    formWithErrors => {
      BadRequest(views.html.login("ERRO"))
    },
    contact => {
      val gameId = Game.create(Game(15, "nome","finalizado","descricao","nota","genero"))
      Redirect(routes.Application.index())
    }
  )
  }

  def getGames() = Action {
    val games = Game.findAll()
    Ok(Json.toJson(games))
  }

  def delGame(id:Int) = Action{
    val dGame = Game.delGame(id)
    Ok(views.html.login("Your new application is ready."))
  }

  def modGame(id:Int) = Action{
    val dGame = Game.modGame(id)
    Ok(views.html.login("Your new application is ready."))
  }

  def index = Action {
    Ok(views.html.index(gameForm))
  }

  def login = Action {
    Ok(views.html.login("Your new application is ready."))
  }

  def catalogo = Action {
    var gameBanco = Game.gameList
    Ok(views.html.catalogo(gameBanco))
  }

  def meusjogos = Action {
    var gameBanco = Game.gameList
    Ok(views.html.meusjogos("Your new application is ready."))
  }

  def adicionar = Action {
    Ok(views.html.adicionar("Your new application is ready."))
  }


  def tes = Action {
    Ok(views.html.tes("Your new application is ready."))
  }

}