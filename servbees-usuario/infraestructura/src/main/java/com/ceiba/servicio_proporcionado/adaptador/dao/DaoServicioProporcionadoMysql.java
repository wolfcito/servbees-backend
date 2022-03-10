package com.ceiba.servicio_proporcionado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosDisponibles;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosReservados;
import com.ceiba.servicio_proporcionado.puerto.dao.DaoServicioProporcionado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoServicioProporcionadoMysql implements DaoServicioProporcionado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="servicio", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="servicio", value="listarDisponibles")
    private static String sqlListarDisponibles;

    @SqlStatement(namespace="servicio", value="listarMisReservados")
    private static String sqllistarMisReservados;

    public DaoServicioProporcionadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoServicioProporcionado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoServicioProporcionado());
    }

    @Override
    public List<DtoServiciosDisponibles> listarTodosDisponibles() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarDisponibles, new MapeoServiciosDisponibles());
    }

    @Override
    public List<DtoServiciosReservados> listarTodosReservados(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqllistarMisReservados, paramSource, new MapeoServiciosReservados());
    }

}
