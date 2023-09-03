package br.com.examplemvc.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.examplemvc.Application.model.Produto;
import br.com.examplemvc.Application.repository.ProdutoRepository;

import java.util.List;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
    	List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "lista-produtos";
    }
}