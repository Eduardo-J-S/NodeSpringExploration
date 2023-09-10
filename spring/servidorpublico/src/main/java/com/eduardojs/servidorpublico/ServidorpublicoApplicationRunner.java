package com.eduardojs.servidorpublico;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.eduardojs.servidorpublico.model.ServidorPublico;
import com.eduardojs.servidorpublico.service.ServidorPublicoService;

import jakarta.annotation.PostConstruct;


@Configuration
public class ServidorpublicoApplicationRunner implements CommandLineRunner {

	private ServidorPublicoService servidorService;
	
	@Autowired
	public void setServidorPublicoService(ServidorPublicoService servidorService) {
		this.servidorService = servidorService;
	}
	
	@PostConstruct
	public void listAll() {
		List<ServidorPublico> servidoresPublicos = servidorService.listAll();
		
		if(servidoresPublicos.size() != 0) {
			System.out.println("###################################");
			servidoresPublicos.forEach(
					servidor -> {
						System.out.println(servidor.matricula());
						System.out.println(servidor.nome());
						System.out.println(servidor.foto());
						System.out.println(servidor.orgao());
						}
					);
		}else {
			System.out.println("Arquivo json vazio");
		}
	}
	
	@PostConstruct
	public void listByMatricula() {
		long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matricula desejada"));
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if(servidorEncontrado.isPresent()) {
			System.out.println("###################################");
			System.out.println(servidorEncontrado.get().matricula());
			System.out.println(servidorEncontrado.get().nome());
			System.out.println(servidorEncontrado.get().foto());
			System.out.println(servidorEncontrado.get().orgao());
		}else {
			System.out.println("Servior não encontrado");
		}
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
