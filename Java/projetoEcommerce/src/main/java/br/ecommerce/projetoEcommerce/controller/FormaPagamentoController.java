package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.FormaPagamentoRequestDTO;
import br.ecommerce.projetoEcommerce.model.FormaPagamento;
import br.ecommerce.projetoEcommerce.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formapagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository repository;

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> findAll() {
        List<FormaPagamento> formaPagamentos = this.repository.findAll();
        return ResponseEntity.ok(formaPagamentos);
    }

    public FormaPagamento findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Forma de pagamento não encontrado"));
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> save(@RequestBody FormaPagamentoRequestDTO dto) {
        if(dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setFormaPagamento(dto.nome());

        this.repository.save(formaPagamento);
        return ResponseEntity.ok(formaPagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FormaPagamento> update (@PathVariable Integer id, @RequestBody FormaPagamentoRequestDTO dto) {
        if(dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        FormaPagamento formaPagamento = this.repository.findById(id)
                .orElseThrow (() ->
                        new IllegalArgumentException("Forma de pagamento não encontrado"));
        formaPagamento.setFormaPagamento(dto.nome());

        this.repository.save(formaPagamento);
        return ResponseEntity.ok(formaPagamento);
    }
}
