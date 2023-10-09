package br.com.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Tutorial documentando APIs",
		version = "1.0",
		description = "Documentando uma API básica de gerenciamento de pessoas",
		contact = @Contact(name = "Eduardo", email = "ejsilva159@gmail.com", url = "https://github.com/Eduardo-J-S")
	)
)
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
