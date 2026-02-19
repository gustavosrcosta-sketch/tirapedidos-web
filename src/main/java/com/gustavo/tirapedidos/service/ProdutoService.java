package com.gustavo.tirapedidos.service;

import com.gustavo.tirapedidos.model.Produto;
import com.gustavo.tirapedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Injeção de dependência via construtor (boa prática)
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Listar todos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar por ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Salvar
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Deletar
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
