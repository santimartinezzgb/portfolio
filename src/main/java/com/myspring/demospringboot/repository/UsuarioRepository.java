package com.myspring.demospringboot.repository;

import com.myspring.demospringboot.controller.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    // Lista simulada de usuarios
    private final List<Usuario> usuarios = new ArrayList<>();

    // Contador para simular IDs auto-incrementales
    private Long contadorId = 1L;

    // Constructor para inicializar algunos datos de prueba
    public UsuarioRepository() {
        // Datos de prueba
        usuarios.add(new Usuario(contadorId++, "Juan Pérez", "juan@email.com"));
        usuarios.add(new Usuario(contadorId++, "María García", "maria@email.com"));
    }

    // Métodos CRUD simulados
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    // Buscar usuario por ID
    public Optional<Usuario> findById(Long id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    // Guardar o actualizar usuario
    public Usuario save(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(contadorId++);
            usuarios.add(usuario);
        } else {
            Optional<Usuario> existente = findById(usuario.getId());
            existente.ifPresent(u -> {
                u.setNombre(usuario.getNombre());
                u.setEmail(usuario.getEmail());
            });
        }
        return usuario;
    }

    // Eliminar usuario por ID
    public void deleteById(Long id) {
        usuarios.removeIf(u -> u.getId().equals(id));
    }
}