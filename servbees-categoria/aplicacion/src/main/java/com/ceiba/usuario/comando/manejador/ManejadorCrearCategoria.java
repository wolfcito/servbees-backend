package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCategoria;
import com.ceiba.usuario.comando.fabrica.FabricaCategoria;
import com.ceiba.usuario.modelo.entidad.Categoria;
import com.ceiba.usuario.servicio.ServicioCrearCategoria;
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
