package com.ceiba.servicio_proporcionado.controlador;

import com.ceiba.ApplicationMock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorServicioProporcionado.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class ConsultaControladorServicioProporcionadoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;



    @Test
    @DisplayName("Deberia listar todos los disponibles")
    void deberiaListarTodosDisponibles() throws Exception {
        // arrange
        // act - assert

        mocMvc.perform(get("/servicios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idReserva", is(3)))
                .andExpect(jsonPath("$[0].idUsuarioProveedor", is(1)))
                .andExpect(jsonPath("$[0].idCategoria", is(1)));
    }

    @Test
    @DisplayName("Deberia Buscar los mejores")
    void deberiaBuscarMejoresUnServicio() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/servicios/buscar-mejores")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idCategoria", is(1)))
                .andExpect(jsonPath("$[0].modalidad", is("PH")))
                .andExpect(jsonPath("$[0].nivelSatisfacion", is("SUP")));
    }

    @Test
    @DisplayName("Deberia listar los reservados por ID")
    void deberiaListarReservadosPorID() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(get("/servicios/{id}/reservados", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idUsuarioProveedor", is(1)))
                .andExpect(jsonPath("$[0].nombreUsuario", is("test")))
                .andExpect(jsonPath("$[0].idUsuarioCliente", is(1)));

    }

}
