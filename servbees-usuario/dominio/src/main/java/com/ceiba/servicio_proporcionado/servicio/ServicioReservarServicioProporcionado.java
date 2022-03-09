package com.ceiba.servicio_proporcionado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.puerto.repositorio.RepositorioServicioProporcionado;

public class ServicioReservarServicioProporcionado {

    private static final String EL_SERVICIO_YA_NO_ESTA_DISPONIBLE = "El servicio ya no está disponible";
    private static final String ESTADO_DISPONIBLE = "D";

    private final RepositorioServicioProporcionado repositorioServicioProporcionado;

    public ServicioReservarServicioProporcionado(RepositorioServicioProporcionado repositorioServicioProporcionado) {
        this.repositorioServicioProporcionado = repositorioServicioProporcionado;
    }

    public void ejecutar(ServicioProporcionado servicioProporcionado) {
        validarExistenciaPrevia(servicioProporcionado);
        this.repositorioServicioProporcionado.reservar(servicioProporcionado);
    }

    private void validarExistenciaPrevia(ServicioProporcionado servicioProporcionado) {
        boolean existe = this.repositorioServicioProporcionado.existePorId(servicioProporcionado.getId(), ESTADO_DISPONIBLE);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_SERVICIO_YA_NO_ESTA_DISPONIBLE);
        }
    }


}
