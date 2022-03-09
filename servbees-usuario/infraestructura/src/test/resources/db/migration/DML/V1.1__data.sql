--truncate table usuario;
--truncate table categoria;
--truncate table servicio_proporcionado;
insert into usuario(id, nombre,clave,fecha_creacion, meses_experiencia) values(1,'test','1234',now(),0);
--
insert into categoria( id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(1,'Categoria test','CAT',30,230,1100);

--insert into servicio_proporcionado(id_categoria, id_usuario_cli, id_usuario_pro, nivel_satisfacion, modalidad, estado, costo, fecha) values( 1, 2, 1, 'sup', 'ph', 1, 100, now());
insert into servicio_proporcionado(id_categoria, id_usuario_pro) values( 1, 1);