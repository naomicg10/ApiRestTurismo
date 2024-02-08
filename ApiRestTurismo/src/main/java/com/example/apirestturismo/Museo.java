package com.example.apirestturismo;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un museo.
 */
@Data
@Entity
@Table(name="museos")
public class Museo {

    /**
     * Identificador único del museo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del museo.
     */
    private String nombre;

    /**
     * Dirección del museo.
     */
    private String direccion;

    /**
     * URL relacionada con el museo.
     */
    private String url;

    /**
     * Email de contacto relacionado con el museo.
     */
    private String email;

    /**
     * Titularidad del museo.
     */
    private String titularidad;
}