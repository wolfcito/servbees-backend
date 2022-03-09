package com.ceiba.servicio_proporcionado.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoServicioProporcionado {

//    private Long id;
    private Long idCategoria;
    private Long idUsuarioPro;
    private Long idUsuarioCli;
    private String modalidad;
    private Integer cantidad;
    private Double costo;
    private String nivelSatisfacion;
    private String estado;
    private LocalDateTime fecha;

}
