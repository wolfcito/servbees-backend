package com.ceiba.servicio_proporcionado.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.servicio_proporcionado.comando.ComandoCalificar;
import com.ceiba.servicio_proporcionado.comando.fabrica.FabricaServicioProporcionado;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.ServicioCalificarServicioProporcionado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCalificarServicioProporcionado implements ManejadorComandoRespuesta<ComandoCalificar, ComandoRespuesta<Long>> {

    private final FabricaServicioProporcionado fabricaServicioProporcionado;
    private final ServicioCalificarServicioProporcionado servicioCalificarServicioProporcionado;

    public ManejadorCalificarServicioProporcionado(FabricaServicioProporcionado fabricaServicioProporcionado, ServicioCalificarServicioProporcionado servicioCalificarServicioProporcionado) {
        this.fabricaServicioProporcionado = fabricaServicioProporcionado;
        this.servicioCalificarServicioProporcionado = servicioCalificarServicioProporcionado;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCalificar comandoCalificar) {
        ServicioProporcionado servicioProporcionado = this.fabricaServicioProporcionado.calificar(comandoCalificar);
        this.servicioCalificarServicioProporcionado.ejecutar(servicioProporcionado);
        return new ComandoRespuesta<>(1L);
    }
}
