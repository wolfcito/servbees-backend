package com.ceiba.servicio_proporcionado.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicio_proporcionado.modelo.Estados;
import com.ceiba.servicio_proporcionado.modelo.Modalidades;
import com.ceiba.servicio_proporcionado.servicio.testdatabuilder.ServicioProporcionadoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioProporcionadoReservarTest {

    private final String LONGITUD_MAXIMA_EXCEDIDA_PARA = "Longitud maxima excedida para %s es de %s caracteres";
    private final String SE_DEBE_INGRESAR_VALOR_LISTA = "Se debe ingresar un valor de la lista: %s";

    @Test
    @DisplayName("Deberia reservar correctamente un servicio")
    void deberiaReservaCorrectamenteUnServicio() {
        // arrange
        //act
        ServicioProporcionado servicioProporcionado = new ServicioProporcionadoTestDataBuilder().buildReservar();

        //assert
        assertEquals(1L, servicioProporcionado.getId());
        assertEquals(1L, servicioProporcionado.getIdUsuarioCli());
        assertEquals("PH", servicioProporcionado.getModalidad());
        assertEquals(1, servicioProporcionado.getCantidad());
        assertEquals(100.0, servicioProporcionado.getCosto());
        assertEquals("D", servicioProporcionado.getEstado());

    }


    @Test
    @DisplayName("Deberia fallar si se reserva sin ID SERVICIO")
    void deberiaFallarSiSeReservaSinIdServicio(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conId(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el ID Servicio");
    }

    @Test
    @DisplayName("Deberia fallar si se reserva sin ID CLIENTE")
    void deberiaFallarSiSeReservaSinIdCliente(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdUsuarioCli(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el ID de CLiente");
    }

    @Test
    @DisplayName("Deberia fallar si se reserva sin CANTIDAD")
    void deberiaFallarSiSeReservaSinCantidad(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conCantidad(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad");
    }

    @Test
    @DisplayName("Deberia fallar si se reserva sin MODALIDAD")
    void deberiaFallarSiSeReservaSinModalidad(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conModalidad(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la modalidad");
    }

    @Test
    @DisplayName("Deberia fallar si se reserva sin COSTO")
    void deberiaFallarSiSeReservaSinCosto(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conCosto(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el costo");
    }

    @Test
    @DisplayName("Deberia fallar si se reserva sin ESTADO")
    void deberiaFallarSiSeReservaSinEstado(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conEstado(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el estado");
    }

    @Test
    @DisplayName("Deberia fallar si ID es negativo")
    void deberiaFallarSiIdServicioEsNegativo(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conId(-1L);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia fallar si ID CLIENTE es negativo")
    void deberiaFallarSiIdClienteEsNegativo(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdUsuarioCli(-1L);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia fallar si CANTIDAD es negativo")
    void deberiaFallarSiCantidadEsNegativo(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conCantidad(-1);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia fallar si COSTO es negativo")
    void deberiaFallarSiCostoEsNegativo(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conCosto(-100.0);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia fallar si ESTADO excede longitud columna")
    void deberiaFallarSiEstadoExcedeLongitdColumna(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conEstado("qwerp");
        //Arrange
        //act-assert
        int LONGITUD_MAX_ESTADO = 1;
        String ESTADO = "ESTADO";
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionLongitudValor.class, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, ESTADO, LONGITUD_MAX_ESTADO));
    }

    @Test
    @DisplayName("Deberia fallar si MODALIDAD excede longitud columna")
    void deberiaFallarSiModalidadExcedeLongitdColumna(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conModalidad("qwertyuiop");
        //Arrange
        //act-assert
        int LONGITUD_MAX_MODALIDAD = 2;
        String MODALIDAD = "MODALIDAD";
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionLongitudValor.class, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, MODALIDAD, LONGITUD_MAX_MODALIDAD));
    }

    @Test
    @DisplayName("Deberia fallar si MODALIDAD no está en lista de permitidos")
    void deberiaFallarSiModalidadNoEstaEnPermitidos(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conModalidad("NU");
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorInvalido.class, String.format(SE_DEBE_INGRESAR_VALOR_LISTA, Arrays.asList(Modalidades.values())));
    }

    @Test
    @DisplayName("Deberia fallar si ESTADO no está en lista de permitidos")
    void deberiaFallarSiEstadoNoEstaEnPermitidos(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conEstado("x");
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildReservar();
                },
                ExcepcionValorInvalido.class, String.format(SE_DEBE_INGRESAR_VALOR_LISTA, Arrays.asList(Estados.values())));
    }

}