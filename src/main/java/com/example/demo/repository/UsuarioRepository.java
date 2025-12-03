package com.example.demo.repository;

import com.example.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
   
    Optional<Usuario> findByEmail(String email);

    
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    // Consultas avanzadas
    List<Usuario> findByRol_Id(Long rolId);

    List<Usuario> findByFechaCreacionBetween(LocalDateTime desde, LocalDateTime hasta);
}
