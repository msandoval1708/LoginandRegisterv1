package com.apiv1.projectx.service;

import com.apiv1.projectx.modelos.entidades.CreacionUsuario;

import java.util.List;

public interface InterfazUsuario {

    List<CreacionUsuario> listall();
    CreacionUsuario save(CreacionUsuario usuario);

    CreacionUsuario findById(Integer id);

    void delete(CreacionUsuario usuario);
}
