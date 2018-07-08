create database starttm;
use starttm;

insert into tipo_evento(nome,cbtm,peso)values ("Estadual", true,1); 
insert into tipo_evento(nome,cbtm,peso)values ("Interestadual", true,2);
insert into tipo_evento(nome,cbtm,peso)values ("Escolar", true,0);
insert into tipo_evento(nome,cbtm,peso)values ("Copa Brasil", false,6);
insert into tipo_evento(nome,cbtm,peso)values ("Brasileiro", false,8);

insert into evento(titulo,status,id_tipo_evento)values ("1º estadual 2018", "FINALIZADO",1); 
insert into evento(titulo,status,id_tipo_evento)values ("2º estadual 2018", "ABERTO",1); 
insert into evento(titulo,status,id_tipo_evento) values ("3º estadual 2018", "ABERTO",1);        

insert into evento(titulo,status,id_tipo_evento)values ("Brasileiro de verão 2018", "FINALIZADO",4); 
insert into evento(titulo,status,id_tipo_evento)values ("Brasileiro de inverno 2018", "ABERTO",4); 
insert into evento(titulo,status,id_tipo_evento) values ("Copa brasil - Nordeste - 2018", "ABERTO",3);        



select e.id_evento, e.titulo, e.status, te.nome, te.peso from evento as e
inner join tipo_evento as te using (id_tipo_evento)
order by e.status;

show tables;