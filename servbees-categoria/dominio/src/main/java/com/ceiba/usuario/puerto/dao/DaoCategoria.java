package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoCategoria;

import java.util.List;

public interface DaoCategoria {

    /**
     * Permite listar categorias
     * @return los categorias
     */
    List<DtoCategoria> listar();
}
