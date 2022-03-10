package com.ceiba.servicio_proporcionado.consulta;

import com.ceiba.servicio_proporcionado.modelo.dto.DtoServiciosDisponibles;
import com.ceiba.servicio_proporcionado.puerto.dao.DaoServicioProporcionado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDisponiblesServicios {

    private final DaoServicioProporcionado daoServicioProporcionado;

    public ManejadorListarDisponiblesServicios(DaoServicioProporcionado daoServicioProporcionado){
        this.daoServicioProporcionado = daoServicioProporcionado;
    }

    public List<DtoServiciosDisponibles> ejecutar(){ return this.daoServicioProporcionado.listarTodosDisponibles(); }
}
