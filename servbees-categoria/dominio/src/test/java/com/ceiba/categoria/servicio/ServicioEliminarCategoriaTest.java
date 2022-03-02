package com.ceiba.categoria.servicio;

import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public final class ServicioEliminarCategoriaTest {

    @Test
    @DisplayName("Deberia eliminar una categoria llamando al repositorio")
    void deberiaEliminarLaCategoriaLlamandoAlRepositorio() {
        RepositorioCategoria repositorioCategoria = Mockito.mock(RepositorioCategoria.class);
        ServicioEliminarCategoria servicioEliminarCategoria = new ServicioEliminarCategoria(repositorioCategoria);

        servicioEliminarCategoria.ejecutar(1L);

        Mockito.verify(repositorioCategoria, Mockito.times(1)).eliminar(1L);

    }

}
