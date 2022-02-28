create table categoria (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 codigo varchar(5) not null,
 costo_hora decimal(10,2) not null,
 costo_dia decimal(10,2) not null,
 costo_semana decimal(10,2) not null,
 primary key (id)
);

-- DATA TEST
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(1,'Modelado 3D','Md3D',30,230,1100);
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(2,'Marketing Digital','Mdg',15,150,900);
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(3,'Ilustración','Ils',60,330,1500);
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(4,'Social Media','SMe',45,280,1300);
