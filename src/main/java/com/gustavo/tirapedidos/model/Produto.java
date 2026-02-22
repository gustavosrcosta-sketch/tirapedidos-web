package com.gustavo.tirapedidos.model;

import jakarta.persistence.*;


@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    // Construtor vazio obrigatório para o JPA
    public Produto() {
    }

    // Construtor com parâmetros (opcional, mas profissional)
    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
