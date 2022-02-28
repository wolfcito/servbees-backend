package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoIngreso;
import com.ceiba.usuario.comando.fabrica.FabricaIngreso;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioIngresarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorIngresarUsuario implements ManejadorComandoRespuesta<ComandoIngreso, ComandoRespuesta<Long>> {

    private final FabricaIngreso fabricaIngreso;
    private final ServicioIngresarUsuario servicioIngresarUsuario;

    public ManejadorIngresarUsuario(FabricaIngreso fabricaIngreso,  ServicioIngresarUsuario servicioIngresarUsuario) {
        this.fabricaIngreso = fabricaIngreso;
        this.servicioIngresarUsuario = servicioIngresarUsuario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoIngreso comandoUsuario) {
        Usuario usuario = this.fabricaIngreso.crear(comandoUsuario);
        return new ComandoRespuesta<>(this.servicioIngresarUsuario.ejecutar(usuario));
    }
}
