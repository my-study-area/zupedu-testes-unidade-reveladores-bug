package br.com.zup.edu.specification_test.particoes_equivalencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeDescontoTest {

    private CalculadoraDeDesconto calculadora;

    @BeforeEach
    void beforeAll() {
        calculadora = new CalculadoraDeDesconto();
    }

//    @DisplayName("deve obter o desconto caso seja comprado no dia em que sua categoria é apta")
    @ParameterizedTest(
            name = "{index} => nome={0}, categoria={1}, preco={2}, dia={3}, desconto={4}"
    )
    @DisplayName("deve obter o desconto caso seja comprado no dia em que sua categoria é apta")
    @MethodSource("descontoProvider")
    void test(String nome, Categoria categoria, BigDecimal preco, DayOfWeek dia, BigDecimal desconto) {
        Produto batataInglesa = new Produto(nome, categoria, preco);

        BigDecimal resultado = this.calculadora.desconto(dia, batataInglesa);

        assertEquals(
                preco.multiply(desconto),
                resultado,
                "O resultado deve corresponder ao preco aplicado com desconto"
        );
    }

    @ParameterizedTest(
            name = "{index} => nome={0}, categoria={1}, preco={2}, dia={3}, desconto={4}"
    )
    @DisplayName("nao deve obter o desconto caso seja comprado no dia em que sua categoria não é apta")
    @MethodSource("semDescontoProvider")
    void test2(String nome, Categoria categoria, BigDecimal preco, DayOfWeek dia, BigDecimal desconto) {

        Produto batataInglesa = new Produto(nome, categoria, preco);

        BigDecimal resultado = this.calculadora.desconto(dia, batataInglesa);

        assertEquals(
                preco,
                resultado,
                "O resultado deve corresponder ao preco do produto"
        );
    }

    private static Stream<Arguments> semDescontoProvider() {
        return Stream.of(
                Arguments.of("Batata Inglesa", Categoria.VERDURA, new BigDecimal("10"), DayOfWeek.THURSDAY, new BigDecimal("0.9")),
                Arguments.of("Alcatra Bovina", Categoria.CARNE, new BigDecimal("15"), DayOfWeek.WEDNESDAY, new BigDecimal("0.93")),
                Arguments.of("Colgate Total 12", Categoria.HIGIENE_PESSOAL, new BigDecimal("10"), DayOfWeek.FRIDAY, new BigDecimal("0.95")),
                Arguments.of("OMO MULTIAÇÃO", Categoria.LIMPEZA, new BigDecimal("10"), DayOfWeek.TUESDAY, new BigDecimal("0.96")),
                Arguments.of("Pão Frances", Categoria.PADARIA, new BigDecimal("10"), DayOfWeek.MONDAY, new BigDecimal("0.94"))
        );
    }

    private static Stream<Arguments> descontoProvider() {
        return Stream.of(
                Arguments.of("Batata Inglesa", Categoria.VERDURA, new BigDecimal("10"), DayOfWeek.MONDAY, new BigDecimal("0.9")),
                Arguments.of("Alcatra Bovina", Categoria.CARNE, new BigDecimal("15"), DayOfWeek.TUESDAY, new BigDecimal("0.93")),
                Arguments.of("Colgate Total 12", Categoria.HIGIENE_PESSOAL, new BigDecimal("10"), DayOfWeek.WEDNESDAY, new BigDecimal("0.95")),
                Arguments.of("OMO MULTIAÇÃO", Categoria.LIMPEZA, new BigDecimal("10"), DayOfWeek.THURSDAY, new BigDecimal("0.96")),
                Arguments.of("Pão Frances", Categoria.PADARIA, new BigDecimal("10"), DayOfWeek.FRIDAY, new BigDecimal("0.94"))
        );
    }
}
