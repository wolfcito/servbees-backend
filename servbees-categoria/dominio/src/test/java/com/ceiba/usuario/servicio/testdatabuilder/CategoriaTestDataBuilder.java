package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Categoria;

public class CategoriaTestDataBuilder {

    private Long id;
    private String nombre;
    private String codigo;
    private Double costoHora;
    private Double costoDia;
    private Double costoSemana;

    public CategoriaTestDataBuilder() {
        this.nombre = "Categoria";
        this.codigo = "CAT";
        this.costoHora = 10.0;
        this.costoDia = 20.0;
        this.costoSemana = 30.0;
    }

    public CategoriaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CategoriaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CategoriaTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public CategoriaTestDataBuilder conCostoHora(Double costoHora) {
        this.costoHora = costoHora;
        return this;
    }

    public CategoriaTestDataBuilder conCostoDia(Double costoDia) {
        this.costoDia = costoDia;
        return this;
    }

    public CategoriaTestDataBuilder conCostoSemana(Double costoSemana) {
        this.costoSemana = costoSemana;
        return this;
    }

    public Categoria build() {
        return new Categoria(id, nombre, codigo, costoHora, costoDia, costoSemana);
    }
}
