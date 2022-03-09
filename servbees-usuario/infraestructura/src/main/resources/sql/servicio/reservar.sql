update servicio_proporcionado
set id_usuario_cli = :idUsuarioCli,
    modalidad = :modalidad,
    cantidad = :cantidad,
    costo = :costo,
    estado = :estado,
    fecha = :fecha
where id = :id
