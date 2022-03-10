package com.ceiba.servicio_proporcionado.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioListaReservaServicio {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioListaReservaServicio(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Boolean ejecutar(Long id) {
        return this.repositorioUsuario.experienciaPorIdUsuario(id);
    }

}
