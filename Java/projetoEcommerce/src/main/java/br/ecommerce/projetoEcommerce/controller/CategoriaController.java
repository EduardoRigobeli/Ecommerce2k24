package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.CategoriaRequestDTO;
import br.ecommerce.projetoEcommerce.model.Categoria;
import br.ecommerce.projetoEcommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//o java entende que é uma API
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categoria = this.repository.findAll();
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não encontrada"));
    }
}