package com.ceiba.servicio_proporcionado.controlador;

import com.ceiba.servicio_proporcionado.consulta.ManejadorListarDisponiblesServicios;
import com.ceiba.servicio_proporcionado.consulta.ManejadorListarReservadosServicios;
import com.ceiba.servicio_proporcionado.consulta.ManejadorListarServicios;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosDisponibles;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosReservados;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicios")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorServicio {

    private final ManejadorListarServicios manejadorListarServicios;
    private final ManejadorListarDisponiblesServicios manejadorListarDisponiblesServicios;
    private final ManejadorListarReservadosServicios manejadorListarReservadosServicios;

    public ConsultaControladorServicio(ManejadorListarServicios manejadorListarServicios,
                                       ManejadorListarDisponiblesServicios manejadorListarDisponiblesServicios,
                                       ManejadorListarReservadosServicios manejadorListarReservadosServicios
                                       ) {
        this.manejadorListarServicios = manejadorListarServicios;
        this.manejadorListarDisponiblesServicios = manejadorListarDisponiblesServicios;
this.manejadorListarReservadosServicios = manejadorListarReservadosServicios;

    }

    @GetMapping
    @ApiOperation("Listar todos servicios realizados")
    public List<DtoServiciosDisponibles> listarTodosDisponibles() {
        return this.manejadorListarDisponiblesServicios.ejecutar();
    }

    @GetMapping("/buscar-mejores")
    @ApiOperation("Listar los mejores por servicios realizados")
    public List<DtoServicioProporcionado> listar() {
        return this.manejadorListarServicios.ejecutar();
    }

    @GetMapping(value = "/{id}/reservados")
    @ApiOperation("Listar todos servicios realizados")
    public List<DtoServiciosReservados> listarTodosDisponibles(@PathVariable Long id) {
        return this.manejadorListarReservadosServicios.ejecutar(id);
    }
}
