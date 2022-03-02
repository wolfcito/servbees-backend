package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Categoria;

public interface RepositorioCategoria {
    /**
     * Permite crear un categoria
     * @param categoria
     * @return el id generado
     */
    Long crear(Categoria categoria);

    /**
     * Permite eliminar un categoria
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param codigo
     * @return si existe o no
     */
    boolean existe(String codigo);

}
