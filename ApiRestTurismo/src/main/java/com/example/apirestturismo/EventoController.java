package com.example.apirestturismo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar operaciones relacionadas con los eventos.
 */
@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SecurityService security;

    // Métodos de lectura

    /**
     * Obtiene todos los eventos.
     *
     * @return ResponseEntity con la lista de todos los eventos y HttpStatus OK.
     */
    @GetMapping("/get/")
    public ResponseEntity<List<Evento>> getEventos() {
        return new ResponseEntity<>(eventoRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Obtiene un evento por su ID.
     *
     * @param id ID del evento a buscar.
     * @return ResponseEntity con el evento encontrado y HttpStatus OK, o HttpStatus NOT_FOUND si no se encuentra.
     */
    @GetMapping("/getId/{id}")
    public ResponseEntity<Evento> getId(@PathVariable Integer id){
        return new ResponseEntity<>( eventoRepository.getEventosById(id), HttpStatus.OK );
    }

    /**
     * Obtiene eventos por su nombre.
     *
     * @param nombre Nombre del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getNombre/{nombre}")
    public ResponseEntity<List<Evento>> getNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(eventoRepository.getEventosByNombre(nombre), HttpStatus.OK);
    }

    /**
     * Obtiene eventos por su descripción.
     *
     * @param descripcion Descripción del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getDescripcion/{descripcion}")
    public ResponseEntity<List<Evento>> getDescripcion(@PathVariable String descripcion) {
        return new ResponseEntity<>(eventoRepository.getEventosByDescripcion(descripcion), HttpStatus.OK);
    }

    /**
     * Obtiene eventos por su fecha.
     *
     * @param fecha Fecha del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getFecha/{fecha}")
    public ResponseEntity<List<Evento>> getFecha(@PathVariable String fecha) {
        return new ResponseEntity<>(eventoRepository.getEventosByFecha(fecha), HttpStatus.OK);
    }

    /**
     * Obtiene eventos por su lugar.
     *
     * @param lugar Lugar del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getLugar/{lugar}")
    public ResponseEntity<List<Evento>> getLugar(@PathVariable String lugar) {
        return new ResponseEntity<>(eventoRepository.getEventosByLugar(lugar), HttpStatus.OK);
    }

    /**
     * Obtiene eventos por su dirección.
     *
     * @param direccion Dirección del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getDireccion/{direccion}")
    public ResponseEntity<List<Evento>> getDireccion(@PathVariable String direccion) {
        return new ResponseEntity<>(eventoRepository.getEventosByDireccion(direccion), HttpStatus.OK);
    }

    /**
     * Obtiene eventos por su URL.
     *
     * @param url URL del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getUrl/{url}")
    public ResponseEntity<List<Evento>> getUrl(@PathVariable String url) {
        return new ResponseEntity<>(eventoRepository.getEventosByUrl(url), HttpStatus.OK);
    }

    /**
     * Obtiene eventos por su email.
     *
     * @param email Email del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getEmail/{email}")
    public ResponseEntity<List<Evento>> getEmail(@PathVariable String email) {
        return new ResponseEntity<>(eventoRepository.getEventosByEmail(email), HttpStatus.OK);
    }

    /**
     * Obtiene eventos por su categoría.
     *
     * @param categoria Categoría del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getCategoria/{categoria}")
    public ResponseEntity<List<Evento>> getCategoria(@PathVariable String categoria) {
        return new ResponseEntity<>(eventoRepository.getEventosByCategoria(categoria), HttpStatus.OK);
    }

    /**
     * Obtiene eventos por su precio.
     *
     * @param precio Precio del evento a buscar.
     * @return ResponseEntity con la lista de eventos encontrados y HttpStatus OK.
     */
    @GetMapping("/getPrecio/{precio}")
    public ResponseEntity<List<Evento>> getPrecio(@PathVariable Double precio) {
        return new ResponseEntity<>(eventoRepository.getEventosByPrecio(precio), HttpStatus.OK);
    }

    // Métodos de escritura

    /**
     * Crea un nuevo evento.
     *
     * @param evento Evento a crear.
     * @param email Correo electrónico del usuario que realiza la operación.
     * @param token Token de autenticación del usuario.
     * @return ResponseEntity con un mensaje de éxito si se crea el evento, o null si la autenticación falla.
     */
    @PostMapping("/post/{email}")
    public ResponseEntity<String> nuevoEvento(@RequestBody Evento evento, @PathVariable String email, @RequestParam String token) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && security.validateToken(email, token)) {
            eventoRepository.save(evento);
            return new ResponseEntity<>("Evento creado con éxito", HttpStatus.CREATED);
        }
        return null;
    }

    /**
     * Actualiza un evento existente.
     *
     * @param id ID del evento a actualizar.
     * @param email Correo electrónico del usuario que realiza la operación.
     * @param eventoActualizado Datos actualizados del evento.
     * @param token Token de autenticación del usuario.
     * @return ResponseEntity con el evento actualizado y HttpStatus OK, o HttpStatus UNAUTHORIZED si la autenticación falla,
     * o HttpStatus NOT_FOUND si el evento no existe.
     */
    @PutMapping("/put/{id}/{email}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable Long id, @PathVariable String email, @RequestBody Evento eventoActualizado, @RequestParam String token) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario == null && !security.validateToken(email, token) ){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            var evento = new Evento();
            var optionalEvento = eventoRepository.findById(id);
            if (optionalEvento.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                evento = optionalEvento.get();
                evento.setNombre(eventoActualizado.getNombre());
                evento.setDescripcion(eventoActualizado.getDescripcion());
                evento.setFecha(eventoActualizado.getFecha());
                evento.setLugar(eventoActualizado.getLugar());
                evento.setDireccion(eventoActualizado.getDireccion());
                evento.setUrl(eventoActualizado.getUrl());
                evento.setEmail(eventoActualizado.getEmail());
                evento.setCategoria(eventoActualizado.getCategoria());
                evento.setPrecio(eventoActualizado.getPrecio());
            }
            return new ResponseEntity<Evento>(eventoRepository.save(evento),HttpStatus.OK);
        }
    }

    /**
     * Elimina un evento.
     *
     * @param id ID del evento a eliminar.
     * @param email Correo electrónico del usuario que realiza la operación.
     * @param token Token de autenticación del usuario.
     * @return ResponseEntity con un mensaje de éxito si se elimina el evento, o HttpStatus UNAUTHORIZED si la autenticación falla.
     */
    @DeleteMapping("/delete/{id}/{email}")
    public ResponseEntity<String> borrarEvento(@PathVariable Long id, @PathVariable String email, @RequestParam String token) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario!=null && security.validateToken(email, token))
            eventoRepository.deleteById(id);
        return new ResponseEntity<>("Evento eliminado correctamente", HttpStatus.OK);
    }
}