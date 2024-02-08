package com.example.apirestturismo;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un usuario en el sistema.
 */
@Data
@Entity
@Table(name="usuario")
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Correo electrónico del usuario.
     */
    private String email;

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Apellido del usuario.
     */
    private String apellido;

    /**
     * Contraseña del usuario.
     */
    private String contraseña;

    /**
     * Token de seguridad del usuario.
     */
    private String token;
}