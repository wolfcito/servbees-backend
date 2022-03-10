package com.ceiba.servicio_proporcionado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.puerto.repositorio.RepositorioServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.testdatabuilder.ServicioProporcionadoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

final class ServicioRegistrarServicioProporcionadoTest {

    @Test
    @DisplayName("Deberia registrar correctamente el ser servicio")
    void deberiaResgistrarCorrectamenteElServicio() {
        // arrange
        ServicioProporcionado servicioProporcionado = new ServicioProporcionadoTestDataBuilder().buildRegistrar();
        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        Mockito.when(repositorioServicioProporcionado.registrar(servicioProporcionado)).thenReturn(7L);
        ServicioRegistrarServicioProporcionado servicioRegistrarServicio = new ServicioRegistrarServicioProporcionado(repositorioServicioProporcionado);
        // act
        Long idUsuario = servicioRegistrarServicio.ejecutar(servicioProporcionado);
        //- assert
        assertEquals(7L, idUsuario);
        Mockito.verify(repositorioServicioProporcionado, Mockito.times(1)).registrar(servicioProporcionado);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la inexistencia del ID CATEGORIA")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelIdCategoria() {
        // arrange
        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdCategoria(null);

        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        ServicioRegistrarServicioProporcionado servicioRegistrarServicio = new ServicioRegistrarServicioProporcionado(repositorioServicioProporcionado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRegistrarServicio.ejecutar(servicioProporcionadoBuilder.buildRegistrar()),
                ExcepcionValorObligatorio.class, "Se debe ingresar el ID de Categoria");

    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la inexistencia del ID PROVEEDOR")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelIdProveedor() {
        // arrange
        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdUsuarioPro(null);

        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        ServicioRegistrarServicioProporcionado servicioRegistrarServicio = new ServicioRegistrarServicioProporcionado(repositorioServicioProporcionado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRegistrarServicio.ejecutar(servicioProporcionadoBuilder.buildRegistrar()),
                ExcepcionValorObligatorio.class, "Se debe ingresar el ID de Proveedor");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando ID PROVEEDOR sea negativo")
    void deberiaLanzarUnaExepcionCuandoIdProveedorNegativo() {
        // arrange
        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdUsuarioPro(-1L);

        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        ServicioRegistrarServicioProporcionado servicioRegistrarServicio = new ServicioRegistrarServicioProporcionado(repositorioServicioProporcionado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRegistrarServicio.ejecutar(servicioProporcionadoBuilder.buildRegistrar()),
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando ID CATEGORIA sea negativo")
    void deberiaLanzarUnaExepcionCuandoIdCategoriaNegativo() {
        // arrange
        ServicioProporcionadoTestDataBuilder servicioProporcionadoBuilder = new ServicioProporcionadoTestDataBuilder()
                .conIdCategoria(-1L);

        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        ServicioRegistrarServicioProporcionado servicioRegistrarServicio = new ServicioRegistrarServicioProporcionado(repositorioServicioProporcionado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRegistrarServicio.ejecutar(servicioProporcionadoBuilder.buildRegistrar()),
                ExcepcionValorInvalido.class, "Se debe ingresar un número mayor o igual que cero");
    }

}