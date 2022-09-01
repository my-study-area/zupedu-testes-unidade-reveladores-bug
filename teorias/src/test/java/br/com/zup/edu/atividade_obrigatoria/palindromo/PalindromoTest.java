package br.com.zup.edu.atividade_obrigatoria.palindromo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromoTest {
    private Palindromo palindromo = new Palindromo();

    @DisplayName("Deve retornar falso quando a palavra é nula ou em branco")
    @ParameterizedTest
    @NullAndEmptySource
    void deveRetornarFalsoQuandoAPalavraE(String palavra) {
        boolean valorEsperado = palindromo.isPalindromo(palavra);

        Assertions.assertFalse(valorEsperado);
    }

    @DisplayName("Deve retornar falso quando a palavra não é palindromo")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "az", "palavra"})
    void deveRetornarFalsoQuandoAPalavraNaoEPalindromo(String palavra) {
        Boolean valorEsperado = palindromo.isPalindromo(palavra);
        Assertions.assertFalse(valorEsperado);
    }

    @DisplayName("Deve retornar true quando a palavra e palindromo")
    @ParameterizedTest
    @ValueSource(strings = {"ovo", "osso", "sopapos"})
    void deveRetornarTrueQuandoAPalavraEPalindromo(String palavra) {
        boolean valorEsperado = palindromo.isPalindromo(palavra);
        Assertions.assertTrue(valorEsperado);
    }
}
