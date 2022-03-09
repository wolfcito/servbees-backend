package com.ceiba.servicio_proporcionado.controlador;

import com.ceiba.servicio_proporcionado.consulta.ManejadorListarServicios;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicios")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorServicio {

    private final ManejadorListarServicios manejadorListarServicios;

    public ConsultaControladorServicio(ManejadorListarServicios manejadorListarServicios) {
        this.manejadorListarServicios = manejadorListarServicios;
    }

    @GetMapping("/buscar-mejores")
    @ApiOperation("Listar los mejores por servicios realizados")
    public List<DtoServicioProporcionado> listar() {
        return this.manejadorListarServicios.ejecutar();
    }

}
