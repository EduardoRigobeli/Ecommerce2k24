package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.AuditPrecoProdutoRequestDTO;
import br.ecommerce.projetoEcommerce.dto.ProdutoRequestDTO;
import br.ecommerce.projetoEcommerce.model.AuditPrecoProduto;
import br.ecommerce.projetoEcommerce.model.Produto;
import br.ecommerce.projetoEcommerce.repository.AuditPrecoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//o java entende que é uma API
@RequestMapping("/api/auditprecos")
public class AuditPrecoController {

    @Autowired
    private AuditPrecoProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<AuditPrecoProduto>> findAll() {
        List<AuditPrecoProduto> auditPrecoProdutos = this.repository.findAll();
        return ResponseEntity.ok(auditPrecoProdutos);
    }

    @GetMapping("/{id}")/*aqui ele herda o "/api/movies" e adiciona qualquer
    numero id que eu digitar e que tenha na tabela.*/
    public AuditPrecoProduto findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Auditoria não encontrada."));
    }

    @PostMapping//o post é um INSERT basicamente
    public ResponseEntity<AuditPrecoProduto> save(@RequestBody AuditPrecoProdutoRequestDTO dto) {
        if(dto.nome().isEmpty()) {//se o dto.nome estiver vazio, ira aparecer o erro 400
            return ResponseEntity.status(400).build();
        }

        AuditPrecoProduto auditPrecoProduto = new AuditPrecoProduto();
        auditPrecoProduto.setMotivo(dto.nome());

        this.repository.save(auditPrecoProduto);
        return ResponseEntity.ok(auditPrecoProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Integer id) {
        AuditPrecoProduto auditPrecoProduto = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado"));

        this.repository.delete(auditPrecoProduto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")//aqui ele é um UPDATE
    public ResponseEntity<AuditPrecoProduto> update(@PathVariable Integer id, @RequestBody AuditPrecoProdutoRequestDTO dto) {
        AuditPrecoProduto auditPrecoProduto = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado"));

        auditPrecoProduto.setMotivo(dto.nome());

        this.repository.save(auditPrecoProduto);
        return ResponseEntity.ok(auditPrecoProduto);
    }
}