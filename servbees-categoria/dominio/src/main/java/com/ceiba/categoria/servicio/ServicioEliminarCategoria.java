package com.ceiba.categoria.servicio;

import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;

public class ServicioEliminarCategoria {

    private final RepositorioCategoria repositorioCategoria;

    public ServicioEliminarCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    public void ejecutar(Long id) {
        this.repositorioCategoria.eliminar(id);
    }
}
