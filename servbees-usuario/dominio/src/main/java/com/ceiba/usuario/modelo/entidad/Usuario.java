package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LOS_MESES_DE_EXPERIENCIA = "Se debe ingresar los meses de experiencia";
    private static final String SE_DEBE_INGRESAR_VALOR_MAYOR_O_IGUAL_QUE_CERO = "Se debe ingresar un número mayor o igual que cero";

    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;
    private Integer mesesExperiencia;

    public Usuario(Long id,String nombre, String clave,LocalDateTime fechaCreacion, Integer mesesExperiencia) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(clave, SE_DEBE_INGRESAR_LA_CLAVE);
        validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(mesesExperiencia, SE_DEBE_INGRESAR_LOS_MESES_DE_EXPERIENCIA);
        validarPositivo(Double.valueOf(mesesExperiencia), SE_DEBE_INGRESAR_VALOR_MAYOR_O_IGUAL_QUE_CERO);

        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.fechaCreacion = fechaCreacion;
        this.mesesExperiencia = mesesExperiencia;
    }

    public Usuario(String nombre, String clave) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(clave, SE_DEBE_INGRESAR_LA_CLAVE);
        validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));

        this.nombre = nombre;
        this.clave = clave;
    }

}
