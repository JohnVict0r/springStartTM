insert into tipo_evento(nome,cbtm,peso)values ("Estadual", true,1); 
insert into tipo_evento(nome,cbtm,peso)values ("Copa das Federações", true,2);
insert into tipo_evento(nome,cbtm,peso)values ("Escolar", true,0);
insert into tipo_evento(nome,cbtm,peso)values ("Copa Brasil", false,6);
insert into tipo_evento(nome,cbtm,peso)values ("Brasileiro", false,8);

insert into evento(titulo,endereco,estado,cidade,data_Inicio,data_Fim,status,id_tipo_evento)values ("1º estadual 2018","endereco teste","RN","Natal",'2018-08-30','2018-08-30',"FINALIZADO",1);     
insert into evento(titulo,endereco,estado,cidade,data_Inicio,data_Fim,status,id_tipo_evento)values ("2º estadual 2018","endereco teste", "RN", "Natal", '2018-08-30' ,'2018-08-30', "ABERTO",1); 
insert into evento(titulo,endereco,estado,cidade,data_Inicio,data_Fim,status,id_tipo_evento)values ("3º estadual 2018","endereco teste", "RN", "Natal", '2018-08-30' ,'2018-08-30', "ABERTO",1);        
insert into evento(titulo,endereco,estado,cidade,data_Inicio,data_Fim,status,id_tipo_evento)values ("Brasileiro de verão 2018","endereco teste", "RN", "Natal", '2018-08-30' ,'2018-08-30', "FINALIZADO",4); 
insert into evento(titulo,endereco,estado,cidade,data_Inicio,data_Fim,status,id_tipo_evento)values ("Brasileiro de inverno 2018","endereco teste", "RN", "Natal", '2018-08-30' ,'2018-08-30', "ABERTO",4); 
insert into evento(titulo,endereco,estado,cidade,data_Inicio,data_Fim,status,id_tipo_evento)values ("Copa brasil - Nordeste - 2018","endereco teste", "RN", "Natal", '2018-08-30' ,'2018-08-30', "ABERTO",3);        

