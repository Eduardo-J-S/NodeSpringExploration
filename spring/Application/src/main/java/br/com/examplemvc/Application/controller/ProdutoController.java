package br.com.examplemvc.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.examplemvc.Application.model.Log;
import br.com.examplemvc.Application.model.Produto;
import br.com.examplemvc.Application.repository.LogRepository;
import br.com.examplemvc.Application.repository.ProdutoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private LogRepository logRepository;
	
	private final Logger logger = LoggerFactory.getLogger(ProdutoController.class);
	
	@GetMapping("/produtos/{id}")
	public String exibirProduto(@PathVariable Long id, Model model) {
		logger.info("Acessando o método exibirProduto com o ID: {}", id);
		
		  Log log = new Log();
		  log.setTimestamp(new Date());
		  log.setLevel("INFO");
		  log.setSource("ProdutoController");
		  log.setMessage("Acessando o método exibirProduto com o ID: " + id);

		  logRepository.save(log);
		
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
    	logger.info("Acessando o método listarProdutos");
    	
    	  Log log = new Log();
		  log.setTimestamp(new Date());
		  log.setLevel("INFO");
		  log.setSource("ProdutoController");
		  log.setMessage("Acessando o método listarProdutos");

		  logRepository.save(log);
		
    	
    	List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "lista-produtos";
    }
    
    @GetMapping("/produtos/novo")
    public String exibirFormularioProduto(Model model) {
    	logger.info("Acessando o método exibirFormularioProduto");
    	
    	
    	Log log = new Log();
		log.setTimestamp(new Date());
		log.setLevel("INFO");
		log.setSource("ProdutoController");
		log.setMessage("Acessando o método exibirFormularioProduto");

		logRepository.save(log);
		
    	
    	
        model.addAttribute("produto", new Produto());
        return "formulario-produto";
    }
    
    @PostMapping("/produtos")
    public String adicionarProduto(@ModelAttribute Produto produto) {
    	logger.info("Acessando o método adicionarProduto com o produto: {}", produto.getNome());
    	
    	
    	Log log = new Log();
		log.setTimestamp(new Date());
		log.setLevel("INFO");
		log.setSource("ProdutoController");
		log.setMessage("Acessando o método adicionarProduto	");

		logRepository.save(log);

        // falta - Validar os dados do produto
        // Salvar o produto no banco de dados
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }
    
    @GetMapping("/logs")
    public String exibirLogs(Model model) {
        List<Log> logs = logRepository.findAll();
        model.addAttribute("logs", logs);
        return "logs";
    }
}