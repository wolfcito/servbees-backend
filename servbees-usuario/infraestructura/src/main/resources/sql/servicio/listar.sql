--select id, id_categoria, id_usuario_pro, id_usuario_cli, modalidad, cantidad, costo, nivel_satisfacion, estado, fecha from servicio_proporcionado
SELECT  u.nombre as nombre_usuario, u.meses_experiencia as experiencia,
        c.nombre as nombre_categoria,
        sp.nivel_satisfacion as nivel_satisfacion, sp.modalidad as modalidad
FROM servicio_proporcionado sp, usuario u, usuario c
WHERE u.id = sp.id_usuario_pro
AND c.id = sp.id_categoria
AND sp.estado = 'C'
AND u.meses_experiencia >=12
ORDER BY sp.fecha DESC
LIMIT 3