package com.ceiba.servicio_proporcionado.modelo.entidad;


import com.ceiba.servicio_proporcionado.modelo.Estados;
import com.ceiba.servicio_proporcionado.modelo.Modalidades;
import com.ceiba.servicio_proporcionado.modelo.NivelesSatisfacion;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Arrays;

import static com.ceiba.dominio.ValidadorArgumento.*;


@Getter
public class ServicioProporcionado {

    private static final String SE_DEBE_INGRESAR_ID_CATEGORIA = "Se debe ingresar el ID de Categoria";
    private static final String SE_DEBE_INGRESAR_ID_PROVEEDOR = "Se debe ingresar el ID de Proveedor";
    private static final String SE_DEBE_INGRESAR_COSTO = "Se debe ingresar el costo";
    private static final String SE_DEBE_INGRESAR_VALOR_MAYOR_O_IGUAL_QUE_CERO = "Se debe ingresar un número mayor o igual que cero";
    private static final String LONGITUD_MAXIMA_EXCEDIDA_PARA = "Longitud maxima excedida para %s es de %s caracteres";
    private static final String SE_DEBE_INGRESAR_VALOR_LISTA = "Se debe ingresar un valor de la lista: %s";

    private static final String MODALIDAD = "MODALIDAD";
    private static final String NIVEL_SATISFACCION = "NIVEL SATISFACCION";
    private static final String ESTADO = "ESTADO";

    private static final int LONGITUD_MAX_MODALIDAD = 2;
    private static final int LONGITUD_MAX_NIVEL_SATISFACCION = 3;
    private static final int LONGITUD_MAX_ESTADO = 1;

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

    //    REGISTRAR
    public ServicioProporcionado(Long idCategoria, Long idUsuarioPro) {
        validarObligatorio(idCategoria, SE_DEBE_INGRESAR_ID_CATEGORIA);
        validarObligatorio(idUsuarioPro, SE_DEBE_INGRESAR_ID_PROVEEDOR);

        this.idCategoria = idCategoria;
        this.idUsuarioPro = idUsuarioPro;
    }

    //RESERVAR
    public ServicioProporcionado(Long id,Long idUsuarioCli,
                                 String modalidad, Integer cantidad, Double costo,
                                 String estado) {
        validarObligatorio(costo, SE_DEBE_INGRESAR_COSTO);
        validarLongitudMaxima(modalidad, LONGITUD_MAX_MODALIDAD, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, MODALIDAD, LONGITUD_MAX_MODALIDAD));
        validarLongitudMaxima(estado, LONGITUD_MAX_ESTADO, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, ESTADO, LONGITUD_MAX_ESTADO));
        validarPositivo(Double.valueOf(cantidad), SE_DEBE_INGRESAR_VALOR_MAYOR_O_IGUAL_QUE_CERO);
        validarPositivo(costo, SE_DEBE_INGRESAR_VALOR_MAYOR_O_IGUAL_QUE_CERO);

        validarValido(modalidad,Modalidades.class,String.format(SE_DEBE_INGRESAR_VALOR_LISTA, Arrays.asList(Modalidades.values())));
        validarValido(estado, Estados.class,String.format(SE_DEBE_INGRESAR_VALOR_LISTA, Arrays.asList(Estados.values())));

        this.id = id;
        this.idUsuarioCli = idUsuarioCli;
        this.modalidad = modalidad;
        this.cantidad = cantidad;
        this.costo = costo;
        this.estado = estado;
        this.fecha =  LocalDateTime.now();
    }

    //    CALIFICAR
    public ServicioProporcionado(Long id,String nivelSatisfacion, String estado) {
        validarLongitudMaxima(nivelSatisfacion, LONGITUD_MAX_NIVEL_SATISFACCION, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, NIVEL_SATISFACCION, LONGITUD_MAX_NIVEL_SATISFACCION));
        validarLongitudMaxima(estado, LONGITUD_MAX_ESTADO, String.format(LONGITUD_MAXIMA_EXCEDIDA_PARA, ESTADO, LONGITUD_MAX_ESTADO));
        validarValido(nivelSatisfacion, NivelesSatisfacion.class,String.format(SE_DEBE_INGRESAR_VALOR_LISTA, Arrays.asList(NivelesSatisfacion.values())));
        validarValido(estado,Estados.class,String.format(SE_DEBE_INGRESAR_VALOR_LISTA, Arrays.asList(Estados.values())));

        this.id = id;
        this.nivelSatisfacion = nivelSatisfacion;
        this.estado = estado;
        this.fecha =  LocalDateTime.now();
    }

}
