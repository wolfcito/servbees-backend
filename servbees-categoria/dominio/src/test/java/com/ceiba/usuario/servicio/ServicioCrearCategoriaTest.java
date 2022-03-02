package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearUsuarioTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la longitud de la clave sea menor a 4")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaClaveSeaMenorACuatro() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el usuario de manera correcta")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioUsuario.crear(usuario)).thenReturn(10L);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        // act
        Long idUsuario = servicioCrearUsuario.ejecutar(usuario);
        //- assert
        assertEquals(10L,idUsuario);
        Mockito.verify(repositorioUsuario, Mockito.times(1)).crear(usuario);
    }
}
