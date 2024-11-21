package br.ecommerce.projetoEcommerce.repository;

import br.ecommerce.projetoEcommerce.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer> {
}
