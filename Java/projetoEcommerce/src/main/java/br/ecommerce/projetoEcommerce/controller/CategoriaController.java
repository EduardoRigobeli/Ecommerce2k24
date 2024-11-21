package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.CategoriaRequestDTO;
import br.ecommerce.projetoEcommerce.model.Categoria;
import br.ecommerce.projetoEcommerce.model.Produto;
import br.ecommerce.projetoEcommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categoria = this.repository.findAll();
        return ResponseEntity.ok(categoria);
    }

    public Categoria findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não encontrada"));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Categoria> save (@RequestBody CategoriaRequestDTO dto) {
        if(dto.name().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Categoria categoria = new Categoria();
        categoria.setTipoCategoria(dto.name());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> update (@PathVariable Integer id, @RequestBody CategoriaRequestDTO dto) {
        if(dto.name().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Categoria categoria = this.repository.findById(id)
                .orElseThrow (() ->
                        new IllegalArgumentException("Categoria não encontrada"));
        categoria.setTipoCategoria(dto.name());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}
