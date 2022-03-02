update usuario
set nombre = :nombre,
	clave = :clave,
	fecha_creacion = :fechaCreacion,
    meses_experiencia = :mesesExperiencia
where id = :id