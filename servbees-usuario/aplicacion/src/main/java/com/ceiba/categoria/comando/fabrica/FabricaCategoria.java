package com.ceiba.categoria.comando.fabrica;

import com.ceiba.categoria.comando.ComandoCategoria;
import com.ceiba.categoria.modelo.entidad.Categoria;
import org.springframework.stereotype.Component;

@Component
public class FabricaCategoria {

    public Categoria crear(ComandoCategoria comandoCategoria) {
        return new Categoria(
                comandoCategoria.getId(),
                comandoCategoria.getNombre(),
                comandoCategoria.getCodigo(),
                comandoCategoria.getCostoHora(),
                comandoCategoria.getCostoDia(),
                comandoCategoria.getCostoSemana()
        );
    }

}
