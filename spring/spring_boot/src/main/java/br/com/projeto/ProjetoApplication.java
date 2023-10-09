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
		contact = @Contact(name = "Ralf", email = "contato@ralflima.com", url = "https://www.ralflima.com")
	)
)
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
