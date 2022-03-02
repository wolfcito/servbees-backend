package com.ceiba.categoria.puerto.dao;

import com.ceiba.categoria.modelo.dto.DtoCategoria;

import java.util.List;

public interface DaoCategoria {

    /**
     * Permite listar categorias
     * @return los categorias
     */
    List<DtoCategoria> listar();
}
