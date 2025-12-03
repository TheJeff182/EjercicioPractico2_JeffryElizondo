package com.example.demo.controller;

import com.example.demo.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final UsuarioService usuarioService;

    public ConsultaController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/porNombre")
    public String consultaPorNombre(@RequestParam(required=false) String texto, Model model) {
        if (texto != null && !texto.isBlank()) {
            model.addAttribute("usuarios", usuarioService.buscarPorNombre(texto));
        }
        return "consultas/porNombre";
    }
}
