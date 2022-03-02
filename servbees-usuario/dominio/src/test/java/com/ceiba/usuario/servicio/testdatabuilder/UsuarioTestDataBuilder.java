package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private String clave;
    private LocalDateTime fecha;
    private Integer mesesExperiencia;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "test";
        clave = "1234";
        fecha = LocalDateTime.now();
        mesesExperiencia = 0;
    }

    public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fecha = fechaCreacion;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public UsuarioTestDataBuilder conExperiencia(Integer mesesExperiencia) {
        this.mesesExperiencia = mesesExperiencia;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombreUsuario, clave,fecha, mesesExperiencia);
    }
}
