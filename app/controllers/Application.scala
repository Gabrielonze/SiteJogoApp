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
      Game(0,"Batman","Muito Bom",10,"Ação"),
      Game(1,"NFS Most Wanted","Excelênte",10,"Corrida"),
      Game(2,"Resident Evil 5","Loucooo",10,"Suspense"),
      Game(3,"Batman","Muito Bom",10,"Ação"),
      Game(4,"NFS Most Wanted","Excelênte",10,"Corrida"),
      Game(5,"Resident Evil 5","Loucooo",10,"Suspense"),
      Game(6,"Batman","Muito Bom",10,"Ação"),
      Game(7,"NFS Most Wanted","Excelênte",10,"Corrida"),
      Game(8,"Resident Evil 5","Loucooo",10,"Suspense"),
      Game(9,"Batman","Muito Bom",10,"Ação"),
      Game(10,"NFS Most Wanted","Excelênte",10,"Corrida"),
      Game(11,"Resident Evil 5","Loucooo",10,"Suspense")
      )
    Ok(views.html.tes(contJogos))
  }

}