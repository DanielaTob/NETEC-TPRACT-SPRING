package com.practicacuatro.recomendaciones.controller;

import com.practicacuatro.recomendaciones.model.Producto;
import com.practicacuatro.recomendaciones.model.Reseña;
import com.practicacuatro.recomendaciones.repository.ReseñaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/resenas")
public class ReviewController {

    @Autowired
    private ReseñaRepository reseñaRepository;

    private List<Producto> productos = Arrays.asList(
            new Producto(1L, "Producto A", "Descripción del Producto A", 100.0),
            new Producto(2L, "Producto B", "Descripción del Producto B", 150.0),
            new Producto(3L, "Producto C", "Descripción del Producto C", 200.0)
    );

    // Lista todas las reseñas
    @GetMapping
    public String listarReseñas(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<Reseña> reseñas = reseñaRepository.findByUsuarioId(
                userDetails != null ?
                        reseñaRepository.findByUsuarioId(
                                1L
                        ).size() > 0 ? 1L : 1L : 0L
        );
        model.addAttribute("reseñas", reseñaRepository.findAll());
        model.addAttribute("productos", productos);
        return "reviews/lista";
    }

    // Mostrar formulario para crear una nueva reseña
    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("reseña", new Reseña());
        model.addAttribute("productos", productos);
        return "reviews/crear";
    }

    // Procesar creación de nueva reseña
    @PostMapping("/crear")
    public String crearReseña(@ModelAttribute Reseña reseña, @AuthenticationPrincipal UserDetails userDetails) {
        reseña.setUsuario(new com.practicacuatro.recomendaciones.model.Usuario());
        reseña.getUsuario().setId(1L);
        reseñaRepository.save(reseña);
        return "redirect:/resenas";
    }

    // Mostrar formulario para editar una reseña
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<Reseña> reseñaOpt = reseñaRepository.findById(id);
        if (reseñaOpt.isPresent()) {
            model.addAttribute("reseña", reseñaOpt.get());
            model.addAttribute("productos", productos);
            return "reviews/editar";
        } else {
            return "redirect:/resenas";
        }
    }

    // Procesar edición de reseña
    @PostMapping("/editar/{id}")
    public String editarReseña(@PathVariable Long id, @ModelAttribute Reseña reseña) {
        reseña.setId(id);
        reseñaRepository.save(reseña);
        return "redirect:/resenas";
    }

    // Eliminar una reseña
    @GetMapping("/eliminar/{id}")
    public String eliminarReseña(@PathVariable Long id) {
        reseñaRepository.deleteById(id);
        return "redirect:/resenas";
    }
}
