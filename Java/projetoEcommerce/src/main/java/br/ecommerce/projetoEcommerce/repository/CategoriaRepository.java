package br.ecommerce.projetoEcommerce.repository;

import br.ecommerce.projetoEcommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
