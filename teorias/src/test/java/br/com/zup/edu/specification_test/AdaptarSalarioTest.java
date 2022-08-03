package br.com.zup.edu.specification_test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdaptarSalarioTest {

    private AdaptarSalario adaptarSalario;
    private Map<Long, Funcionario> funcionarios;

    @BeforeEach
    public void setUp(){
        Funcionario rafael = new Funcionario(1L,"Rafael Ponte",new BigDecimal("1000"), LocalDate.of(2017, 5, 26));
        Funcionario yuri = new Funcionario(2L,"Yuri Matheus",new BigDecimal("1000"), LocalDate.now());
        this.funcionarios = Map.of(
                rafael.getId() , rafael,
                yuri.getId(), yuri
        );

        this.adaptarSalario = new AdaptarSalario(funcionarios);
    }

    @Test
    @DisplayName("o id nao pode ser menor que um")
    void oIdNaoPodeSerMenorQueUm() {
        IdInvalidoException idInvalidoException = assertThrows(IdInvalidoException.class, () -> {
            this.adaptarSalario.adapta(0L);
        });

        assertEquals("o id deve ser maior igual a um", idInvalidoException.getMessage());
    }

    @Test
    @DisplayName("o id nao pode ser nulo")
    void oIdNaoPodeSerNulo() {
        IdInvalidoException idInvalidoException = assertThrows(IdInvalidoException.class, () -> {
            this.adaptarSalario.adapta(null);
        });

        assertEquals("o id nao deve ser nulo", idInvalidoException.getMessage());
    }

    @Test
    @DisplayName("nao deve ter o salario reajustado quando funcionario tem menos de um ano de contrato")
    void naoDeveTerOSalarioReajustadoQuandoFuncionarioTemMenosDeUmAnoDeContrato() {
        Funcionario funcionario = funcionarios.get(2L);
        BigDecimal antesDaAdptacao = funcionario.getSalario();

        this.adaptarSalario.adapta(funcionario.getId());
        assertEquals(antesDaAdptacao,funcionario.getSalario());
    }

    @Test
    @DisplayName("deve ter o salario reajustado quando funcionario tem mais de um ano de contrato")
    void deveTerOSalarioReajustadoQuandoFuncionarioTemMaisDeUmAnoDeContrato() {
        Funcionario funcionario = funcionarios.get(1L);
        BigDecimal antesDaAdptacao = funcionario.getSalario();

        this.adaptarSalario.adapta(funcionario.getId());
        assertEquals(antesDaAdptacao.multiply( new BigDecimal("1.1")),funcionario.getSalario());
    }
}
