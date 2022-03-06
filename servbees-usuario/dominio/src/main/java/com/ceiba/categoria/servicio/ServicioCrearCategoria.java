package com.ceiba.categoria.servicio;

import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCategoria {

    private static final String CATEGORIA_EXISTENTE = "El codigo de la categoria ya existe en el sistema";

    private final RepositorioCategoria repositorioCategoria;

    public ServicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    public Long ejecutar(Categoria categoria) {
        validarExistenciaPrevia(categoria);
        return this.repositorioCategoria.crear(categoria);
    }

    private void validarExistenciaPrevia(Categoria categoria) {
        boolean existe = this.repositorioCategoria.existe(categoria.getCodigo());
        if(existe) {
            throw new ExcepcionDuplicidad(CATEGORIA_EXISTENTE);
        }
    }
}
