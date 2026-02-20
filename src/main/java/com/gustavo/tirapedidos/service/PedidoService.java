package com.gustavo.tirapedidos.service;

import com.gustavo.tirapedidos.model.ItemPedido;
import com.gustavo.tirapedidos.model.Pedido;
import com.gustavo.tirapedidos.model.Produto;
import com.gustavo.tirapedidos.repository.PedidoRepository;
import com.gustavo.tirapedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvar(Pedido pedido) {

        pedido.setData(LocalDate.now());

        double total = 0.0;

        for (ItemPedido item : pedido.getItens()) {

            item.setPedido(pedido);

            // Busca produto no banco
            Produto produto = produtoRepository
                    .findById(item.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            item.setProduto(produto);
            item.setPrecoUnitario(produto.getPreco());

            total += produto.getPreco() * item.getQuantidade();
        }

        pedido.setValorTotal(total);

        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
