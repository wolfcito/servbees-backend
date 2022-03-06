package com.ceiba.categoria.adaptador.dao;

import com.ceiba.categoria.modelo.dto.DtoCategoria;
import com.ceiba.categoria.puerto.dao.DaoCategoria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCategoriaMysql implements DaoCategoria {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="categoria", value="listar")
    private static String sqlListar;

    public DaoCategoriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCategoria> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCategoria());
    }
}
