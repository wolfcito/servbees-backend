package com.ceiba.servicio_proporcionado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;
import com.ceiba.servicio_proporcionado.puerto.repositorio.RepositorioServicioProporcionado;
import com.ceiba.servicio_proporcionado.servicio.testdatabuilder.ServicioProporcionadoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

final class ServicioCalificarServicioProporcionadoTest {

    @Test
    @DisplayName("Deberia Califica correctamente el servicio")
    void deberiaCalificarCorrectamenteElServicio() {
        // arrange
        ServicioProporcionado servicioProporcionado = new ServicioProporcionadoTestDataBuilder().buildCalificar();
        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        Mockito.when(repositorioServicioProporcionado.existePorId(1L,"R")).thenReturn(true);
        ServicioCalificarServicioProporcionado servicioCalificarServicio = new ServicioCalificarServicioProporcionado(repositorioServicioProporcionado);
        // act
        servicioCalificarServicio.ejecutar(servicioProporcionado);
        //- assert
        Mockito.verify(repositorioServicioProporcionado, Mockito.times(1)).calificar(servicioProporcionado);

    }

    @Test
    @DisplayName("Deberia fallar calificar por Servicio NO disponible")
    void deberiaFallarCalificarPorServicioNoDisponible() {
        // arrange
        ServicioProporcionado servicioProporcionado = new ServicioProporcionadoTestDataBuilder().buildCalificar();
        RepositorioServicioProporcionado repositorioServicioProporcionado = Mockito.mock(RepositorioServicioProporcionado.class);
        Mockito.when(repositorioServicioProporcionado.existePorId(1L,"D")).thenReturn(false);
        ServicioCalificarServicioProporcionado servicioCalificarServicio = new ServicioCalificarServicioProporcionado(repositorioServicioProporcionado);
        // act
        //- assert
        BasePrueba.assertThrows(() -> servicioCalificarServicio.ejecutar(servicioProporcionado),
                ExcepcionDuplicidad.class, "El servicio ya no está disponible");
    }

}