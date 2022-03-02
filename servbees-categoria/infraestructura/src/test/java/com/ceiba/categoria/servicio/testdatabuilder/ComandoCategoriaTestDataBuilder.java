package com.ceiba.categoria.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoCategoria;

import java.util.UUID;

public class ComandoCategoriaTestDataBuilder {

    private Long id;
    private String nombre;
    private String codigo;
    private Double costoHora;
    private Double costoDia;
    private Double costoSemana;

    public ComandoCategoriaTestDataBuilder() {
        this.nombre = "Categoria"+ UUID.randomUUID().toString();
        this.codigo = "CATX";
        this.costoHora = 10.0;
        this.costoDia = 20.0;
        this.costoSemana = 30.0;
    }

    public ComandoCategoriaTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ComandoCategoriaTestDataBuilder conCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    public ComandoCategoriaTestDataBuilder conCostoHora(Double costoHora){
        this.costoHora = costoHora;
        return this;
    }

    public ComandoCategoriaTestDataBuilder conCostoDia(Double costoDia){
        this.costoDia = costoDia;
        return this;
    }
    public ComandoCategoriaTestDataBuilder conCostoSemana(Double costoSemana){
        this.costoSemana = costoSemana;
        return this;
    }

    public ComandoCategoria build() {
        return new ComandoCategoria(id,nombre,codigo, costoHora, costoDia, costoSemana);
    }
}
