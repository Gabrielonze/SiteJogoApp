# --- First database schema

# --- !Ups
create table game(
	ID int primary key,
	nome varchar(100),
	finalizado varchar(20),
	descricao varchar(300),
	nota varchar(10),
	genero varchar(50)
);

# --- !Downs

drop table if exists bar;

drop table if exists game;
