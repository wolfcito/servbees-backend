package com.ceiba.servicio_proporcionado.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoServiciosReservados {

    private Long idReserva;
    private Long idUsuarioProveedor;
    private Long idUsuarioCliente;
    private String nombreUsuario;
    private String nombreCategoria;
    private Double costo;
    private Integer cantidad;

}
