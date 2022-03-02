package com.ceiba.usuario.utils;

import java.util.Random;

public class Generadores {

    public static String palabra(int longitud){
        Random r = new Random();

        StringBuilder resultado = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < longitud; i++) {
            resultado.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return resultado.toString();
    }

}
