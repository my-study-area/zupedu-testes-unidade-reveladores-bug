package br.com.zup.edu.atividade_obrigatoria.cupom_desconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class ProdutoTest {
    @Test
    @DisplayName("Deve aplicar desconto quando o cupom de desconto pertence ao produto e usuario correto e nao esta vencido")
    void deveAplicarDescontoQuandoOCupomDeDescontoPertenceAoProdutoEUsuarioCorretoENaoEstaVencido() {
        Usuario usuario = new Usuario();
        Produto produto = new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAte = LocalDateTime.now().plusDays(1);
        BigDecimal porcentagem = new BigDecimal("0.1");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAte);
        Compra compra = produto.comprar(cupomDesconto, usuario);
        BigDecimal precoCompraEsperado = new BigDecimal("9.0");
        Assertions.assertEquals(precoCompraEsperado, compra.getValor());
    }

    @Test
    @DisplayName("Nao deve aplicar desconto quando o cupom nao pertence ao usuario")
    void naoDeveAplicarDescontoQuandoOCupomNaoPertenceAoUsuario() {
        Usuario usuario = new Usuario();
        Produto produto = new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAte = LocalDateTime.now().plusDays(1);
        BigDecimal porcentagem = new BigDecimal("0.1");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAte);
        Usuario usuarioSemCupom = new Usuario();
        Compra compra = produto.comprar(cupomDesconto, usuarioSemCupom);
        BigDecimal precoCompraEsperado = BigDecimal.TEN;
        Assertions.assertEquals(precoCompraEsperado, compra.getValor());
    }

    @Test
    @DisplayName("Nao deve aplicar desconto quando o cupom esta vencido")
    void naoDeveAplicarDescontoQuandoOCupomEstaVencido() {
        Usuario usuario = new Usuario();
        Produto produto = new Produto("macarrao", BigDecimal.TEN);
        LocalDateTime validoAteOntem = LocalDateTime.now().minusDays(1);
        BigDecimal porcentagem = new BigDecimal("0.1");
        CupomDesconto cupomDesconto = new CupomDesconto(usuario, produto, porcentagem, validoAteOntem);

        Compra compra = produto.comprar(cupomDesconto, usuario);
        BigDecimal precoCompraEsperado = BigDecimal.TEN;
        Assertions.assertEquals(precoCompraEsperado, compra.getValor());
    }

    @Test
    @DisplayName("Nao deve aplicar desconto quando o cupom nao pertence ao produto")
    void naoDeveAplicarDescontoQuandoOCupomNaoPertenceAoProduto() {
        Usuario usuario = new Usuario();
        Produto produto1 = new Produto("macarrao", BigDecimal.TEN);
        Produto produtoSemDesconto = new Produto("banana", new BigDecimal("5.00"));
        LocalDateTime validoAteOntem = LocalDateTime.now().minusDays(1);
        BigDecimal porcentagem = new BigDecimal("0.1");
        CupomDesconto cupomDescontoProduto1 = new CupomDesconto(usuario, produto1, porcentagem, validoAteOntem);

        Compra compra = produtoSemDesconto.comprar(cupomDescontoProduto1, usuario);
        BigDecimal precoCompraEsperado = new BigDecimal("5.00");
        Assertions.assertEquals(precoCompraEsperado, compra.getValor());
    }
}
