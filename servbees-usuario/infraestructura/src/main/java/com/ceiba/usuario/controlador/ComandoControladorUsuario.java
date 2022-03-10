package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoExperiencia;
import com.ceiba.usuario.comando.ComandoIngreso;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = {"Controlador comando usuario"})
public class ComandoControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorEliminarUsuario manejadorEliminarUsuario;
    private final ManejadorActualizarUsuario manejadorActualizarUsuario;
    private final ManejadorIngresarUsuario manejadorIngresarUsuario;
    private final ManejadorExperienciaUsuario manejadorExperienciaUsuario;

    @Autowired
    public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario,
                                     ManejadorEliminarUsuario manejadorEliminarUsuario,
                                     ManejadorActualizarUsuario manejadorActualizarUsuario,
                                     ManejadorIngresarUsuario manejadorIngresarUsuario,
                                     ManejadorExperienciaUsuario manejadorExperienciaUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorEliminarUsuario = manejadorEliminarUsuario;
        this.manejadorActualizarUsuario = manejadorActualizarUsuario;
        this.manejadorIngresarUsuario = manejadorIngresarUsuario;
        this.manejadorExperienciaUsuario = manejadorExperienciaUsuario;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoUsuario comandoUsuario) {
        return manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarUsuario.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody ComandoUsuario comandoUsuario, @PathVariable Long id) {
        comandoUsuario.setId(id);
        manejadorActualizarUsuario.ejecutar(comandoUsuario);
    }

    @PostMapping(value = "/login")
    @ApiOperation("Obtener id Usuario")
    public ComandoRespuesta<Long> ingresar(@RequestBody ComandoIngreso comandoIngreso) {
        return manejadorIngresarUsuario.ejecutar(comandoIngreso);
    }

    @GetMapping(value = "/{id}/experiencia")
    @ApiOperation("Obtener experiencia usuario")
    public ComandoRespuesta<Boolean> experiencia(@PathVariable Long id) {
        ComandoExperiencia comandoExperiencia = new ComandoExperiencia();
        comandoExperiencia.setId(id);
        return manejadorExperienciaUsuario.ejecutar(comandoExperiencia);
    }

}
