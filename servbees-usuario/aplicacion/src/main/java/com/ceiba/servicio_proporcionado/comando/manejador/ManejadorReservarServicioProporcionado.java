package com.ceiba.servicio_proporcionado.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.servicio_proporcionado.comando.ComandoReservar;
import com.ceiba.servicio_proporcionado.comando.fabrica.FabricaServicioProporcionado;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.ServicioReservarServicioProporcionado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorReservarServicioProporcionado implements ManejadorComandoRespuesta<ComandoReservar, ComandoRespuesta<Long>> {

    private final FabricaServicioProporcionado fabricaServicioProporcionado;
    private final ServicioReservarServicioProporcionado servicioReservarServicioProporcionado;

    public ManejadorReservarServicioProporcionado(FabricaServicioProporcionado fabricaServicioProporcionado, ServicioReservarServicioProporcionado servicioReservarServicioProporcionado) {
        this.fabricaServicioProporcionado = fabricaServicioProporcionado;
        this.servicioReservarServicioProporcionado = servicioReservarServicioProporcionado;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoReservar comandoReservar) {
        ServicioProporcionado servicioProporcionado = this.fabricaServicioProporcionado.reservar(comandoReservar);
        this.servicioReservarServicioProporcionado.ejecutar(servicioProporcionado);
        return new ComandoRespuesta<>(1L);
    }
}
