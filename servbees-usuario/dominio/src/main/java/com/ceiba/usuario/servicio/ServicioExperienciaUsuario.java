package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioExperienciaUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioExperienciaUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Boolean ejecutar(Long id) {
        return this.repositorioUsuario.experienciaPorIdUsuario(id);
    }

}
