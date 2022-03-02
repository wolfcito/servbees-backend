package com.ceiba.categoria.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.categoria.comando.ComandoCategoria;
import com.ceiba.categoria.comando.fabrica.FabricaCategoria;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.servicio.ServicioCrearCategoria;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCategoria implements ManejadorComandoRespuesta<ComandoCategoria, ComandoRespuesta<Long>> {

    private final FabricaCategoria fabricaCategoria;
    private final ServicioCrearCategoria servicioCrearCategoria;

    public ManejadorCrearCategoria(FabricaCategoria fabricaCategoria, ServicioCrearCategoria servicioCrearCategoria) {
        this.fabricaCategoria = fabricaCategoria;
        this.servicioCrearCategoria = servicioCrearCategoria;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCategoria comandoCategoria) {
        Categoria categoria = this.fabricaCategoria.crear(comandoCategoria);
        return new ComandoRespuesta<>(this.servicioCrearCategoria.ejecutar(categoria));
    }
}
