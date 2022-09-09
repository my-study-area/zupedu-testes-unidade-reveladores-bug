package br.com.zup.edu.atividade_obrigatoria.numero_primo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;

class NumeroPrimoTest {

    private NumeroPrimo numeroPrimo;

    @BeforeEach
    void beforeEach() {
        numeroPrimo = new NumeroPrimo();
    }

    @DisplayName("Deve retornar falso quando o valor for invalido")
    @ParameterizedTest(name = "com valor igual {arguments}")
    @ValueSource(ints = {-1, 0, 1})
    void deveRetornarFalsoQuandoOValorForInvalido(int valor) {
        assertFalse(numeroPrimo.primo(valor));
    }

    @DisplayName("Deve retornar falso quando o valor e divisivel por mais de 2 valores")
    @ValueSource(ints = {4, 6, 80})
    @ParameterizedTest(name = "com valor igual {arguments}")
    void deveRetornarFalsoQuandoOValorEDivisivelPorMaisDe2Valores(int valor) {
        assertFalse(numeroPrimo.primo(valor));
    }

    @DisplayName("Deve retornar true quando valor e primo")
    @ParameterizedTest(name = "com valor igual {arguments}")
    @ValueSource(ints = {2, 5, 13, 53})
    void deveRetornarTrueQuandoValorEPrimo(int valor) {
        Assertions.assertTrue(numeroPrimo.primo(valor));
    }

}
