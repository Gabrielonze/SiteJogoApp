create table jogos(
	ID int identity primary key,
	nome varchar(100),
	descricao varchar(MAX),
	nota smallint,
	genero varchar(50)
)