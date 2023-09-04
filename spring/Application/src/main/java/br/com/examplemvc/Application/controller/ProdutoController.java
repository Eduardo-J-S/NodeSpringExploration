package br.com.examplemvc.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.examplemvc.Application.model.Produto;
import br.com.examplemvc.Application.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos/{id}")
	public String exibirProduto(@PathVariable Long id, Model model) {
	    // buscar o produto pelo ID no banco de dados usando o repository.
	    Optional<Produto> produtoOptional = produtoRepository.findById(id);

	    if (produtoOptional.isPresent()) {
	        Produto produto = produtoOptional.get();
	        // Adicionar o produto ao modelo para que ele possa ser exibido na página.
	        model.addAttribute("produto", produto);
	    } else {
	        // Lidar com o caso em que o produto não foi encontrado (por exemplo, redirecionar ou mostrar uma mensagem de erro).
	        // ou redirecionar para uma página de erro 404 ou fazer o que for apropriado para a aplicação.
	        return "redirect:/produtos"; // Redireciona de volta para a lista de produtos.
	    }

	    return "detalhes-produto";
	}
	
    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
    	List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "lista-produtos";
    }
    
    @GetMapping("/produtos/novo")
    public String exibirFormularioProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "formulario-produto";
    }
    
    @PostMapping("/produtos")
    public String adicionarProduto(@ModelAttribute Produto produto) {
        // falta - Validar os dados do produto
        // Salvar o produto no banco de dados
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }
}