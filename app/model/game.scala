import anorm._

DB.withConnection { implicit c =>
  val result: Boolean = SQL("Select 1").execute()    
} 

case class Game(id: Int, nome: String, descricao: String, nota: Float, genero: String)

object game{
	
	/*def findAll: List[Game]{

	}*/
	
	val result: Int = SQL("create table oi(id int)").execute()
}