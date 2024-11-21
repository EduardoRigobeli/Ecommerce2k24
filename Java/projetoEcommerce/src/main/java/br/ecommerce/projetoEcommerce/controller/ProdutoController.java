package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.ProdutoRequestDTO;
import br.ecommerce.projetoEcommerce.model.Produto;
import br.ecommerce.projetoEcommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produto = this.repository.findAll();
        return ResponseEntity.ok(produto);
    }

    public Produto findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado"));
    }

    @PostMapping//salvar os produtos
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequestDTO dto) {
        if(dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }
        Produto produto = new Produto();
        produto.setNomeProduto(dto.nome());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Produto> update (@PathVariable Integer id, @RequestBody ProdutoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }
        Produto produto = this.repository.findById(id)
                .orElseThrow (() ->
                        new IllegalArgumentException("Produto não encontrado"));
        produto.setNomeProduto(dto.nome());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);

    }
}