package com.practicacuatro.recomendaciones.controller;

import com.practicacuatro.recomendaciones.model.Usuario;
import com.practicacuatro.recomendaciones.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/perfil")
    public String mostrarPerfil(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            Usuario usuario = usuarioRepository.findByUsername(userDetails.getUsername());
            model.addAttribute("usuario", usuario);
            return "usuarios/perfil";
        } else {
            return "redirect:/login";
        }
    }
}
