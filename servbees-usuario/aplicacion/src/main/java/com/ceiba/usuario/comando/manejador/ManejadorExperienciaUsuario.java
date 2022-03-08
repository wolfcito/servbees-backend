package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoExperiencia;
import com.ceiba.usuario.servicio.ServicioExperienciaUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorExperienciaUsuario implements ManejadorComandoRespuesta<ComandoExperiencia, ComandoRespuesta<Boolean>> {

    private final ServicioExperienciaUsuario servicioExperienciaUsuario;

    public ManejadorExperienciaUsuario(ServicioExperienciaUsuario servicioExperienciaUsuario) {
        this.servicioExperienciaUsuario = servicioExperienciaUsuario;
    }

    public ComandoRespuesta<Boolean> ejecutar(ComandoExperiencia comandoExperiencia) {
        return new ComandoRespuesta<>(this.servicioExperienciaUsuario.ejecutar(comandoExperiencia.getId()));
    }
}
