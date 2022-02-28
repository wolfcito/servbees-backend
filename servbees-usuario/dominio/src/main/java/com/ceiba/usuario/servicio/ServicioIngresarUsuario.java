package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioIngresarUsuario {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario NO existe en el sistema";
    private static final String USUARIO_DUPLICADO_EN_EL_SISTEMA = "Usuario duplicado en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioIngresarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Usuario usuario) {
        return validarExistenciaPrevia(usuario.getNombre(), usuario.getClave());
    }

    private Long validarExistenciaPrevia(String usuario, String clave) {

        Long id= this.repositorioUsuario.idPorUsuarioClave(usuario, clave);
        switch (id.intValue()){
            case -1:
                throw new ExcepcionDuplicidad(USUARIO_DUPLICADO_EN_EL_SISTEMA);
            case 0:
                throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
            default:
                return id;
        }

    }
}
