package com.ceiba.servicio_proporcionado.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.servicio_proporcionado.comando.ComandoRegistrar;
import com.ceiba.servicio_proporcionado.comando.fabrica.FabricaServicioProporcionado;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.ServicioRegistrarServicioProporcionado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarMejoresServicioProporcionado implements ManejadorComandoRespuesta<ComandoRegistrar, ComandoRespuesta<Long>> {

    private final FabricaServicioProporcionado fabricaServicioProporcionado;
    private final ServicioRegistrarServicioProporcionado servicioRegistrarServicioProporcionado;

    public ManejadorBuscarMejoresServicioProporcionado(FabricaServicioProporcionado fabricaServicioProporcionado, ServicioRegistrarServicioProporcionado servicioRegistrarServicioProporcionado) {
        this.fabricaServicioProporcionado = fabricaServicioProporcionado;
        this.servicioRegistrarServicioProporcionado = servicioRegistrarServicioProporcionado;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRegistrar comandoRegistrar) {
        ServicioProporcionado servicioProporcionado = this.fabricaServicioProporcionado.registrar(comandoRegistrar);
        return new ComandoRespuesta<>(this.servicioRegistrarServicioProporcionado.ejecutar(servicioProporcionado));
    }
}
