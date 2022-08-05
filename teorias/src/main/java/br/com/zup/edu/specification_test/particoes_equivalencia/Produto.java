package br.com.zup.edu.specification_test.particoes_equivalencia;

import java.math.BigDecimal;

public class Produto {
    private String nome;
    private Categoria categoria;
    private BigDecimal preco;


    public Produto(String nome, Categoria categoria, BigDecimal preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
