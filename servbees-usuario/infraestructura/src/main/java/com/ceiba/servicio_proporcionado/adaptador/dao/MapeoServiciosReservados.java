package com.ceiba.servicio_proporcionado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosReservados;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoServiciosReservados implements RowMapper<DtoServiciosReservados>, MapperResult {

    @Override
    public DtoServiciosReservados mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idReserva = resultSet.getLong(1);
        Long idUsuarioProveedor = resultSet.getLong(2);
        Long idUsuarioCliente = resultSet.getLong(3);
        String nombreUsuario = resultSet.getString(4);
        String nombreCategoria = resultSet.getString(5);
        Double costo = resultSet.getDouble(6);
        Integer cantidad = resultSet.getInt(7);

        return new DtoServiciosReservados(idReserva,
                idUsuarioProveedor,
                idUsuarioCliente,
                nombreUsuario,
                nombreCategoria,
                costo,
                cantidad);
    }

}
