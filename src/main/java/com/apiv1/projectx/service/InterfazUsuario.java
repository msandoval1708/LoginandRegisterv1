package com.apiv1.projectx.service;

import com.apiv1.projectx.modelos.entidades.Usuario;

import java.util.List;

public interface InterfazUsuario {

    List<Usuario> listall();
    Usuario save(Usuario usuario);

    Usuario findById(Integer id);

    void delete(Usuario usuario);
}
