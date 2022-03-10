package com.ceiba.servicio_proporcionado.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoServiciosDisponibles {

    private Long idReserva;
    private Long idUsuarioProveedor;
    private String nombreUsuario;
    private Double costoHora;
    private Double costoDia;
    private Double costoSemana;
    private String nombreCategoria;
    private Long idCategoria;

}
