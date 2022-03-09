package com.ceiba.servicio_proporcionado.servicio.testdatabuilder;

import com.ceiba.servicio_proporcionado.comando.ComandoCalificar;
import com.ceiba.servicio_proporcionado.comando.ComandoRegistrar;
import com.ceiba.servicio_proporcionado.comando.ComandoReservar;

import java.time.LocalDateTime;

public class ComandoServicioProporcionadoTestDataBuilder {

    private Long idCategoria;
    private Long idUsuarioPro;
    private Long idUsuarioCli;
    private String modalidad;
    private Integer cantidad;
    private Double costo;
    private String nivelSatisfacion;
    private String estado;
    private LocalDateTime fecha;

    public ComandoServicioProporcionadoTestDataBuilder() {

        idCategoria = 1L;
        idUsuarioPro = 1L;
        idUsuarioCli = 2L;
        modalidad = "sa";
        cantidad = 1;
        costo = 10.0;
        nivelSatisfacion = "nor";
        estado = "s";
        fecha = LocalDateTime.now();
    }

    public ComandoServicioProporcionadoTestDataBuilder conIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
        return this;
    }
    public ComandoServicioProporcionadoTestDataBuilder conIdUsuarioPro(Long idUsuarioPro) {
        this.idUsuarioPro = idUsuarioPro;
        return this;
    }
    public ComandoServicioProporcionadoTestDataBuilder conIdUsuarioCli(Long idUsuarioCli) {
        this.idUsuarioCli = idUsuarioCli;
        return this;
    }
    public ComandoServicioProporcionadoTestDataBuilder conModalidad(String modalidad) {
        this.modalidad = modalidad;
        return this;
    }
    public ComandoServicioProporcionadoTestDataBuilder conSatisfaccion(String nivelSatisfacion) {
        this.nivelSatisfacion = nivelSatisfacion;
        return this;
    }
    public ComandoServicioProporcionadoTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public ComandoServicioProporcionadoTestDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }
    public ComandoServicioProporcionadoTestDataBuilder conCosto(Double costo) {
        this.costo = costo;
        return this;
    }
    public ComandoServicioProporcionadoTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }
    public ComandoRegistrar buildComandoRegistrar() {
        return new ComandoRegistrar(idCategoria, idUsuarioPro);
    }

    public ComandoCalificar buildComandoCalificar() {
        return new ComandoCalificar(nivelSatisfacion, estado);
    }

    public ComandoReservar buildComandoReservar() {
        return new ComandoReservar(idUsuarioCli, modalidad, cantidad, costo, estado);
    }
}
