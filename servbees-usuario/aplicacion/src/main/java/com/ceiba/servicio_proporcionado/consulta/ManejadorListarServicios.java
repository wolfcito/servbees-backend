package com.ceiba.servicio_proporcionado.consulta;

import com.ceiba.servicio_proporcionado.modelo.dto.DtoServicioProporcionado;
import com.ceiba.servicio_proporcionado.puerto.dao.DaoServicioProporcionado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarServicios {

    private final DaoServicioProporcionado daoServicioProporcionado;

    public ManejadorListarServicios(DaoServicioProporcionado daoServicioProporcionado){
        this.daoServicioProporcionado = daoServicioProporcionado;
    }

    public List<DtoServicioProporcionado> ejecutar(){ return this.daoServicioProporcionado.listar(); }
}
