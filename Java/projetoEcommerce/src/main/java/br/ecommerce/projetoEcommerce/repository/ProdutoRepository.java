package br.ecommerce.projetoEcommerce.repository;

import br.ecommerce.projetoEcommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
