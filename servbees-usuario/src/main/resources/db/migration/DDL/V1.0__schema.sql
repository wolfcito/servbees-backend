create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null unique,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 meses_experiencia int not null,
 primary key (id)
);

create table categoria (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 codigo varchar(5) not null,
 costo_hora number(9,2) not null,
 costo_dia number(9,2) not null,
 costo_semana number(9,2) not null,
 primary key (id)
);

-- DATA USUARIO
insert into usuario(id, nombre,clave,fecha_creacion,meses_experiencia) values(1,'test0','1234',now(),0);
insert into usuario(id, nombre,clave,fecha_creacion,meses_experiencia) values(2,'test1','1234',now(),1);
insert into usuario(id, nombre,clave,fecha_creacion,meses_experiencia) values(3,'test2','1234',now(),2);
insert into usuario(id, nombre,clave,fecha_creacion,meses_experiencia) values(4,'test3','1234',now(),3);

-- DATA CATEGORIA
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(1,'Modelado 3D','md3d',30,230,1100);
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(2,'Marketing Digital','mdg',15,150,900);
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(3,'Ilustración','ils',60,330,1500);
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(4,'Social Media','sme',45,280,1300);
