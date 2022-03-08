package com.ceiba.configuracion.usuario;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanUsuarioServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioIngresarUsuario servicioIngresarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioIngresarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioExperienciaUsuario servicioExperienciaUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioExperienciaUsuario(repositorioUsuario);
    }

}
