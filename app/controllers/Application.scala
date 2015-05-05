package controllers

import play.api._
import play.api.mvc._

case class Game(id: Int, nome: String, descricao: String, nota: Float, genero: String)

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
      Game(1,"Batman","Muito Bom",10,"Ação"),
      Game(2,"NFS Most Wanted","Excelênte",10,"Corrida"),
      Game(2,"Resident Evil 5","Loucooo",10,"Suspense"),
      Game(4,"Batman","Muito Bom",10,"Ação"),
      Game(5,"NFS Most Wanted","Excelênte",10,"Corrida"),
      Game(6,"Resident Evil 5","Loucooo",10,"Suspense"),
      Game(7,"Batman","Muito Bom",10,"Ação"),
      Game(8,"NFS Most Wanted","Excelênte",10,"Corrida"),
      Game(9,"Resident Evil 5","Loucooo",10,"Suspense"),
      Game(10,"Batman","Muito Bom",10,"Ação"),
      Game(11,"NFS Most Wanted","Excelênte",10,"Corrida"),
      Game(12,"Resident Evil 5","Loucooo",10,"Suspense")
      )
    Ok(views.html.tes(contJogos))
  }

}