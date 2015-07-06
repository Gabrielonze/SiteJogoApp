package controllers

import play.api.data.Forms._
import play.api.data.Form
import play.api.data.Forms.{single, nonEmptyText}
import play.api.mvc.{Action, Controller}

import models.Game
import models.GameDB
import play.api.libs.json.Json


object Application extends Controller {


  val gameForm = Form(mapping(
    "nome" -> nonEmptyText,
    "descricao" -> text,
    "finalizado" -> text,
    "nota" -> text,
    "genero" -> text)(Game.apply)(Game.unapply))

  def create() = Action { implicit request =>
    gameForm.bindFromRequest.fold(
      formWithErrors => Ok("Não OK"),
      value => Game.create(value)
    )
    Redirect(routes.Application.meusjogos)
  }

//I) Aparece todo o DB
  implicit val gameWrites = Json.writes[GameDB]
  def getGames() = Action {
    val games = Game.getAll
    Ok(Json.toJson(games))
  }
//F) Aparece todo o DB

  def delGame(id:Int) = Action{
    val dGame = Game.delGame(id)
    Ok(views.html.login("Your new application is ready."))
  }

  def modGame(id:Int) = Action{
    val dGame = Game.modGameGet(id)
    Ok(views.html.login("Your new application is ready."))
  }

  def modGameEdit(id:Int) = Action{
    val dGame = Game.modGameUpdate(id)
    Ok(views.html.editor(dGame))
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
    var gameBanco = Game.getAll
    Ok(views.html.meusjogos(gameBanco))
  }

  def adicionar = Action {
    Ok(views.html.adicionar("Your new application is ready."))
  }


  def tes = Action {
    Ok(views.html.tes("Your new application is ready."))
  }

}