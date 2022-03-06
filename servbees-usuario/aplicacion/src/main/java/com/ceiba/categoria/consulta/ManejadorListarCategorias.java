package com.ceiba.categoria.consulta;

import com.ceiba.categoria.modelo.dto.DtoCategoria;
import com.ceiba.categoria.puerto.dao.DaoCategoria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCategorias {

    private final DaoCategoria daoCategoria;

    public ManejadorListarCategorias(DaoCategoria daoCategoria){
        this.daoCategoria = daoCategoria;
    }

    public List<DtoCategoria> ejecutar(){ return this.daoCategoria.listar(); }
}
