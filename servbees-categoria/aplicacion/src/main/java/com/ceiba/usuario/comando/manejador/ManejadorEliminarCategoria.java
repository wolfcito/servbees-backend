package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarCategoria;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarCategoria implements ManejadorComando<Long> {

    private final ServicioEliminarCategoria servicioEliminarCategoria;

    public ManejadorEliminarCategoria(ServicioEliminarCategoria servicioEliminarCategoria) {
        this.servicioEliminarCategoria = servicioEliminarCategoria;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarCategoria.ejecutar(idUsuario);
    }
}
