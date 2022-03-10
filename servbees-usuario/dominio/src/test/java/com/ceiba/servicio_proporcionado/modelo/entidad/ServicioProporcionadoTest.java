package com.ceiba.servicio_proporcionado.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicio_proporcionado.servicio.testdatabuilder.ServicioProporcionadoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioProporcionadoTest {

    @Test
    @DisplayName("Deberia registrar correctamente un servicio")
    void deberiaRegistrarCorrectamenteUnServicio() {
        // arrange
        //act
        ServicioProporcionado servicioProporcionado = new ServicioProporcionadoTestDataBuilder().buildRegistrar();

        //assert
        assertEquals(1, servicioProporcionado.getIdCategoria());
        assertEquals(1, servicioProporcionado.getIdUsuarioPro());
    }


    @Test
    @DisplayName("Deberia fallar si ID CATEGORIA es negativo")
    void deberiaFallarSiIdCategoriaEsNegativo(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdCategoria(-1L);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildRegistrar();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia fallar si ID PROVEEDOR es negativo")
    void deberiaFallarSiIdProveedorEsNegativo(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdUsuarioPro(-1L);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildRegistrar();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia fallar si ID CATEGORIA es NULO")
    void deberiaFallarSiIdCategoriaNulo(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdCategoria(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildRegistrar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el ID de Categoria");
    }

    @Test
    @DisplayName("Deberia fallar si ID PROVEEDOR es NULO")
    void deberiaFallarSiIdProveedorNulo(){

        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdUsuarioPro(null);
        //Arrange
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioProporcionadoBuilder.buildRegistrar();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el ID de Proveedor");
    }

}