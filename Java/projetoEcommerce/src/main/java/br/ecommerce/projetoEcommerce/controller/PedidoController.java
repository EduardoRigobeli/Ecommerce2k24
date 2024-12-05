package br.ecommerce.projetoEcommerce.controller;

import br.ecommerce.projetoEcommerce.dto.CategoriaRequestDTO;
import br.ecommerce.projetoEcommerce.dto.PedidoRequestDTO;
import br.ecommerce.projetoEcommerce.model.Categoria;
import br.ecommerce.projetoEcommerce.model.Pedido;
import br.ecommerce.projetoEcommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedido = this.repository.findAll();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não localizado."));
    }

    @PostMapping("/{id}")//o post é um INSERT
    public ResponseEntity<Pedido> save(@RequestBody PedidoRequestDTO dto) {
        if(dto.nome().isEmpty()) {//se o dto.nome estiver vazio, ira aparecer o erro 400
            return ResponseEntity.status(400).build();
        }

        Pedido pedido = new Pedido();
        pedido.setStatus(dto.nome());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Integer id) {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não localizado."));

        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")//aqui ele é um UPDATE
    public ResponseEntity<Pedido> update(@PathVariable Integer id, @RequestBody CategoriaRequestDTO dto) {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não encontrada"));

        pedido.setStatus(dto.nome());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
