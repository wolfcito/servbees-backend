--select id, id_categoria, id_usuario_pro, id_usuario_cli, modalidad, cantidad, costo, nivel_satisfacion, estado, fecha from servicio_proporcionado
SELECT sp.id, sp.id_usuario_pro, sp.id_usuario_cli,
        u.nombre, c.nombre, sp.costo, sp.cantidad,
FROM servicio_proporcionado sp, usuario u, categoria c
WHERE u.id = sp.id_usuario_pro
AND c.id = sp.id_categoria
AND sp.estado = 'R'
AND sp.id_usuario_cli = :id
