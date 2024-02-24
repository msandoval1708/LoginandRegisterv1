package com.apiv1.projectx.modelos.entidades;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "usuarios")

public class CreacionUsuario implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}
