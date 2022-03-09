update servicio_proporcionado
set nivel_satisfacion = :nivelSatisfacion,
    estado = :estado,
    fecha = :fecha
where id = :id

