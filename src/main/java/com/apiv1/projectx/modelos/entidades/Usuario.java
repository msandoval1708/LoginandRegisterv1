package com.apiv1.projectx.modelos.entidades;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String nombre;


    private String apellido;


    private String email;


    private String contraseña;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}
