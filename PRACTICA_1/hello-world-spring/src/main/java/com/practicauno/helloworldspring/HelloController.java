package com.practicauno.helloworldspring;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "¡Hola Bienvenidos!";
    }
}
