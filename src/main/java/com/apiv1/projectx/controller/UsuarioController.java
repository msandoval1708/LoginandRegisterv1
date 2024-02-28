package com.apiv1.projectx.controller;

import com.apiv1.projectx.modelos.Payload.MensajesResponse;
import com.apiv1.projectx.modelos.entidades.Usuario;
import com.apiv1.projectx.service.InterfazUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private InterfazUsuario usuarioservicio;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MensajesResponse> showAll() {
        try {
            List<Usuario> userList = usuarioservicio.listall();

            if (userList.isEmpty()) {
                return new ResponseEntity<>(MensajesResponse.builder()
                        .mensaje("No se encontraron usuarios")
                        .objeto(null)
                        .build(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(MensajesResponse.builder()
                        .mensaje("Usuarios recuperados exitosamente")
                        .objeto(userList)
                        .build(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al recuperar usuarios")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("creacion")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MensajesResponse> create(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioservicio.save(usuario);
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Usuario creado exitosamente")
                    .objeto(nuevoUsuario)
                    .build(), HttpStatus.CREATED);
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al crear el usuario")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("actualizar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MensajesResponse> update(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioActualizado = usuarioservicio.save(usuario);
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Usuario actualizado exitosamente")
                    .objeto(usuarioActualizado)
                    .build(), HttpStatus.OK);
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al actualizar el usuario")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("usuario/{id}")
    public ResponseEntity<MensajesResponse> delete(@PathVariable Integer id) {
        try {
            Usuario usuarioDelete = usuarioservicio.findById(id);
            usuarioservicio.delete(usuarioDelete);
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Usuario eliminado exitosamente")
                    .objeto(usuarioDelete)
                    .build(), HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al eliminar el usuario")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MensajesResponse> showById(@PathVariable Integer id) {
        try {
            Usuario usuario = usuarioservicio.findById(id);
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Usuario obtenido exitosamente")
                    .objeto(usuario)
                    .build(), HttpStatus.OK);
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al obtener el usuario")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

