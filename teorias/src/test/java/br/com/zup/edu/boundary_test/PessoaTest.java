package br.com.zup.edu.boundary_test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    private Pessoa pessoa;
//    @BeforeAll
//    void beforeAll() {
//        pessoa
//    }

    @Test
    @DisplayName("deve ser maior de idade quando idade é igual a 18")
    void deveSerMaiorDeIdadeQuandoIdadeEIgualA18() {
        pessoa = new Pessoa("Maria", 18);
        boolean maiorDeIdade = pessoa.isMaiorDeIdade();

        assertTrue(maiorDeIdade, "com 18 anos já deveria ser de maior");
    }

    @Test
    @DisplayName("não deve ser maior de idade quando idade é menor que 18")
    void naoDeveSerMaiorDeIdadeQuandoIdadeEMenorQue18() {
        pessoa = new Pessoa("Maria", 17);
        boolean maiorDeIdade = pessoa.isMaiorDeIdade();

        assertFalse(maiorDeIdade, "com 17 não deveria ser maior de idade");
    }

    @ParameterizedTest(name = "{index} => idade={0}")
    @MethodSource("idadesComMaioridade")
    @DisplayName("deve ser maior de idade")
    void test2(int idade){
        pessoa = new Pessoa("Maria", idade);
        boolean maiorDeIdade = pessoa.isMaiorDeIdade();

        assertTrue(maiorDeIdade, String.format("com %d deveria ser maior de idade",idade));
    }

    private static Stream<Arguments> idadesComMaioridade() {
        return Stream.of(
                Arguments.of(19),
                Arguments.of(20),
                Arguments.of(36),
                Arguments.of(78),
                Arguments.of(99)
        );
    }

    @ParameterizedTest(name = "{index} => idade={0}")
    @MethodSource("idadesSemMaioridade")
    @DisplayName("não deve ser maior de idade")
    void naoDeveSerMaior(int idade){
        pessoa = new Pessoa("Maria", idade);
        boolean maiorDeIdade = pessoa.isMaiorDeIdade();

        assertFalse(maiorDeIdade, String.format("com %d não deveria ser maior de idade",idade));
    }

    private static Stream<Arguments> idadesSemMaioridade() {
        return Stream.of(
                Arguments.of(17),
                Arguments.of(16),
                Arguments.of(5),
                Arguments.of(8),
                Arguments.of(2)
        );
    }

}
