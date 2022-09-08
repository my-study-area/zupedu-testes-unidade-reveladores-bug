package br.com.zup.edu.atividade_obrigatoria.cartao_credito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FaturaTest {

    @Test
    @DisplayName("Deve retornar zero quando não adicionar gastos na fatura")
    void deveRetornarZeroQuandoNaoAdicionarGastosNaFatura() {
        LocalDateTime validadeCartao = LocalDateTime.now().plusYears(2);
        Cartao cartaoJoao = new Cartao("123090", "Joao Maria", "222", "123123", BigDecimal.valueOf(100L), validadeCartao);
        YearMonth mesAnoFatura = YearMonth.of(2022, 8);
        Fatura fatura = new Fatura(cartaoJoao, mesAnoFatura);

        BigDecimal valorEsperado = BigDecimal.ZERO;
        assertEquals(valorEsperado, fatura.getValor());
    }

    @Test
    @DisplayName("Deve retornar 10 quando adiciono uma fatura no valor de 10")
    void deveRetornar10QuandoAdicionoUmaFaturaNoValorDe10() {
        LocalDateTime validadeCartao = LocalDateTime.now().plusYears(2);
        Cartao cartaoJoao = new Cartao("123090", "Joao Maria", "222", "123123", BigDecimal.valueOf(100L), validadeCartao);
        YearMonth mesAnoFatura = YearMonth.of(2022, 8);
        Fatura fatura = new Fatura(cartaoJoao, mesAnoFatura);
        fatura.adicionar(new Gasto(BigDecimal.TEN));

        BigDecimal valorEsperado = BigDecimal.TEN;
        assertEquals(valorEsperado, fatura.getValor());
    }
}
