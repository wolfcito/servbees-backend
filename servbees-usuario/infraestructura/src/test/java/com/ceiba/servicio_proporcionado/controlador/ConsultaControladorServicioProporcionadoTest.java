package com.ceiba.servicio_proporcionado.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.servicio_proporcionado.comando.ComandoCalificar;
import com.ceiba.servicio_proporcionado.comando.ComandoRegistrar;
import com.ceiba.servicio_proporcionado.comando.ComandoReservar;
import com.ceiba.servicio_proporcionado.servicio.testdatabuilder.ComandoServicioProporcionadoTestDataBuilder;
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

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorServicioProporcionado.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class ConsultaControladorServicioProporcionadoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia registrar un servicio")
    void deberiaRegistrarUnServicio() throws Exception {
        // arrange
        Long id = 1L;
        ComandoRegistrar registro = new ComandoServicioProporcionadoTestDataBuilder().conIdUsuarioCli(null).buildComandoRegistrar();
        // act - assert

        mocMvc.perform(patch("/servicios/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registro)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia reservar un servicio")
    void deberiaReservarUnServicio() throws Exception {
        // arrange
        Long id = 1L;
        ComandoReservar registro = new ComandoServicioProporcionadoTestDataBuilder()
                .conIdUsuarioCli(1L)
                .conEstado("R")
                .buildComandoReservar();
        // act - assert

        mocMvc.perform(patch("/servicios/{id}/reservar", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registro)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    }
//    @Test
//    @DisplayName("Deberia calificar un servicio")
//    void deberiaCalificarUnServicio() throws Exception {
//        // arrange
//        Long id = 1L;
//        ComandoCalificar registro = new ComandoServicioProporcionadoTestDataBuilder()
//                .conEstado("C")
//                .buildComandoCalificar();
//        // act - assert
//
//        mocMvc.perform(patch("/servicios/{id}/calificar", id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(registro)))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{'valor': 1}"));
//    }

//    @Test
//    @DisplayName("Deberia Buscar los mejores")
//    void deberiaBuscarMejoresUnServicio() throws Exception {
//        // arrange
//        // act - assert
//        mocMvc.perform(get("/servicios/buscar-mejores")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].idCategoria", is(1)))
//                .andExpect(jsonPath("$[0].idUsuarioPro", is(1)))
//                .andExpect(jsonPath("$[0].modalidad", is("sa")))
//                .andExpect(jsonPath("$[0].nivelSatisfacion", is("nor")))
//                .andExpect(jsonPath("$[0].estado", is("s")));
//    }



}
