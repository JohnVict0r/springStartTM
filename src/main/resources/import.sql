insert into tipo_evento(nome,cbtm,peso)values ("Estadual", true,1); 
insert into tipo_evento(nome,cbtm,peso)values ("Interestadual", true,2);
insert into tipo_evento(nome,cbtm,peso)values ("Escolar", true,0);
insert into tipo_evento(nome,cbtm,peso)values ("Copa Brasil", false,6);
insert into tipo_evento(nome,cbtm,peso)values ("Brasileiro", false,8);

insert into evento(titulo,status,id_tipo_evento)values ("1º estadual 2018", "FINALIZADO",1); 
insert into evento(titulo,status,id_tipo_evento)values ("2º estadual 2018", "ABERTO",1); 
insert into evento(titulo,status,id_tipo_evento) values ("3º estadual 2018", "ABERTO",1);        
