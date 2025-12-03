package com.example.demo.service;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    
    
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }
    
    public List<Usuario> buscarPorNombre(String nombre) {
    return repo.findByNombreContainingIgnoreCase(nombre);
}


    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
