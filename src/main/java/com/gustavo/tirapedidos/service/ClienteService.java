package com.gustavo.tirapedidos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gustavo.tirapedidos.model.Cliente;
import com.gustavo.tirapedidos.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    // Injeção de dependência (Dependency Injection)
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // Salvar cliente
    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    // Listar todos os clientes
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // Excluir cliente
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
