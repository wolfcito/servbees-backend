package com.ceiba.servicio_proporcionado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.puerto.repositorio.RepositorioServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.testdatabuilder.ServicioProporcionadoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

final class ServicioReservarServicioProporcionadoTest {

    @Test
    @DisplayName("Deberia reservar correctamente el servicio")
    void deberiaReservarCorrectamenteElServicio() {
        // arrange
        ServicioProporcionado servicioProporcionado = new ServicioProporcionadoTestDataBuilder().buildReservar();
        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        Mockito.when(repositorioServicioProporcionado.existePorId(1L,"D")).thenReturn(true);
        ServicioReservarServicioProporcionado servicioreservarServicio = new ServicioReservarServicioProporcionado(repositorioServicioProporcionado);
        // act
        servicioreservarServicio.ejecutar(servicioProporcionado);
        //- assert
        Mockito.verify(repositorioServicioProporcionado, Mockito.times(1)).reservar(servicioProporcionado);

    }

    @Test
    @DisplayName("Deberia fallar resgistrar por Servicio NO disponible")
    void deberiaFallarResgistrarPorServicioNoDisponible() {
        // arrange
        ServicioProporcionado servicioProporcionado = new ServicioProporcionadoTestDataBuilder().buildReservar();
        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        Mockito.when(repositorioServicioProporcionado.existePorId(1L,"C")).thenReturn(false);
        ServicioReservarServicioProporcionado servicioreservarServicio = new ServicioReservarServicioProporcionado(repositorioServicioProporcionado);
        // act
        //- assert
        BasePrueba.assertThrows(() -> servicioreservarServicio.ejecutar(servicioProporcionado),
                ExcepcionDuplicidad.class, "El servicio ya no está disponible");
    }
}