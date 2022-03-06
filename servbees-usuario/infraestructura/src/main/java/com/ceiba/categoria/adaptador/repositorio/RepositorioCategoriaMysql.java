package com.ceiba.categoria.adaptador.repositorio;

import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoriaMysql implements RepositorioCategoria {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="categoria", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="categoria", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="categoria", value="existe")
    private static String sqlExiste;

    public RepositorioCategoriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Categoria categoria) {
        return this.customNamedParameterJdbcTemplate.crear(categoria, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigo", codigo);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class));
    }

}
