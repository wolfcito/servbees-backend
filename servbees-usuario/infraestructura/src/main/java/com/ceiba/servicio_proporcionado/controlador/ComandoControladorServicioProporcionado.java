package com.ceiba.servicio_proporcionado.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.servicio_proporcionado.comando.ComandoCalificar;
import com.ceiba.servicio_proporcionado.comando.ComandoRegistrar;
import com.ceiba.servicio_proporcionado.comando.ComandoReservar;
import com.ceiba.servicio_proporcionado.comando.manejador.ManejadorCalificarServicioProporcionado;
import com.ceiba.servicio_proporcionado.comando.manejador.ManejadorRegistrarServicioProporcionado;
import com.ceiba.servicio_proporcionado.comando.manejador.ManejadorReservarServicioProporcionado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicios")
@Api(tags = {"Controlador comando servicios"})
public class ComandoControladorServicioProporcionado {

    private final ManejadorRegistrarServicioProporcionado manejadorRegistrarServicioProporcionado;
    private final ManejadorReservarServicioProporcionado manejadorReservarServicioProporcionado;
    private final ManejadorCalificarServicioProporcionado manejadorCalificarServicioProporcionado;


    @Autowired
    public ComandoControladorServicioProporcionado(ManejadorRegistrarServicioProporcionado manejadorRegistrarServicioProporcionado,
                                                   ManejadorReservarServicioProporcionado manejadorReservarServicioProporcionado,
                                                   ManejadorCalificarServicioProporcionado manejadorCalificarServicioProporcionado) {
        this.manejadorRegistrarServicioProporcionado = manejadorRegistrarServicioProporcionado;
        this.manejadorReservarServicioProporcionado = manejadorReservarServicioProporcionado;
        this.manejadorCalificarServicioProporcionado = manejadorCalificarServicioProporcionado;

    }

    @PostMapping(value = "/registrar")
    @ApiOperation("Registra un servicio del Proveedor")
    public ComandoRespuesta<Long> registrar(@RequestBody ComandoRegistrar comandoRegistrar) {

        return manejadorRegistrarServicioProporcionado.ejecutar(comandoRegistrar);
    }

    @PostMapping(value = "/{id}/reservar")
    @ApiOperation("Reserva un servicio del Proveedor")
    public ComandoRespuesta<Long> reservar(@PathVariable Long id, @RequestBody ComandoReservar comandoReservar) {
        comandoReservar.setId(id);
        return manejadorReservarServicioProporcionado.ejecutar(comandoReservar);
    }

    @PostMapping(value = "/{id}/calificar")
    @ApiOperation("Califica un servicio del Proveedor")
    public ComandoRespuesta<Long> calificar(@PathVariable Long id, @RequestBody ComandoCalificar comandoCalificar) {
        comandoCalificar.setId(id);
        return manejadorCalificarServicioProporcionado.ejecutar(comandoCalificar);
    }


}
