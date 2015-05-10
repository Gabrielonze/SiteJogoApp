import anorm._
import play.api.db.DB
import play.api.Play.current
 


case class Game(id: Int, nome: String, descricao: String, nota: Float, genero: String)
	
object game{
	
	/*def findAll: List[Game]{

	}*/



	DB.withConnection { implicit c =>;
		val result: Boolean = SQL("create table oi(id int)").execute()
	}
	
	
}