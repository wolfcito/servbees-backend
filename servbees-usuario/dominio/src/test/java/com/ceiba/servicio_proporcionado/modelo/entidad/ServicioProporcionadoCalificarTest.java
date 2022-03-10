package com.ceiba.servicio_proporcionado.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicio_proporcionado.modelo.Estados;
import com.ceiba.servicio_proporcionado.modelo.NivelesSatisfacion;
import com.ceiba.servicio_proporcionado.servicio.testdatabuilder.ServicioProporcionadoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioProporcionadoCalificarTest {

    private final String LONGITUD_MAXIMA_EXCEDIDA_PARA = "Longitud maxima excedida para %s es de %s caracteres";
    private final String SE_DEBE_INGRESAR_VALOR_LISTA = "Se debe ingresar un valor de la lista: %s";

    @Test
    @DisplayName("Deberia reservar correctamente un servicio")
    void deberiaReservaCorrectamenteUnServicio() {
        // arrange
        //act
        ServicioProporcionado servicioProporcionado = new ServicioProporcionadoTestDataBuilder().buildCalificar();

        //assert
        assertEquals(1L, servicioProporcionado.getId());
        assertEquals("NOR", servicioProporcionado.getNivelSatisfacion());
        assertEquals("D", servicioProporcionado.getEstado());

    }


    @Test
    @DisplayName("Deberia fallar si se reserva sin ID SERVICIO")
    void deberiaFallarSiSeReservaSinIdServicio() {

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conId(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildCalificar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el ID Servicio");
    }

    @Test
    @DisplayName("Deberia fallar si ID es negativo")
    void deberiaFallarSiIdServicioEsNegativo() {

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conId(-1L);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildCalificar();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia fallar si NIVEL SATISFACCION excede longitud columna")
    void deberiaFallarSiNivelSatisfacionExcedeLongitdColumna() {

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conNivelSatisfacion("qwerp");
        //Arrange
        //act-assert
        int LONGITUD_MAX_NIVEL_SATISFACCION = 3;
        String NIVEL_SATISFACCION = "NIVEL SATISFACCION";
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildCalificar();
                },
                ExcepcionLongitudValor.class, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, NIVEL_SATISFACCION, LONGITUD_MAX_NIVEL_SATISFACCION));
    }

    @Test
    @DisplayName("Deberia fallar si ESTADO excede longitud columna")
    void deberiaFallarSiEstadoExcedeLongitdColumna() {

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conEstado("qwerp");
        //Arrange
        //act-assert
        int LONGITUD_MAX_ESTADO = 1;
        String ESTADO = "ESTADO";
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildCalificar();
                },
                ExcepcionLongitudValor.class, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, ESTADO, LONGITUD_MAX_ESTADO));
    }

    @Test
    @DisplayName("Deberia fallar si NIVEL SATISFACCION no esta en lista de permitidos")
    void deberiaFallarSiNivelSatisfacionNoEstaEnPermitidos() {

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conNivelSatisfacion("x");
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildCalificar();
                },
                ExcepcionValorInvalido.class, String.format(SE_DEBE_INGRESAR_VALOR_LISTA, Arrays.asList(NivelesSatisfacion.values())));
    }

    @Test
    @DisplayName("Deberia fallar si ESTADO no está en lista de permitidos")
    void deberiaFallarSiEstadoNoEstaEnPermitidos() {

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conEstado("x");
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildCalificar();
                },
                ExcepcionValorInvalido.class, String.format(SE_DEBE_INGRESAR_VALOR_LISTA, Arrays.asList(Estados.values())));
    }

}