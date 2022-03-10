package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

final class ServicioExperienciaUsuarioTest {

    @Test
    @DisplayName("Deberia consultar si cumple la experiencia del usuario llamando al repositorio")
    void deberiaConsultarSiCumpleExperienciaUsuarioLlamandoAlRepositorio() {
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.experienciaPorIdUsuario(Mockito.anyLong())).thenReturn(true);
        ServicioExperienciaUsuario servicioExperienciaUsuario = new ServicioExperienciaUsuario(repositorioUsuario);

        boolean tieneExperiencia = servicioExperienciaUsuario.ejecutar(1L);
        assertTrue(tieneExperiencia);
        Mockito.verify(repositorioUsuario, Mockito.times(1)).experienciaPorIdUsuario(1L);

    }

    @Test
    @DisplayName("Deberia consulta que NO cumple Experiencia del Usuario llamando al repositorio")
    void eberiaConsultarNoCumpleExperienciaUsuarioLlamandoAlRepositorio() {
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.experienciaPorIdUsuario(Mockito.anyLong())).thenReturn(false);
        ServicioExperienciaUsuario servicioExperienciaUsuario = new ServicioExperienciaUsuario(repositorioUsuario);

        boolean tieneExperiencia = servicioExperienciaUsuario.ejecutar(10L);
        assertFalse(tieneExperiencia);
        Mockito.verify(repositorioUsuario, Mockito.times(1)).experienciaPorIdUsuario(10L);
    }


}
