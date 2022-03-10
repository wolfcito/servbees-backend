package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class UsuarioTest {

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElUsusuario() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Usuario usuario = new UsuarioTestDataBuilder().conFechaCreacion(fechaCreacion).conId(1L).build();
        //assert
        assertEquals(1, usuario.getId());
        assertEquals("test", usuario.getNombre());
        assertEquals("1234", usuario.getClave());
        assertEquals(fechaCreacion, usuario.getFechaCreacion());
    }

    @Test
    @DisplayName("Deberia fallar si nombre del usuario nulo")
    void deberiaFallarSinNombreDeUsuario() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
    }

    @Test
    @DisplayName("Deberia fallar si clave del usuario nulo")
    void deberiaFallarSinClave() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la clave");
    }

    @Test
    @DisplayName("Deberia fallar si tamaño de la clave es menor que X")
    void deberiaFallarSinTamanioClave() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("123").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    @DisplayName("Deberia fallar si fecha de creacion es nulo")
    void deberiaFallarSinFechaCreacion() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conFechaCreacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
    }

    @Test
    @DisplayName("Deberia fallar experiencia negativo")
    void deberiaFallarExperienciaNegativo() {

        //Arrange
        UsuarioTestDataBuilder categoriaTestDataBuilder = new UsuarioTestDataBuilder().conExperiencia(-1).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia fallar experiencia nulo")
    void deberiaFallarExperienciaNulo() {

        //Arrange
        UsuarioTestDataBuilder categoriaTestDataBuilder = new UsuarioTestDataBuilder()
                .conExperiencia(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar los meses de experiencia");
    }

}
