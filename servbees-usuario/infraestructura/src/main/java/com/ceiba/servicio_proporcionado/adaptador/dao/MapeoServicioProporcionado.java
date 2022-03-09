package com.ceiba.servicio_proporcionado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoServicioProporcionado implements RowMapper<DtoServicioProporcionado>, MapperResult {

    @Override
    public DtoServicioProporcionado mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idCategoria = resultSet.getLong("id_categoria");
        Long idUsuarioPro = resultSet.getLong("id_usuario_pro");
        Long idUsuarioCli = resultSet.getLong("id_usuario_cli");
        String modalidad = resultSet.getString("modalidad");
        Integer cantidad = resultSet.getInt("cantidad");
        Double costo = resultSet.getDouble("costo");
        String nivelSatisfacion = resultSet.getString("nivel_satisfacion");
        String estado = resultSet.getString("estado");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha");

        return new DtoServicioProporcionado(idCategoria,idUsuarioPro,idUsuarioCli, modalidad, cantidad, costo, nivelSatisfacion, estado, fecha);
    }

}
