package br.com.examplemvc.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.examplemvc.Application.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
