package com.example.apirestturismo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interfaz de repositorio para la entidad Usuario.
 * Extiende JpaRepository para obtener operaciones CRUD básicas.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email Correo electrónico del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra ningún usuario con el correo electrónico dado.
     */
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findByEmail(@Param("email") String email);
}