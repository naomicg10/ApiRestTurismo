package com.example.apirestturismo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz de repositorio para la entidad Museo.
 * Extiende JpaRepository para obtener operaciones CRUD básicas.
 */
public interface MuseoRepository extends JpaRepository<Museo, Long> {

    /**
     * Obtiene un museo por su ID.
     *
     * @param id ID del museo a buscar.
     * @return El museo encontrado o null si no se encuentra.
     */
    public Museo getMuseosById(Integer id);

    /**
     * Obtiene una lista de museos por su nombre.
     *
     * @param nombre Nombre del museo a buscar.
     * @return Lista de museos encontrados por nombre.
     */
    public List<Museo> getMuseosByNombre(String nombre);

    /**
     * Obtiene una lista de museos por su dirección.
     *
     * @param direccion Dirección del museo a buscar.
     * @return Lista de museos encontrados por dirección.
     */
    public List<Museo> getMuseosByDireccion(String direccion);

    /**
     * Obtiene una lista de museos por su URL.
     *
     * @param ur URL del museo a buscar.
     * @return Lista de museos encontrados por URL.
     */
    public List<Museo> getMuseosByUrl(String ur);

    /**
     * Obtiene una lista de museos por su email.
     *
     * @param email Email del museo a buscar.
     * @return Lista de museos encontrados por email.
     */
    public List<Museo> getMuseosByEmail(String email);

    /**
     * Obtiene una lista de museos por su titularidad.
     *
     * @param titularidad Titularidad del museo a buscar.
     * @return Lista de museos encontrados por titularidad.
     */
    public List<Museo> getMuseosByTitularidad(String titularidad);
}