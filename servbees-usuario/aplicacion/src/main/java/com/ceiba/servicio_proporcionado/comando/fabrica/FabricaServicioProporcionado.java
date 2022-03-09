package com.ceiba.servicio_proporcionado.comando.fabrica;

import com.ceiba.servicio_proporcionado.comando.ComandoCalificar;
import com.ceiba.servicio_proporcionado.comando.ComandoRegistrar;
import com.ceiba.servicio_proporcionado.comando.ComandoReservar;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import org.springframework.stereotype.Component;

@Component
public class FabricaServicioProporcionado {

    public ServicioProporcionado registrar(ComandoRegistrar comandoRegistrar) {
        return new ServicioProporcionado(
                comandoRegistrar.getIdCategoria(),
                comandoRegistrar.getIdUsuarioPro());
//                comandoRegistrar.getIdUsuarioCli(),
//                comandoRegistrar.getModalidad(),
//                comandoRegistrar.getCantidad(),
//                comandoRegistrar.getCosto(),
//                comandoRegistrar.getNivelSatisfacion(),
//                comandoRegistrar.getEstado(),
//                comandoRegistrar.getFecha());
    }

    public ServicioProporcionado reservar(ComandoReservar comandoReservar) {
        return new ServicioProporcionado(
                comandoReservar.getId(),
                comandoReservar.getIdUsuarioCli(),
                comandoReservar.getModalidad(),
                comandoReservar.getCantidad(),
                comandoReservar.getCosto(),
                comandoReservar.getEstado());
    }

    public ServicioProporcionado calificar(ComandoCalificar comandoCalificar) {
        return new ServicioProporcionado(
                comandoCalificar.getId(),
                comandoCalificar.getNivelSatisfacion(),
                comandoCalificar.getEstado());
    }

}
