package controllers

import play.api._
import play.api.mvc._


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
    
    Ok(views.html.meusjogos(contJogos))
  }

  def tes = Action {
    
    Ok(views.html.tes("Your new application is ready."))
  }

}