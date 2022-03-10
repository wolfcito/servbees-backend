package com.ceiba.servicio_proporcionado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosDisponibles;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoServiciosDisponibles implements RowMapper<DtoServiciosDisponibles>, MapperResult {

    @Override
    public DtoServiciosDisponibles mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idReserva = resultSet.getLong(1);
        Long idUsuarioProveedor = resultSet.getLong(2);
        String nombreUsuario = resultSet.getString(3);
        Double costoHora = resultSet.getDouble(4);
        Double costoDia = resultSet.getDouble(5);
        Double costoSemana = resultSet.getDouble(6);
        String nombreCategoria = resultSet.getString(7);
        Long idCategoria = resultSet.getLong(8);


        return new DtoServiciosDisponibles(idReserva,
                idUsuarioProveedor,
                nombreUsuario,
                costoHora,
                costoDia,
                costoSemana,
                nombreCategoria,
                idCategoria);
    }

}
