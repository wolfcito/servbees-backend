package com.ceiba.servicio_proporcionado.puerto.dao;

import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosDisponibles;
import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosReservados;

import java.util.List;

public interface DaoServicioProporcionado {

    /**
     * Permite listar Servicios
     * @return los X servicios
     */
    List<DtoServicioProporcionado> listar();

    /**
     * Permite listar Servicios disponibles
     * @return los servicios
     */
    List<DtoServiciosDisponibles> listarTodosDisponibles();

    /**
     * Permite listar Servicios reservados
     * @return los servicios
     */
    List<DtoServiciosReservados> listarTodosReservados(Long id);
}
