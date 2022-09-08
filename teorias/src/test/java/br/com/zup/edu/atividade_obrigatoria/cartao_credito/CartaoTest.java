package br.com.zup.edu.atividade_obrigatoria.cartao_credito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartaoTest {

    private String codigoSeguranca;
    private String senha;
    private Cartao cartaoLimite10;
    private Fatura fatura;

    @BeforeEach
    void beforeEach() {
        var validadeCartao = LocalDateTime.now().plusYears(2);
        var limiteDoCartao = BigDecimal.TEN;
        codigoSeguranca = "222";
        var mesAnoFatura = YearMonth.of(2022, 8);
        senha = "123123";
        cartaoLimite10 = new Cartao("123090", "Joao Maria", codigoSeguranca, senha, limiteDoCartao, validadeCartao);
        fatura = new Fatura(cartaoLimite10, mesAnoFatura);
    }

    @DisplayName("deve aprovar gasto do cartão quando esta no limite")
    @ParameterizedTest(name = "com valor do gasto = {arguments}")
    @ValueSource(longs = {10, 9, 0})
    void deveAprovarGastoDoCartaoQuandoEstaNoLimite(long valorDoGasto) {
        Gasto gasto = new Gasto(BigDecimal.valueOf(valorDoGasto));
        fatura.adicionar(gasto);

        boolean isLimiteAprovado = cartaoLimite10.isAprovado(gasto, codigoSeguranca, senha);

        assertTrue(isLimiteAprovado);
    }

    @DisplayName("deve reprovar gasto do cartão quando esta acima do limite de 10 do cartao")
    @ParameterizedTest(name = "com gasto igual {arguments}")
    @ValueSource(longs = {11,12,999})
    void deveReprovarGastoDoCartaoQuandoEstaAcimaDoLimiteDe10DoCartao(long valorDoGasto) {
        Gasto gasto = new Gasto(BigDecimal.valueOf(valorDoGasto));
        fatura.adicionar(gasto);

        boolean isLimiteAprovado = cartaoLimite10.isAprovado(gasto, codigoSeguranca, senha);

        assertFalse(isLimiteAprovado);
    }

    @Test
    @DisplayName("Deve reprovar gasto do cartao quando codigo de segunranca esta errado")
    void deveReprovarGastoDoCartaoQuandoCodigoDeSegunrancaEstaErrado() {
        Gasto gastoDe10 = new Gasto(BigDecimal.TEN);
        fatura.adicionar(gastoDe10);
        String codigoSegurancaErrado = "codigoSegurancaErrado";

        boolean isLimiteAprovado = cartaoLimite10.isAprovado(gastoDe10, codigoSegurancaErrado, senha);

        assertFalse(isLimiteAprovado);
    }

    @Test
    @DisplayName("Deve reprovar gasto do cartao quando senha esta errada")
    void deveReprovarGastoDoCartaoQuandoSenhaEstaErrada() {
        Gasto gastoDe10 = new Gasto(BigDecimal.TEN);
        fatura.adicionar(gastoDe10);
        String senhaErrada = "senhaErrada";

        boolean isLimiteAprovado = cartaoLimite10.isAprovado(gastoDe10, codigoSeguranca, senhaErrada);

        assertFalse(isLimiteAprovado);
    }

}
