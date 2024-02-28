package com.apiv1.projectx.modelos.dao;

import com.apiv1.projectx.modelos.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface Usuariodao extends CrudRepository<Usuario, Integer> {
}
