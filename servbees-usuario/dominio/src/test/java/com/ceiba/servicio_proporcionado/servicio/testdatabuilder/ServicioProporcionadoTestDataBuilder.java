package com.ceiba.servicio_proporcionado.servicio.testdatabuilder;

import com.ceiba.servicio_proporcionado.modelo.entidad.ServicioProporcionado;

import java.time.LocalDateTime;

public class ServicioProporcionadoTestDataBuilder {


    private Long id;
    private Long idCategoria;
    private Long idUsuarioPro;
    private Long idUsuarioCli;
    private String modalidad;
    private Integer cantidad;
    private Double costo;
    private String nivelSatisfacion;
    private String estado;
    private LocalDateTime fecha;

    public ServicioProporcionadoTestDataBuilder() {
        id = 1L;
        idCategoria = 1L;
        idUsuarioPro = 1L;
        idUsuarioCli = 1L;
        modalidad = "PH";
        cantidad = 1;
        costo = 100.0;
        nivelSatisfacion = "NOR";
        estado = "D";
        fecha = LocalDateTime.now();
    }

    public ServicioProporcionadoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioProporcionadoTestDataBuilder conIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
        return this;
    }

    public ServicioProporcionadoTestDataBuilder conIdUsuarioPro(Long idUsuarioPro) {
        this.idUsuarioPro = idUsuarioPro;
        return this;
    }

    public ServicioProporcionadoTestDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }


    public ServicioProporcionadoTestDataBuilder conCosto(Double costo) {
        this.costo = costo;
        return this;
    }

    public ServicioProporcionadoTestDataBuilder conIdUsuarioCli(Long idUsuarioCli) {
        this.idUsuarioCli = idUsuarioCli;
        return this;
    }


    public ServicioProporcionadoTestDataBuilder conModalidad(String modalidad) {
        this.modalidad = modalidad;
        return this;
    }

    public ServicioProporcionadoTestDataBuilder conNivelSatisfacion(String nivelSatisfacion) {
        this.nivelSatisfacion = nivelSatisfacion;
        return this;
    }

    public ServicioProporcionadoTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public ServicioProporcionadoTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fecha = fechaCreacion;
        return this;
    }


    public ServicioProporcionado buildRegistrar() {
        return new ServicioProporcionado(idCategoria, idUsuarioPro);
    }

    public ServicioProporcionado buildReservar() {
        return new ServicioProporcionado(id, idUsuarioCli, modalidad, cantidad, costo, estado);
    }

    public ServicioProporcionado buildCalificar() {
        return new ServicioProporcionado(id, nivelSatisfacion, estado);
    }
}
