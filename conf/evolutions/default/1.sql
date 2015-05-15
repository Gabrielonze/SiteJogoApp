# --- First database schema

# --- !Ups

create table bar (
  id                        SERIAL PRIMARY KEY,
  name                      varchar(255) not null
);

create table jogos(
	ID int identity primary key,
	nome varchar(100),
	finalizado varchar(20),
	descricao varchar(MAX),
	nota smallint,
	genero varchar(50)
);

# --- !Downs

drop table if exists bar;

drop table if exists jogos;
