create database starttm;
use starttm;

create table eventos(
id_evento int auto_increment NOT NULL PRIMARY KEY,
nome varchar(100),
cidade varchar(50),
data_inicio datetime not null, 
data_fim datetime not null

);

insert into eventos(titulo,status)values ("1º estadual 2018", "FINALIZADO"); 
insert into eventos(titulo,status)values ("2º estadual 2018", "ABERTO"); 
insert into eventos(titulo,status) values ("3º estadual 2018", "ABERTO");        

select codigo, titulo, status from eventos;

show tables;