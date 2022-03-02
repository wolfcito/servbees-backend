package com.ceiba.categoria.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.servicio.testdatabuilder.CategoriaTestDataBuilder;
import com.ceiba.categoria.utils.Generadores;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class CategoriaTest {

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
    void deberiaFallarExcedeLongitudDeNombreDeCategoria() {

        final int LONGITUD_MAXIMA = 100;
        String nombreInvalida = Generadores.palabra(LONGITUD_MAXIMA+1);
        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conNombre(nombreInvalida).conId(1L);
        //act-assert
        BasePrueba.assertThrows(categoriaTestDataBuilder::build,
                ExcepcionLongitudValor.class, String.format("Longitud maxima excedida para NOMBRE es de %s caracteres", LONGITUD_MAXIMA));
    }

    @Test
    void deberiaFallarExcedeLongitudDeCodigoDeCategoria() {

        final int LONGITUD_MAXIMA = 5;
        String nombreInvalida = Generadores.palabra(LONGITUD_MAXIMA+1);
        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conCodigo(nombreInvalida).conId(1L);
        //act-assert
        BasePrueba.assertThrows(categoriaTestDataBuilder::build,
                ExcepcionLongitudValor.class, String.format("Longitud maxima excedida para CODIGO es de %s caracteres", LONGITUD_MAXIMA));
    }

    @Test
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
    void deberiaFallarSinCcodigo() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder().conCodigo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el codigo");
    }

    @Test
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
