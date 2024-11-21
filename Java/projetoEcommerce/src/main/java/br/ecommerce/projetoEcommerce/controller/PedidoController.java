package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.PedidoRequestDTO;
import br.ecommerce.projetoEcommerce.model.Pedido;
import br.ecommerce.projetoEcommerce.model.Produto;
import br.ecommerce.projetoEcommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedido = this.repository.findAll();
        return ResponseEntity.ok(pedido);
    }

    public Pedido findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pedido> save (@RequestBody PedidoRequestDTO dto) {
        if(dto.name().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Pedido pedido = new Pedido();
        pedido.setStatus(dto.name());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> update (@PathVariable Integer id, @RequestBody PedidoRequestDTO dto) {
        if(dto.name().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Pedido pedido = this.repository.findById(id)
                .orElseThrow (() ->
                        new IllegalArgumentException("Produto não encontrado"));
        pedido.setStatus(dto.name());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
