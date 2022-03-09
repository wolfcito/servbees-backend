package com.ceiba.configuracion.servicio_proporcionado;

import com.ceiba.servicio_proporcionado.puerto.repositorio.RepositorioServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.ServicioCalificarServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.ServicioRegistrarServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.ServicioReservarServicioProporcionado;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioProporcionadoServicio {

    @Bean
    public ServicioRegistrarServicioProporcionado servicioRegistrarServicioProporcionado(RepositorioServicioProporcionado repositorioServicioProporcionado) {
        return new ServicioRegistrarServicioProporcionado(repositorioServicioProporcionado);
    }

    @Bean
    public ServicioReservarServicioProporcionado servicioReservarServicioProporcionado(RepositorioServicioProporcionado repositorioServicioProporcionado) {
        return new ServicioReservarServicioProporcionado(repositorioServicioProporcionado);
    }
    @Bean
    public ServicioCalificarServicioProporcionado servicioCalificarServicioProporcionado(RepositorioServicioProporcionado repositorioServicioProporcionado) {
        return new ServicioCalificarServicioProporcionado(repositorioServicioProporcionado);
    }

}
