package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fecha;
    private Integer mesesExperiencia;

    public ComandoUsuarioTestDataBuilder() {
        nombre = "test";//UUID.randomUUID().toString();
        clave = "1234";
        fecha = LocalDateTime.now();
        mesesExperiencia = 0;
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre, clave,fecha, mesesExperiencia);
    }
}
