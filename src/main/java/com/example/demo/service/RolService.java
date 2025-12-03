package com.example.demo.service;

import com.example.demo.domain.Rol;
import java.util.List;

public interface RolService {
    List<Rol> listar();
    Rol buscarPorId(Long id);
    void guardar(Rol rol);
    void eliminar(Long id);
}
