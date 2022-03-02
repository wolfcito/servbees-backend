package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ManejadorListarCategorias;
import com.ceiba.usuario.modelo.dto.DtoCategoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@Api(tags={"Controlador consulta categorias"})
public class ConsultaControladorCategoria {

    private final ManejadorListarCategorias manejadorListarCategorias;

    public ConsultaControladorCategoria(ManejadorListarCategorias manejadorListarCategorias) {
        this.manejadorListarCategorias = manejadorListarCategorias;
    }

    @GetMapping
    @ApiOperation("Listar Categorias")
    public List<DtoCategoria> listar() {
        return this.manejadorListarCategorias.ejecutar();
    }

}
