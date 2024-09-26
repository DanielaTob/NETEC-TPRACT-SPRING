package com.practicauno.helloworldspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println("Hello World Spring Boot");
        SpringApplication.run(HelloWorldSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvendos a mi aplicativo, Spring Boot de Practica Uno");
    }
}
