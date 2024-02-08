package com.example.apirestturismo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz de repositorio para la entidad Evento.
 * Extiende JpaRepository para obtener operaciones CRUD básicas.
 */
public interface EventoRepository extends JpaRepository<Evento, Long> {

    /**
     * Obtiene un evento por su ID.
     *
     * @param id ID del evento a buscar.
     * @return El evento encontrado o null si no se encuentra.
     */
    public Evento getEventosById(Integer id);

    /**
     * Obtiene una lista de eventos por su nombre.
     *
     * @param nombre Nombre del evento a buscar.
     * @return Lista de eventos encontrados por nombre.
     */
    public List<Evento> getEventosByNombre(String nombre);

    /**
     * Obtiene una lista de eventos por su descripción.
     *
     * @param descripcion Descripción del evento a buscar.
     * @return Lista de eventos encontrados por descripción.
     */
    public List<Evento> getEventosByDescripcion(String descripcion);

    /**
     * Obtiene una lista de eventos por su fecha.
     *
     * @param fecha Fecha del evento a buscar.
     * @return Lista de eventos encontrados por fecha.
     */
    public List<Evento> getEventosByFecha(String fecha);

    /**
     * Obtiene una lista de eventos por su lugar.
     *
     * @param lugar Lugar del evento a buscar.
     * @return Lista de eventos encontrados por lugar.
     */
    public List<Evento> getEventosByLugar(String lugar);

    /**
     * Obtiene una lista de eventos por su dirección.
     *
     * @param direccion Dirección del evento a buscar.
     * @return Lista de eventos encontrados por dirección.
     */
    public List<Evento> getEventosByDireccion(String direccion);

    /**
     * Obtiene una lista de eventos por su URL.
     *
     * @param url URL del evento a buscar.
     * @return Lista de eventos encontrados por URL.
     */
    public List<Evento> getEventosByUrl(String url);

    /**
     * Obtiene una lista de eventos por su email.
     *
     * @param email Email del evento a buscar.
     * @return Lista de eventos encontrados por email.
     */
    public List<Evento> getEventosByEmail(String email);

    /**
     * Obtiene una lista de eventos por su categoría.
     *
     * @param categoria Categoría del evento a buscar.
     * @return Lista de eventos encontrados por categoría.
     */
    public List<Evento> getEventosByCategoria(String categoria);

    /**
     * Obtiene una lista de eventos por su precio.
     *
     * @param precio Precio del evento a buscar.
     * @return Lista de eventos encontrados por precio.
     */
    public List<Evento> getEventosByPrecio(Double precio);
}