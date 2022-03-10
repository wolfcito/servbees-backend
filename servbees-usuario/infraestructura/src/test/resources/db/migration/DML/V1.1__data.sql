insert into usuario(id, nombre,clave,fecha_creacion, meses_experiencia) values(1,'test','1234',now(),12);
insert into usuario(id, nombre,clave,fecha_creacion, meses_experiencia) values(2,'test2','1234',now(),12);

insert into categoria( id, nombre, codigo,costo_hora,costo_dia,costo_semana) values(1,'Categoria test','CAT',30,230,1100);

insert into servicio_proporcionado(id,id_categoria, id_usuario_pro, id_usuario_cli, modalidad, cantidad, costo, nivel_satisfacion, estado) values(1, 1, 1,1, 'PH', 1, 100, 'SUP','C' );
insert into servicio_proporcionado(id,id_categoria, id_usuario_pro, id_usuario_cli, modalidad, cantidad, costo, nivel_satisfacion, estado) values(2, 1, 1,1, 'PH', 1, 100, 'NOR','R' );
insert into servicio_proporcionado(id,id_categoria, id_usuario_pro, id_usuario_cli,modalidad, cantidad, nivel_satisfacion, estado) values(3, 1, 1, 1,'SA', 1, 'NOR','D' );


