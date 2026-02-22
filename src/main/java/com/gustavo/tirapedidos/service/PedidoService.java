package com.gustavo.tirapedidos.service;

import com.gustavo.tirapedidos.model.Pedido;
import com.gustavo.tirapedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
