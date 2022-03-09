package com.ceiba.servicio_proporcionado.puerto.dao;

import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;

import java.util.List;

public interface DaoServicioProporcionado {

    /**
     * Permite listar Servicios
     * @return los usuarios
     */
    List<DtoServicioProporcionado> listar();
}
