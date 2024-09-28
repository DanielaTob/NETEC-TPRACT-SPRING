package com.practicacuatro.recomendaciones;

import com.practicacuatro.recomendaciones.model.Usuario;
import com.practicacuatro.recomendaciones.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecomendacionesApplication {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(RecomendacionesApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Usuario usuario = usuarioRepository.findByUsername("usuario1");
            if (usuario != null) {
                System.out.println("Usuario encontrado: " + usuario.getUsername());
            } else {
                System.out.println("Usuario no encontrado");
            }
        };
    }

}
