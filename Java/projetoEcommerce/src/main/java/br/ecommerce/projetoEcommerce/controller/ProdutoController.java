package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.ProdutoRequestDTO;
import br.ecommerce.projetoEcommerce.model.Produto;
import br.ecommerce.projetoEcommerce.repository.ProdutoRepository;
import com.fasterxml.jackson.core.util.RecyclerPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//o java entende que é uma API
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produto = this.repository.findAll();
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/{id}")/*aqui ele herda o "/api/movies" e adiciona qualquer
    numero id que eu digitar e que tenha na tabela.*/
    public Produto findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado"));
    }
}