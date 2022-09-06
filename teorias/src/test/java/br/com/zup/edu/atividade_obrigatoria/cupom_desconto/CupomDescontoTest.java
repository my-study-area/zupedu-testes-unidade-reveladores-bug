package br.com.zup.edu.atividade_obrigatoria.cupom_desconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class CupomDescontoTest {
    @Test
    @DisplayName("Deve retornar true quando cupom de desconto nao esta vencido")
    void deveRetornarTrueQuandoCupomDeDescontoNaoEstaVencido() {
        Usuario usuario = new Usuario();
        Produto produto =  new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAte = LocalDateTime.now().plusDays(1);
        BigDecimal porcentagem = new BigDecimal("10");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAte);
        Assertions.assertTrue(cupomDesconto.isValido());
    }

    @Test
    @DisplayName("Deve retornar falso quando cupom de desconto esta vencido")
    void deveRetornarFalsoQuandoCupomDeDescontoEstaVencido() {
        Usuario usuario = new Usuario();
        Produto produto =  new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAte = LocalDateTime.now();
        BigDecimal porcentagem = new BigDecimal("10");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAte);
        Assertions.assertFalse(cupomDesconto.isValido());
    }

    @Test
    @DisplayName("Deve retornar true quando cupom de desconto pertence ao usuario")
    void deveRetornarTrueQuandoCupomDeDescontoPertenceAoUsuario() {
        Usuario usuario = new Usuario();
        Produto produto =  new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAte = LocalDateTime.now();
        BigDecimal porcentagem = new BigDecimal("10");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAte);
        Assertions.assertTrue(cupomDesconto.pertence(usuario));
    }

    @Test
    @DisplayName("Deve retornar false quando cupom de desconto nao pertence ao usuario")
    void deveRetornarFalseQuandoCupomDeDescontoNaoPertenceAoUsuario() {
        Usuario usuario = new Usuario();
        Produto produto =  new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAte = LocalDateTime.now();
        BigDecimal porcentagem = new BigDecimal("10");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAte);
        Usuario usuario2 = new Usuario();
        Assertions.assertFalse(cupomDesconto.pertence(usuario2));
    }

    @Test
    @DisplayName("Deve retornar true quando cumpom de desconto pertence ao produto")
    void deveRetornarTrueQuandoCumpomDeDescontoPertenceAoProduto() {
        Usuario usuario = new Usuario();
        Produto produto =  new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAte = LocalDateTime.now();
        BigDecimal porcentagem = new BigDecimal("10");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAte);
        Assertions.assertTrue(cupomDesconto.pertence(produto));
    }

    @Test
    @DisplayName("Deve retornar false quando cumpom de desconto nao pertence ao produto")
    void deveRetornarFalseQuandoCumpomDeDescontoNaoPertenceAoProduto() {
        Usuario usuario = new Usuario();
        Produto produto =  new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAte = LocalDateTime.now();
        BigDecimal porcentagem = new BigDecimal("10");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAte);
        Produto produto2 =  new Produto("macarrao", BigDecimal.TEN);
        Assertions.assertFalse(cupomDesconto.pertence(produto2));
    }

}
