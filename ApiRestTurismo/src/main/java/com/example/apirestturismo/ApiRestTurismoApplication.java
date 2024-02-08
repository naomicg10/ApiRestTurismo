package com.example.apirestturismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot para la API REST de turismo.
 */
@SpringBootApplication
public class ApiRestTurismoApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiRestTurismoApplication.class, args);
    }
}