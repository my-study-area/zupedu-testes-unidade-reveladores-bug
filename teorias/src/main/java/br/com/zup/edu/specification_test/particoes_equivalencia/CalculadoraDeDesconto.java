package br.com.zup.edu.specification_test.particoes_equivalencia;

import java.math.BigDecimal;
import java.time.DayOfWeek;

public class CalculadoraDeDesconto {
    public BigDecimal desconto(DayOfWeek hoje, Produto produto) {

        if (hoje.equals(DayOfWeek.MONDAY) && produto.getCategoria().equals(Categoria.VERDURA)) {
            return produto.getPreco().multiply(new BigDecimal("0.9"));
        }

        if (hoje.equals(DayOfWeek.TUESDAY) && produto.getCategoria().equals(Categoria.CARNE)) {
            return produto.getPreco().multiply(new BigDecimal("0.93"));
        }

        if (hoje.equals(DayOfWeek.WEDNESDAY) && produto.getCategoria().equals(Categoria.HIGIENE_PESSOAL)) {
            return produto.getPreco().multiply(new BigDecimal("0.95"));
        }

        if (hoje.equals(DayOfWeek.THURSDAY) && produto.getCategoria().equals(Categoria.LIMPEZA)) {
            return produto.getPreco().multiply(new BigDecimal("0.96"));
        }

        if (hoje.equals(DayOfWeek.FRIDAY) && produto.getCategoria().equals(Categoria.PADARIA)) {
            return produto.getPreco().multiply(new BigDecimal("0.94"));
        }

        return produto.getPreco();
    }
}
