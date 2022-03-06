package com.ceiba.categoria.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCategoria {

    private Long id;
    private String nombre;
    private String codigo;
    private Double costoHora;
    private Double costoDia;
    private Double costoSemana;

}
