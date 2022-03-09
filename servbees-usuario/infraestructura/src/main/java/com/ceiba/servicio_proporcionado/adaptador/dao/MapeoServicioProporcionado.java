package com.ceiba.servicio_proporcionado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoServicioProporcionado implements RowMapper<DtoServicioProporcionado>, MapperResult {

    @Override
    public DtoServicioProporcionado mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        String nombreUsuario = resultSet.getString(1);
        Integer experiencia = resultSet.getInt(2);
        String nombreCategoria = resultSet.getString(3);
        String nivelSatisfacion = resultSet.getString(4);
        String modalidad = resultSet.getString(5);

        return new DtoServicioProporcionado(nombreUsuario,experiencia,nombreCategoria, nivelSatisfacion, modalidad);
    }

}
