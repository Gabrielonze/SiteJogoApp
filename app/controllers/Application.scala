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
      "0" -> number,
      "nome" -> text,
      "finalizado" -> text,
      "descricao" -> text,
      "nota" -> number,
      "genero" -> text
    )(Game.apply)(Game.unapply)
  )

  def addBar() = Action { implicit request =>
    gameForm.bindFromRequest.value map {nome;finalizado;descricao;nota;genero =>
      Game.create(Game(0, nome,finalizado,descricao,nota,genero))
      Redirect(routes.Application.index())
    } getOrElse BadRequest
  }

  def getBars() = Action {
    val bars = Game.findAll()
    Ok(Json.toJson(games))
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def login = Action {
    Ok(views.html.login("Your new application is ready."))
  }

  def catalogo = Action {
    Ok(views.html.catalogo("Your new application is ready."))
  }

  def meusjogos = Action {
    Ok(views.html.meusjogos(gameForm))
  }

  def adicionar = Action {
    Ok(views.html.adicionar("Your new application is ready."))
  }


  def tes = Action {
    Ok(views.html.tes("Your new application is ready."))
  }

}