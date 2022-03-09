CREATE TABLE usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null unique,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 meses_experiencia int not null,
 PRIMARY KEY (id)
);

CREATE TABLE categoria (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 codigo varchar(5) not null,
 costo_hora number(9,2) not null,
 costo_dia number(9,2) not null,
 costo_semana number(9,2) not null,
 PRIMARY KEY (id)
);

CREATE TABLE servicio_proporcionado (
 id int(11) not null auto_increment,
 id_categoria int(11) not null,
 id_usuario_pro int(11) not null,
 id_usuario_cli int(11) null,
 modalidad varchar(2) null default('sa'), --CHECK(modalidad IN('ph', 'pd', 'ps','sa'))
 cantidad int null default(1),
 costo number(9,2) null,
 nivel_satisfacion varchar(3) null default('nor'), --CHECK(nivel_satisfacion IN('sup', 'inf', 'nor'))
 estado varchar(2) null default('D'), --CHECK(estado IN('d', 'r', 'c'))
 fecha datetime null default now(),
 PRIMARY KEY (id),
 FOREIGN KEY (id_categoria) REFERENCES categoria(id),
 FOREIGN KEY (id_usuario_cli) REFERENCES usuario(id),
 FOREIGN KEY (id_usuario_pro) REFERENCES usuario(id)
);
 -- ph: por hora, pd: por dia, ps: por semana, sa: sin asignar
  -- sup: superior, inf: inferior, nor: normal
 -- s: sin contrart, c: contrado, f: finalizado
-- CONSTRAINT fk_serv_categoria_id FOREIGN KEY (id_categoria) REFERENCES categoria(id),
-- CONSTRAINT fk_serv_cliente_id FOREIGN KEY (id_usuario_cli) REFERENCES usuario(id),
-- CONSTRAINT fk_serv_proveedor_id FOREIGN KEY (id_usuario_pro) REFERENCES usuario(id)

---- DATA USUARIO
insert into usuario(id, nombre,clave,fecha_creacion,meses_experiencia) values(1,'test0','1234',now(),0);
--insert into usuario(id, nombre,clave,fecha_creacion,meses_experiencia) values(2,'test1','1234',now(),1);
--insert into usuario(id, nombre,clave,fecha_creacion,meses_experiencia) values(3,'test2','1234',now(),12);
--insert into usuario(id, nombre,clave,fecha_creacion,meses_experiencia) values(4,'test3','1234',now(),15);
--
---- DATA CATEGORIA
insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(1,'Modelado 3D','md3d',30,230,1100);
--insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(2,'Marketing Digital','mdg',15,150,900);
--insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(3,'Ilustración','ils',60,330,1500);
--insert into categoria(id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(4,'Social Media','sme',45,280,1300);

-- DATA SERVICIO
--insert into servicio_proporcionado(id, id_categoria, id_usuario_cli, id_usuario_pro, nivel_satisfacion, modalidad, estado, costo, fecha) values(1, 1, 2, 1, 'sup', 'ph', 1, 100, now());
--insert into servicio_proporcionado(id, id_categoria, id_usuario_cli, id_usuario_pro, nivel_satisfacion, modalidad, estado, costo, fecha) values(2, 1, null, 1, 'sup', 'ph', 0, 100, now());
--insert into servicio_proporcionado(id, id_categoria, id_usuario_cli, id_usuario_pro, nivel_satisfacion, modalidad, estado, costo, fecha) values(3, 1, 2, 1, 'sup', 'ph', 1, 100, now());
