//package br.com.examplemvc.Application.data;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import br.com.examplemvc.Application.model.Produto;
//import br.com.examplemvc.Application.repository.ProdutoRepository;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//	 
//	@Autowired
//	private ProdutoRepository produtoRepository;
//	
//	@Override
//    public void run(String... args) throws Exception {
//        // Crie alguns produtos iniciais e salve-os no banco de dados
//        List<Produto> produtosIniciais = Arrays.asList(
//            new Produto("Produto 1", 10.0),
//            new Produto("Produto 2", 20.0),
//            new Produto("Produto 3", 30.0),
//            new Produto("Produto 4", 40.0)
//        );
//
//        produtoRepository.saveAll(produtosIniciais);
//    }
//}
