package com.eduardojs.servidorpublico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eduardojs.servidorpublico.model.ServidorPublico;
import com.eduardojs.servidorpublico.service.ServidorPublicoService;

@RestController
public class ServidorPublicoController {

	private ServidorPublicoService servidorService;
	
	@Autowired
	public void setServidorPublicoService(ServidorPublicoService servidorService) {
		this.servidorService = servidorService;
	}
	
	@GetMapping("/listAll")
	public List<ServidorPublico> listAll() {
		List<ServidorPublico> servidoresPublicos = servidorService.listAll();
		return servidoresPublicos;
	}
	
	@GetMapping("/list/{matricula}")
	public ServidorPublico listByMatricula(@PathVariable long matricula){
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		return servidorEncontrado.get();
	}
}
