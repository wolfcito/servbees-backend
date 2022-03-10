package com.ceiba.categoria.puerto.repositorio;

import com.ceiba.categoria.modelo.entidad.Categoria;

public interface RepositorioCategoria {
    /**
     * Permite crear un categoria
     * @param categoria
     * @return el id generado
     */
    Long crear(Categoria categoria);

    /**
     * Permite validar si existe una categoria con un codigo especifico
     * @param codigo
     * @return si existe o no
     */
    boolean existe(String codigo);

}
