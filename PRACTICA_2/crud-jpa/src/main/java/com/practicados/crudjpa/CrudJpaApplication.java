package com.practicados.crudjpa;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;

@SpringBootApplication
public class CrudJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(CrudJpaApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CrudJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Daniel", "Quintero"));
			repository.save(new Customer("Anita", "Velez"));
			repository.save(new Customer("Luisa", "Fernandez"));
			repository.save(new Customer("Dayana", "Moreno"));
			repository.save(new Customer("Michelle", "Ortiz"));

			// fetch all customers
			log.info("Clientes encontrados con el método findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");


			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Cliente encontrados con el método findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch an individual customer by ID
			Customer customer2 = repository.findById(4L);
			log.info("Cliente encontrado con el método findById(4L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch an individual customer by ID
			Customer customer3 = repository.findById(5L);
			log.info("Cliente encontrado con el método findById(5L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Cliente encontrado con el método findByLastName('Velez'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Velez").forEach(velez -> {
				log.info(velez.toString());
			});
			log.info("");

			// fetch customers by last name
			log.info("Cliente encontrado con el método findByLastName('Quintero'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Quintero").forEach(quintero -> {
				log.info(quintero.toString());
			});
			log.info("");
		};
	}

}

