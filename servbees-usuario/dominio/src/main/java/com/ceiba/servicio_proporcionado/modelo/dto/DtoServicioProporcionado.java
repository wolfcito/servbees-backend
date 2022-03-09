package com.ceiba.servicio_proporcionado.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoServicioProporcionado {

    private String nombreUsuario;
    private Integer experiencia;
    private String nombreCategoria;
    private String nivelSatisfacion;
    private String modalidad;

}
