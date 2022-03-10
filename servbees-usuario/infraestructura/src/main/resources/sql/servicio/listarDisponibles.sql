--select id, id_categoria, id_usuario_pro, id_usuario_cli, modalidad, cantidad, costo, nivel_satisfacion, estado, fecha from servicio_proporcionado
SELECT sp.id, sp.id_usuario_pro,
        u.nombre, c.costo_hora,c.costo_dia,c.costo_semana ,c.nombre, c.id
FROM servicio_proporcionado sp, usuario u, categoria c
WHERE u.id = sp.id_usuario_pro
AND c.id = sp.id_categoria
AND sp.estado = 'D'
AND u.meses_experiencia >=12
