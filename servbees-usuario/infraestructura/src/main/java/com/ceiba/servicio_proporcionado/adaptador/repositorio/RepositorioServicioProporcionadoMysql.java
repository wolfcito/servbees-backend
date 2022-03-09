package com.ceiba.servicio_proporcionado.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.puerto.repositorio.RepositorioServicioProporcionado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioServicioProporcionadoMysql implements RepositorioServicioProporcionado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "servicio", value = "registrar")
    private static String sqlRegistrar;

    @SqlStatement(namespace = "servicio", value = "reservar")
    private static String sqlReservar;

    @SqlStatement(namespace = "servicio", value = "calificar")
    private static String sqlCalificar;

    @SqlStatement(namespace = "servicio", value = "existePorId")
    private static String sqlExistePorId;

    public RepositorioServicioProporcionadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long registrar(ServicioProporcionado servicioProporcionado) {
        return this.customNamedParameterJdbcTemplate.crear(servicioProporcionado, sqlRegistrar);
    }

    @Override
    public void reservar(ServicioProporcionado servicioProporcionado) {

        this.customNamedParameterJdbcTemplate.actualizar(servicioProporcionado, sqlReservar);
//        MapSqlParameterSource paramSource = new MapSqlParameterSource();
//        paramSource.addValue("id", servicioProporcionado.getId());
//        paramSource.addValue("idUsuarioCli", servicioProporcionado.getIdUsuarioCli());
//        paramSource.addValue("modalidad", servicioProporcionado.getModalidad());
//        paramSource.addValue("cantidad", servicioProporcionado.getCantidad());
//        paramSource.addValue("costo", servicioProporcionado.getCosto());
//        paramSource.addValue("estado", servicioProporcionado.getEstado());
//        paramSource.addValue("fecha", servicioProporcionado.getFecha());
//
//        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlReservar, paramSource, Long.class);
    }

    @Override
    public void calificar(ServicioProporcionado servicioProporcionado) {
        this.customNamedParameterJdbcTemplate.actualizar(servicioProporcionado, sqlCalificar);
//        MapSqlParameterSource paramSource = new MapSqlParameterSource();
//        paramSource.addValue("id", servicioProporcionado.getId());
//        paramSource.addValue("nivelSatisfacion", servicioProporcionado.getNivelSatisfacion());
//        paramSource.addValue("estado", servicioProporcionado.getEstado());
//        paramSource.addValue("fecha", servicioProporcionado.getFecha());
//
//        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCalificar, paramSource, Long.class);
    }

    @Override
    public boolean existePorId(Long id, String estado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("estado", estado);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class));
    }

}
