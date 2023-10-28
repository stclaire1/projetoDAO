create database cidadaos;
use cidadaos;

create table info(
	id int auto_increment primary key,
	nome varchar(200),
    email varchar(200),
    celular varchar(200)    
);

insert into info (id, nome, email, celular) 
values (null, 'Ana Clara', 'anaclara.custodio@estudante.iftm.edu.br', '99999-9999')
       (null, 'Carlos Eduardo', 'carlos@iftm.com', '99999-9999');