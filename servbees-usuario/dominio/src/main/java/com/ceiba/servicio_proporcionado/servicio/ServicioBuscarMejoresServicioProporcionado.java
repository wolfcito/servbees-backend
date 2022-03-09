package com.ceiba.servicio_proporcionado.servicio;

import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.puerto.repositorio.RepositorioServicioProporcionado;

public class ServicioBuscarMejoresServicioProporcionado {

    private final RepositorioServicioProporcionado repositorioServicioProporcionado;

    public ServicioBuscarMejoresServicioProporcionado(RepositorioServicioProporcionado repositorioServicioProporcionado) {
        this.repositorioServicioProporcionado = repositorioServicioProporcionado;
    }

    public Long ejecutar(ServicioProporcionado servicioProporcionado) {
        return this.repositorioServicioProporcionado.registrar(servicioProporcionado);
    }

}
