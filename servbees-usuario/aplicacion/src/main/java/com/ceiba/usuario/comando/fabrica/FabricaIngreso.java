package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoIngreso;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaIngreso {

    public Usuario crear(ComandoIngreso comandoIngreso) {
        return new Usuario(
                comandoIngreso.getNombre(),
                comandoIngreso.getClave()
        );
    }

}
