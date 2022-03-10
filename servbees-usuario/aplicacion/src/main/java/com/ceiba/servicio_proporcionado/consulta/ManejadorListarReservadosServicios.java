package com.ceiba.servicio_proporcionado.consulta;

import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosReservados;
import com.ceiba.servicio_proporcionado.puerto.dao.DaoServicioProporcionado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarReservadosServicios {

    private final DaoServicioProporcionado daoServicioProporcionado;

    public ManejadorListarReservadosServicios(DaoServicioProporcionado daoServicioProporcionado){
        this.daoServicioProporcionado = daoServicioProporcionado;
    }

    public List<DtoServiciosReservados> ejecutar(Long id){ return this.daoServicioProporcionado.listarTodosReservados(id); }
}
