package com.ceiba.categoria.adaptador.dao;

import com.ceiba.categoria.modelo.dto.DtoCategoria;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCategoria implements RowMapper<DtoCategoria>, MapperResult {

    @Override
    public DtoCategoria mapRow(ResultSet resultSet, int rowNum) throws SQLException {

//        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String codigo = resultSet.getString("codigo");
        Double costoHora = resultSet.getDouble("costo_hora");
        Double costoDia = resultSet.getDouble("costo_dia");
        Double costoSemana = resultSet.getDouble("costo_semana");

        return new DtoCategoria(nombre,codigo, costoHora, costoDia, costoSemana);
    }

}
