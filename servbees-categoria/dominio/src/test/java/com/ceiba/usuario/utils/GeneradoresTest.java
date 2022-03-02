package com.ceiba.usuario.utils;

import java.util.Random;

public class Generadores {

    public static String palabra(){
        Random r = new Random();

        String resultado = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 50; i++) {
            resultado = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        }

        return resultado;
    }

}
