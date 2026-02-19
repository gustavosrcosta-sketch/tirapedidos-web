package com.gustavo.tirapedidos.controller;

import com.gustavo.tirapedidos.model.Produto;
import com.gustavo.tirapedidos.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Listar todos
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    // Salvar
    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}
