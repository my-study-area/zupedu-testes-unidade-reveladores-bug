package br.com.zup.edu.atividade_obrigatoria.exponenciacao_recursiva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExponenciacaoRecursivaTest {

    private ExponenciacaoRecursiva exponenciacaoRecursiva;

    @BeforeEach
    void beforeEach() {
        exponenciacaoRecursiva = new ExponenciacaoRecursiva();
    }

    @Test
    @DisplayName("Deve retornar 1 quando expoente for zero")
    void deveRetornar1QuandoExpoenteForZero() {
        Assertions.assertEquals(1, exponenciacaoRecursiva.exponenciar(2, 0));
    }

    @Test
    @DisplayName("Deve retornar zero ponto cinco quando expoente for menos um")
    void deveRetornarZeroPontoCincoQuandoExpoenteForMenosUm() {
        Assertions.assertEquals(0.5, exponenciacaoRecursiva.exponenciar(2, -1));
    }

    @Test
    @DisplayName("Deve retornar o valor da base quando o exponte for um")
    void deveRetornarOValorDaBaseQuandoOExponteForUm() {
        Assertions.assertEquals(2, exponenciacaoRecursiva.exponenciar(2, 1));
    }

    @Test
    @DisplayName("Deve retornar 1 quando base for 1")
    void deveRetornar1QuandoBaseFor1() {
        Assertions.assertEquals(1, exponenciacaoRecursiva.exponenciar(1, 2));
    }
    
    @Test
    @DisplayName("Deve retornar 1 quando a base e menos 1 e o exponte for numero par")
    void deveRetornar1QuandoABaseEMenos1EOExponteForNumeroPar() {
        Assertions.assertEquals(1, exponenciacaoRecursiva.exponenciar(-1, 2));
    }

    @Test
    @DisplayName("Deve retornar menos 1 quando a base e menos 1 e o exponte for numero impar")
    void deveRetornarmenos1QuandoABaseEMenos1EOExponteForNumeroImpar() {
        Assertions.assertEquals(-1, exponenciacaoRecursiva.exponenciar(-1, 11));
    }

    @Test
    @DisplayName("Deve calcular a exponenciacao quando o expoente e menor que menos 1")
    void deveCalcularAExponencicaoQuandoOExpoenteEMenorQueMenos1() {
        Assertions.assertEquals(0.25, exponenciacaoRecursiva.exponenciar(2, -2));
    }

    @Test
    @DisplayName("Deve calcular a exponenciacao quando a base e menor que menos 1 e o expoente e numero par")
    void deveCalcularAExponenciacaoQuandoABaseEMenorQueMenos1EOExpoenteENumeroPar() {
        Assertions.assertEquals(4, exponenciacaoRecursiva.exponenciar(-2, 2));
    }

    @Test
    @DisplayName("Deve retornar 8 quando a base e 2 e expoente e 3")
    void deveRetornar8QuandoABaseE2EExpoenteE3() {
        Assertions.assertEquals(8, exponenciacaoRecursiva.exponenciar(2, 3));
    }
}
