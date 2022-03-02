package com.ceiba.categoria.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class GeneradoresTest {

    @Test
    @DisplayName("Deberia generar una palabra de longitud esperada")
    void deberiaGenerarPalabraLongitudEsperada(){

        final int LONGITUD_ESPERADA = new Random().nextInt(100);

        String generadorPalabra = Generadores.palabra(LONGITUD_ESPERADA);
        assertEquals(LONGITUD_ESPERADA, generadorPalabra.length());
    }

}
