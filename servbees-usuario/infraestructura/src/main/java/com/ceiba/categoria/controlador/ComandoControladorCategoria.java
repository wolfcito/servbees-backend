package com.ceiba.categoria.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.categoria.comando.ComandoCategoria;
import com.ceiba.categoria.comando.manejador.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@Api(tags = { "Controlador comando categorias"})
public class ComandoControladorCategoria {

    private final ManejadorCrearCategoria manejadorCrearCategoria;
	private final ManejadorEliminarCategoria manejadorEliminarCategoria;

    @Autowired
    public ComandoControladorCategoria(ManejadorCrearCategoria manejadorCrearCategoria,
                                       ManejadorEliminarCategoria manejadorEliminarCategoria) {
        this.manejadorCrearCategoria = manejadorCrearCategoria;
		this.manejadorEliminarCategoria = manejadorEliminarCategoria;
    }

    @PostMapping
    @ApiOperation("Crear una categoria")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCategoria comandoCategoria) {
        return manejadorCrearCategoria.ejecutar(comandoCategoria);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar una categoria")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarCategoria.ejecutar(id);
	}


}
