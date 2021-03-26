package br.com.unialfa.ecommerce.produto.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.unialfa.ecommerce.produto.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
    

