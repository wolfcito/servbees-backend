package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class UsuarioLoginTest {


    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElUsusuario() {
        // arrange
        //act
        Usuario usuario = new UsuarioTestDataBuilder().buildLogin();
        //assert
        assertEquals("test", usuario.getNombre());
        assertEquals("1234", usuario.getClave());
    }

    @Test
    @DisplayName("Deberia fallar si nombre del usuario login nulo")
    void deberiaFallarSinNombreDeUsuarioLogin() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.buildLogin();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
    }

    @Test
    @DisplayName("Deberia fallar si clave del usuario login nulo")
    void deberiaFallarSinClaveLogin() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.buildLogin();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la clave");
    }

    @Test
    @DisplayName("Deberia fallar si tamaño de la clave es menor que X")
    void deberiaFallarSinTamanioClaveLogin() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("123").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.buildLogin();
                },
                ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

}
