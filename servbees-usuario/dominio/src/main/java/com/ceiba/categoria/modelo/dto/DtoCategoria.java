package com.ceiba.categoria.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCategoria {

//    private Long id;
    private String nombre;
    private String codigo;
    private Double costoHora;
    private Double costoDia;
    private Double costoSemana;

}
