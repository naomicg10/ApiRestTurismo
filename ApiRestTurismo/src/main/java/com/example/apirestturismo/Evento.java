package com.example.apirestturismo;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un evento turístico.
 */
@Data
@Entity
@Table(name="eventos")
public class Evento {

    /**
     * Identificador único del evento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del evento.
     */
    private String nombre;

    /**
     * Descripción del evento.
     */
    private String descripcion;

    /**
     * Fecha del evento.
     */
    private String fecha;

    /**
     * Lugar del evento.
     */
    private String lugar;

    /**
     * Dirección del evento.
     */
    private String direccion;

    /**
     * URL relacionada con el evento.
     */
    private String url;

    /**
     * Email de contacto relacionado con el evento.
     */
    private String email;

    /**
     * Categoría del evento.
     */
    private String categoria;

    /**
     * Precio del evento.
     */
    private Double precio;
}