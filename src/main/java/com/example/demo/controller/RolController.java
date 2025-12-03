package com.example.demo.controller;

import com.example.demo.domain.Rol;
import com.example.demo.service.RolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // LISTADO
    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("roles", rolService.listar());
        return "roles/listado";
    }

    // NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("rol", new Rol());
        model.addAttribute("titulo", "Nuevo Rol");
        return "roles/formulario";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Rol rol) {
        rolService.guardar(rol);
        return "redirect:/roles/listado";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Rol rol = rolService.buscarPorId(id);
        model.addAttribute("rol", rol);
        model.addAttribute("titulo", "Editar Rol");
        return "roles/formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
        return "redirect:/roles/listado";
    }
}
