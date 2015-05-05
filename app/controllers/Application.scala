package controllers

import play.api._
import play.api.mvc._

case class Game(nome: String, descricao: String, nota: Float, genero: String)

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def login = Action {
    Ok(views.html.login("Your new application is ready."))
  }

  def catalogo = Action {
    Ok(views.html.catalogo("Your new application is ready."))
  }

  def adicionar = Action {
    Ok(views.html.adicionar("Your new application is ready."))
  }

  def meusjogos = Action {
    Ok(views.html.meusjogos("Your new application is ready."))
  }

  def tes = Action {
    val contJogos = List(
      Game("Batman","Muito Bom",10,"Ação"),
      Game("NFS Most Wanted","Excelênte",10,"Corrida"),
      Game("Resident Evil 5","Loucooo",10,"Suspense"),
      Game("Batman","Muito Bom",10,"Ação"),
      Game("NFS Most Wanted","Excelênte",10,"Corrida"),
      Game("Resident Evil 5","Loucooo",10,"Suspense")
      )
    Ok(views.html.tes(contJogos))
  }

}