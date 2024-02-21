package com.example.apirestturismo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar operaciones relacionadas con los museos.
 */
@RestController
@RequestMapping("/museos")
public class MuseoController {
    @Autowired
    private MuseoRepository museoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SecurityService security;

    // Métodos de lectura

    /**
     * Obtiene todos los museos.
     *
     * @return ResponseEntity con la lista de todos los museos y HttpStatus OK.
     */
    @GetMapping("/get/")
    public ResponseEntity<List<Museo>> getMuseos() {
        return new ResponseEntity<>(museoRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Obtiene un museo por su ID.
     *
     * @param id ID del museo a buscar.
     * @return ResponseEntity con el museo encontrado y HttpStatus OK, o HttpStatus NOT_FOUND si no se encuentra.
     */
    @GetMapping("/getId/{id}")
    public ResponseEntity<Museo> getId(@PathVariable Integer id){
        return new ResponseEntity<>( museoRepository.getMuseosById(id), HttpStatus.OK );
    }

    /**
     * Obtiene museos por su nombre.
     *
     * @param nombre Nombre del museo a buscar.
     * @return ResponseEntity con la lista de museos encontrados y HttpStatus OK.
     */
    @GetMapping("/getNombre/{nombre}")
    public ResponseEntity<List<Museo>> getNombre (@PathVariable String nombre){
        return new ResponseEntity<>(museoRepository.getMuseosByNombre(nombre), HttpStatus.OK);
    }

    /**
     * Obtiene museos por su dirección.
     *
     * @param direccion Dirección del museo a buscar.
     * @return ResponseEntity con la lista de museos encontrados y HttpStatus OK.
     */
    @GetMapping("/getDireccion/{direccion}")
    public ResponseEntity<List<Museo>> getDireccion (@PathVariable String direccion){
        return new ResponseEntity<>(museoRepository.getMuseosByDireccion(direccion), HttpStatus.OK);
    }

    /**
     * Obtiene museos por su URL.
     *
     * @param url URL del museo a buscar.
     * @return ResponseEntity con la lista de museos encontrados y HttpStatus OK.
     */
    @GetMapping("/getUrl/{url}")
    public ResponseEntity<List<Museo>> getUrl (@PathVariable String url){
        return new ResponseEntity<>(museoRepository.getMuseosByUrl(url), HttpStatus.OK);
    }

    /**
     * Obtiene museos por su email.
     *
     * @param email Email del museo a buscar.
     * @return ResponseEntity con la lista de museos encontrados y HttpStatus OK.
     */
    @GetMapping("/getEmail/{email}")
    public ResponseEntity<List<Museo>> getEmail (@PathVariable String email){
        return new ResponseEntity<>(museoRepository.getMuseosByEmail(email), HttpStatus.OK);
    }

    /**
     * Obtiene museos por su titularidad.
     *
     * @param titularidad Titularidad del museo a buscar.
     * @return ResponseEntity con la lista de museos encontrados y HttpStatus OK.
     */
    @GetMapping("/getTitularidad/{titularidad}")
    public ResponseEntity<List<Museo>> getTitularidad (@PathVariable String titularidad){
        return new ResponseEntity<>(museoRepository.getMuseosByTitularidad(titularidad), HttpStatus.OK);
    }

    // Métodos de escritura

    /**
     * Crea un nuevo museo.
     *
     * @param museo Museo a crear.
     * @param email Correo electrónico del usuario que realiza la operación.
     * @param token Token de autenticación del usuario.
     * @return ResponseEntity con un mensaje de éxito si se crea el museo, o null si la autenticación falla.
     */
    @PostMapping("/post/{email}")
    public ResponseEntity<String> nuevoMuseo(@RequestBody Museo museo, @PathVariable String email, @RequestParam String token) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && security.validateToken(email, token)) {
            museoRepository.save(museo);
            return new ResponseEntity<>("Museo creado con éxito", HttpStatus.CREATED);
        }
        return null;
    }

    /**
     * Actualiza un museo existente.
     *
     * @param id ID del museo a actualizar.
     * @param email Correo electrónico del usuario que realiza la operación.
     * @param museoActualizado Datos actualizados del museo.
     * @param token Token de autenticación del usuario.
     * @return ResponseEntity con el museo actualizado y HttpStatus OK, o HttpStatus UNAUTHORIZED si la autenticación falla,
     * o HttpStatus NOT_FOUND si el museo no existe.
     */
    @PutMapping("/put/{id}/{email}")
    public ResponseEntity<Museo> actualizarMuseo(@PathVariable Long id, @PathVariable String email, @RequestBody Museo museoActualizado, @RequestParam String token) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario == null && !security.validateToken(email, token) ){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            var museo = new Museo();
            var optionalMuseo = museoRepository.findById(id);
            if (optionalMuseo.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                museo = optionalMuseo.get();
                museo.setNombre(museoActualizado.getNombre());
                museo.setDireccion(museoActualizado.getDireccion());
                museo.setUrl(museoActualizado.getUrl());
                museo.setEmail(museoActualizado.getEmail());
                museo.setTitularidad(museoActualizado.getTitularidad());
            }
            return new ResponseEntity<Museo>(museoRepository.save(museo),HttpStatus.OK);
        }
    }

    /**
     * Elimina un museo.
     *
     * @param id ID del museo a eliminar.
     * @param email Correo electrónico del usuario que realiza la operación.
     * @param token Token de autenticación del usuario.
     * @return ResponseEntity con un mensaje de éxito si se elimina el museo, o HttpStatus UNAUTHORIZED si la autenticación falla.
     */
    @DeleteMapping("/delete/{id}/{email}")
    public ResponseEntity<String> borrarMuseo(@PathVariable Long id, @PathVariable String email, @RequestParam String token) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario!=null && security.validateToken(email, token))
            museoRepository.deleteById(id);
        return new ResponseEntity<>("Museo eliminado correctamente", HttpStatus.OK);
    }
}