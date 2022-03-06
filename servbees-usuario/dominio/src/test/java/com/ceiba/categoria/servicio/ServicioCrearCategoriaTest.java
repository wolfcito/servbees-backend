package com.ceiba.categoria.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.categoria.servicio.testdatabuilder.CategoriaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ServicioCrearCategoriaTest {

    @Test
    @DisplayName("Deberia fallar si el costo por dia es menor que el costo por hora")
    void deberiaFallarSiCostoPorDiaMenorQueCostoPorHora() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder()
                .conCostoDia(10.0).conCostoHora(20.0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El valor del COSTO POR DIA no debe ser menor que el valor del COSTO POR HORA");
    }

    @Test
    @DisplayName("Deberia fallar si el costo por semana es menor que el costo por hora")
    void deberiaFallarSiCostoPorSemanaMenorQueCostoPorHora() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder()
                .conCostoSemana(10.0).conCostoHora(20.0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El valor del COSTO POR SEMANA no debe ser menor que el valor del COSTO POR HORA");
    }

    @Test
    @DisplayName("Deberia fallar si el costo por semana es menor que el costo por dia")
    void deberiaFallarSiCostoPorSemanaMenorQueCostoPorDia() {

        //Arrange
        CategoriaTestDataBuilder categoriaTestDataBuilder = new CategoriaTestDataBuilder()
                .conCostoSemana(10.0).conCostoDia(20.0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    categoriaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El valor del COSTO POR SEMANA no debe ser menor que el valor del COSTO POR DIA");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia de una categoria por su codigo")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeCategoriaPorCodigo() {
        // arrange
        Categoria categoria = new CategoriaTestDataBuilder().build();
        RepositorioCategoria repositorioCategoria = Mockito.mock(RepositorioCategoria.class);
        Mockito.when(repositorioCategoria.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCategoria servicioCrearCategoria = new ServicioCrearCategoria(repositorioCategoria);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCategoria.ejecutar(categoria), ExcepcionDuplicidad.class,"El codigo de la categoria ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear una categoria de manera correcta")
    void deberiaCrearUnaCategoriaDeManeraCorrecta() {
        // arrange
        Categoria categoria = new CategoriaTestDataBuilder().build();
        RepositorioCategoria repositorioCategoria = Mockito.mock(RepositorioCategoria.class);
        Mockito.when(repositorioCategoria.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioCategoria.crear(categoria)).thenReturn(7L);
        ServicioCrearCategoria servicioCrearCategoria = new ServicioCrearCategoria(repositorioCategoria);
        // act
        Long idCategoria = servicioCrearCategoria.ejecutar(categoria);
        //- assert
        assertEquals(7L,idCategoria);
        Mockito.verify(repositorioCategoria, Mockito.times(1)).crear(categoria);
    }
}
