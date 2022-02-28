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

public final class ServicioIngresarUsuarioTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la longitud de la clave sea menor a 4")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaClaveSeaMenorACuatro() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la dublicidad del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaDuplicidadDelUsuario() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.idPorUsuarioClave(usuario.getNombre(), usuario.getClave())).thenReturn(-1L);
        ServicioIngresarUsuario servicioIngresarUsuario = new ServicioIngresarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioIngresarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"Usuario duplicado en el sistema");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la inexistencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaInexistenciaDelUsuario() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.idPorUsuarioClave(usuario.getNombre(), usuario.getClave())).thenReturn(0L);
        ServicioIngresarUsuario servicioIngresarUsuario = new ServicioIngresarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioIngresarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario NO existe en el sistema");
    }

    @Test
    @DisplayName("Deberia devolver el id cuando cuando se valide la existencia del Usuario")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
//        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioUsuario.idPorUsuarioClave(usuario.getNombre(), usuario.getClave())).thenReturn(2L);
        ServicioIngresarUsuario servicioIngresarUsuario = new ServicioIngresarUsuario(repositorioUsuario);
        // act
        Long idUsuario = servicioIngresarUsuario.ejecutar(usuario);
        //- assert
        assertEquals(2L,idUsuario);
        Mockito.verify(repositorioUsuario, Mockito.times(1)).idPorUsuarioClave(usuario.getNombre(), usuario.getClave());
    }
}
