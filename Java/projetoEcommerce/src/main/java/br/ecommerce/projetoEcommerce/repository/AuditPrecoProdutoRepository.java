package br.ecommerce.projetoEcommerce.repository;

import br.ecommerce.projetoEcommerce.model.AuditPrecoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditPrecoProdutoRepository extends JpaRepository<AuditPrecoProduto, Integer> {
}
