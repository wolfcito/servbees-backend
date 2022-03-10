package com.ceiba.categoria.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Categoria {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CATEGORIA = "Se debe ingresar el nombre de categoria";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO = "Se debe ingresar el codigo";
    private static final String SE_DEBE_INGRESAR_VALOR_MAYOR_QUE_CERO = "Se debe ingresar un número mayor que cero";
    private static final String EL_VALOR_NO_DEBE_SER_MENOR_QUE = "El valor del %s no debe ser menor que el valor del %s";

    private static final String VALOR_NOMBRE = "NOMBRE";
    private static final String VALOR_CODIGO = "CODIGO";
    private static final String COSTO_POR_HORA = "COSTO POR HORA";
    private static final String COSTO_POR_DIA = "COSTO POR DIA";
    private static final String COSTO_POR_SEMANA = "COSTO POR SEMANA";
    private static final String LONGITUD_MAXIMA_EXCEDIDA_PARA = "Longitud maxima excedida para %s es de %s caracteres";

    private static final int LONGITUD_MAX_NOMBRE = 100;
    private static final int LONGITUD_MAX_CODIGO = 5;

    private Long id;
    private String nombre;
    private String codigo;
    private Double costoHora;
    private Double costoDia;
    private Double costoSemana;

    public Categoria(Long id, String nombre, String codigo, Double costoHora, Double costoDia,Double costoSemana) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CATEGORIA);
        validarLongitudMaxima(nombre, LONGITUD_MAX_NOMBRE, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, VALOR_NOMBRE, LONGITUD_MAX_NOMBRE));
        validarObligatorio(codigo, SE_DEBE_INGRESAR_EL_CODIGO);
        validarLongitudMaxima(codigo, LONGITUD_MAX_CODIGO, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, VALOR_CODIGO, LONGITUD_MAX_CODIGO));
        validarPositivo(costoHora, SE_DEBE_INGRESAR_VALOR_MAYOR_QUE_CERO);
        validarPositivo(costoDia, SE_DEBE_INGRESAR_VALOR_MAYOR_QUE_CERO);
        validarPositivo(costoSemana, SE_DEBE_INGRESAR_VALOR_MAYOR_QUE_CERO);
        validarMenor(costoHora.longValue(), costoDia.longValue(), String.format(EL_VALOR_NO_DEBE_SER_MENOR_QUE, COSTO_POR_DIA, COSTO_POR_HORA));
        validarMenor(costoHora.longValue(), costoSemana.longValue(), String.format(EL_VALOR_NO_DEBE_SER_MENOR_QUE, COSTO_POR_SEMANA, COSTO_POR_HORA));
        validarMenor(costoDia.longValue(), costoSemana.longValue(), String.format(EL_VALOR_NO_DEBE_SER_MENOR_QUE, COSTO_POR_SEMANA, COSTO_POR_DIA));

        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.costoHora = costoHora;
        this.costoDia = costoDia;
        this.costoSemana = costoSemana;

    }

}
