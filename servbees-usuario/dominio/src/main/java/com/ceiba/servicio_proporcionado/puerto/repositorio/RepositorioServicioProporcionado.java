package com.ceiba.servicio_proporcionado.puerto.repositorio;

import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;

public interface RepositorioServicioProporcionado {
    /**
     * Permite registrar un servcio
     * @param servicioProporcionado
     * @return el id generado
     */
    Long registrar(ServicioProporcionado servicioProporcionado);

    /**
     * Permite reservar un servcio
     * @param servicioProporcionado
     * @return el id generado
     */
    void reservar(ServicioProporcionado servicioProporcionado);

    /**
     * Permite calificar un servcio
     * @param servicioProporcionado
     * @return el id generado
     */
    void calificar(ServicioProporcionado servicioProporcionado);

    /**
     * Permite validar si existe un servicio por id
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id, String estado);

}
