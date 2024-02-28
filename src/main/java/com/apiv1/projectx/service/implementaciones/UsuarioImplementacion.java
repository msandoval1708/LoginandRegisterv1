package com.apiv1.projectx.service.implementaciones;

import com.apiv1.projectx.modelos.dao.Usuariodao;
import com.apiv1.projectx.modelos.entidades.Usuario;
import com.apiv1.projectx.service.InterfazUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioImplementacion implements InterfazUsuario {

    @Autowired
    private Usuariodao usuariodao;

    @Override
    public List<Usuario> listall() {
        return (List) usuariodao.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuariodao.save(usuario);
    }

    @Override
    public Usuario findById(Integer id) {
        return usuariodao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Usuario usuario) {
        usuariodao.delete(usuario);

    }
}
