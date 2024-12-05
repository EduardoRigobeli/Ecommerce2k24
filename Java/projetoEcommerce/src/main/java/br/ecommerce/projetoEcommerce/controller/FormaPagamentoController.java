package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.FormaPagamentoRequestDTO;
import br.ecommerce.projetoEcommerce.dto.PedidoRequestDTO;
import br.ecommerce.projetoEcommerce.model.FormaPagamento;
import br.ecommerce.projetoEcommerce.model.Pedido;
import br.ecommerce.projetoEcommerce.repository.FormaPagamentoRepository;
import br.ecommerce.projetoEcommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formapagamentos")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository repository;

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> findAll() {
        List<FormaPagamento> formaPagamentos = this.repository.findAll();
        return ResponseEntity.ok(formaPagamentos);
    }

    @GetMapping("/{id}")
    public FormaPagamento findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Forma de pagamento não encontrado."));
    }
}
