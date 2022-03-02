package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioCategoria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarCategoriaTest {

    @Test
    @DisplayName("Deberia eliminar una categoria llamando al repositorio")
    void deberiaEliminarLaCategoriaLlamandoAlRepositorio() {
        RepositorioCategoria repositorioUsuario = Mockito.mock(RepositorioCategoria.class);
        ServicioEliminarCategoria servicioEliminarUsuario = new ServicioEliminarCategoria(repositorioUsuario);

        servicioEliminarUsuario.ejecutar(1L);

        Mockito.verify(repositorioUsuario, Mockito.times(1)).eliminar(1L);

    }

}
