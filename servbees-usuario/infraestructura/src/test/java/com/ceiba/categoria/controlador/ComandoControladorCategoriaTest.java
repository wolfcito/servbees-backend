package com.ceiba.categoria.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.categoria.comando.ComandoCategoria;
import com.ceiba.categoria.servicio.testdatabuilder.ComandoCategoriaTestDataBuilder;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCategoria.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorCategoriaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una categoria")
    void deberiaCrearUnaCategoria() throws Exception{
        // arrange
        ComandoCategoria categoria = new ComandoCategoriaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/categorias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(categoria)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }



    @Test
    @DisplayName("Deberia eliminar una categoria")
    void deberiaEliminarUnaCategoria() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/categorias/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/categorias")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}
