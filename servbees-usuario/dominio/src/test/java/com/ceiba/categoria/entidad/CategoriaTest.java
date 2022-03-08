package com.ceiba.categoria.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.servicio.testdatabuilder.CategoriaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.generadores.Generadores;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class CategoriaTest {

    @Test
    @DisplayName("Deberia crear correctamente una categoria")
    void deberiaCrearCorrectamenteUnaCategoria() {
        // arrange
        //act
        Categoria categoria = new CategoriaTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, categoria.getId());
        assertEquals("Categoria", categoria.getNombre());
        assertEquals("CAT", categoria.getCodigo());
        assertEquals(10, categoria.getCostoHora());
        assertEquals(20, categoria.getCostoDia());
        assertEquals(30, categoria.getCostoSemana());

    }

    @Test
    @DisplayName("Deberia fallar si excede la longitud de NOMBRE de la categoria")
    void deberiaFallarSiExcedeLongitudDeNombreDeCategoria() {

        final int LONGITUD_MAXIMA = 100;
        String nombreInvalida = Generadores.palabra(LONGITUD_MAXIMA+1);
        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conNombre(nombreInvalida).conId(1L);
        //act-assert
        BasePrueba.assertThrows(categoriaTestDataBuilder::build,
                ExcepcionLongitudValor.class, String.format("Longitud maxima excedida para NOMBRE es de %s caracteres", LONGITUD_MAXIMA));
    }

    @Test
    @DisplayName("Deberia fallar si excede la longitud de CODIGO de la categoria")
    void deberiaFallarSiExcedeLongitudDeCodigoDeCategoria() {

        final int LONGITUD_MAXIMA = 5;
        String nombreInvalida = Generadores.palabra(LONGITUD_MAXIMA+1);
        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conCodigo(nombreInvalida).conId(1L);
        //act-assert
        BasePrueba.assertThrows(categoriaTestDataBuilder::build,
                ExcepcionLongitudValor.class, String.format("Longitud maxima excedida para CODIGO es de %s caracteres", LONGITUD_MAXIMA));
    }

    @Test
    @DisplayName("Deberia fallar si no se tiene NOMBRE de categoria")
    void deberiaFallarSinNombreDeCategoria() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de categoria");
    }

    @Test
    @DisplayName("Deberia fallar si no se tiene CODIGO de categoria")
    void deberiaFallarSinCcodigoDeCategoria() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conCodigo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el codigo");
    }

    @Test
    @DisplayName("Deberia fallar COSTO POR HORA negativo")
    void deberiaFallarCostoPorHoraNegativo() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conCostoHora(-1.0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor que cero");
    }

    @Test
    @DisplayName("Deberia fallar COSTO POR DIA negativo")
    void deberiaFallarCostoPorDiaNegativo() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conCostoDia(-1.0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor que cero");
    }

    @Test
    @DisplayName("Deberia fallar COSTO POR SEMANA negativo")
    void deberiaFallarCostoPorSemanaNegativo() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conCostoSemana(-1.0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor que cero");
    }

}
