package com.gustavo.tirapedidos.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.gustavo.tirapedidos.model.Cliente;
import com.gustavo.tirapedidos.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // POST - salvar cliente
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    // GET - listar todos
    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }

    // GET por ID
    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
