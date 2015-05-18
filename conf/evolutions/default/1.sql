# --- First database schema

# --- !Ups
create table game(
	ID int,
	nome varchar(100),
	finalizado varchar(20),
	descricao varchar(300),
	nota varchar(10),
	genero varchar(50)
);


insert into game(id, nome, finalizado, descricao, nota, genero) values (10,'Pelo DB','DB','DB','DB','DB');
insert into game(id, nome, finalizado, descricao, nota, genero) values (11,'Pelo DB2','DB2','DB2','DB2','DB2');

# --- !Downs

drop table if exists bar;

drop table if exists game;

