package com.example.apirestturismo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de la validación de tokens de seguridad.
 */
@Service
public class SecurityService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Valida un token de seguridad para un usuario dado.
     *
     * @param email Correo electrónico del usuario.
     * @param token Token proporcionado para validar.
     * @return true si el token es válido para el usuario dado, false de lo contrario.
     */
    public Boolean validateToken(String email, String token) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {
            return tokenIsValid(usuario.getToken(), token);
        }
        return false;
    }

    /**
     * Verifica si un token proporcionado coincide con el token almacenado.
     *
     * @param storedToken Token almacenado en la base de datos.
     * @param providedToken Token proporcionado para validar.
     * @return true si el token proporcionado coincide con el almacenado, false de lo contrario.
     */
    private boolean tokenIsValid(String storedToken, String providedToken) {
        return storedToken != null && !storedToken.isEmpty() && storedToken.equals(providedToken);
    }
}