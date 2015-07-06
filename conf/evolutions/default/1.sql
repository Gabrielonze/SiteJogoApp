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


insert into game(id, nome, finalizado, descricao, nota, genero) values (1,'Pelo DB','DB','DB','DB','DB');
insert into game(id, nome, finalizado, descricao, nota, genero) values (2,'Pelo DB2','DB2','DB2','DB2','DB2');
insert into game(id, nome, finalizado, descricao, nota, genero) values (3,'Funcionou','DB3','DB3','DB3','DB3');
insert into game(id, nome, finalizado, descricao, nota, genero) values (4,'Funcionou','DB3','DB3','DB3','DB3');
insert into game(id, nome, finalizado, descricao, nota, genero) values (5,'Funcionou','DB3','DB3','DB3','DB3');
insert into game(id, nome, finalizado, descricao, nota, genero) values (6,'Funcionou','DB3','DB3','DB3','DB3');
insert into game(id, nome, finalizado, descricao, nota, genero) values (7,'Funcionou','DB3','DB3','DB3','DB3');
insert into game(id, nome, finalizado, descricao, nota, genero) values (8,'Funcionou','DB3','DB3','DB3','DB3');
insert into game(id, nome, finalizado, descricao, nota, genero) values (9,'Funcionou','DB3','DB3','DB3','DB3');

# --- !Downs

drop table if exists bar;

drop table if exists game;

