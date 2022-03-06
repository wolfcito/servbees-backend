package com.ceiba.configuracion.categoria;

import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.categoria.servicio.ServicioCrearCategoria;
import com.ceiba.categoria.servicio.ServicioEliminarCategoria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCategoriaServicio {

    @Bean
    public ServicioCrearCategoria servicioActualizarCategoria(RepositorioCategoria repositorioCategoria) {
        return new ServicioCrearCategoria(repositorioCategoria);
    }

    @Bean
    public ServicioEliminarCategoria servicioEliminarCategoria(RepositorioCategoria repositorioCategoria) {
        return new ServicioEliminarCategoria(repositorioCategoria);
    }
	

}
