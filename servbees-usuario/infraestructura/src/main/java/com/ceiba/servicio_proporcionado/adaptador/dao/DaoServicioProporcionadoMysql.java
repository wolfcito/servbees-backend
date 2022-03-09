package com.ceiba.servicio_proporcionado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;
import com.ceiba.servicio_proporcionado.puerto.dao.DaoServicioProporcionado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoServicioProporcionadoMysql implements DaoServicioProporcionado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="servicio", value="listar")
    private static String sqlListar;

    public DaoServicioProporcionadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoServicioProporcionado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoServicioProporcionado());
    }
}
