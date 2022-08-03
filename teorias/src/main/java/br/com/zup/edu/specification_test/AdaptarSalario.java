package br.com.zup.edu.specification_test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

public class AdaptarSalario {
    private Map<Long, Funcionario> funcionarios;

    public AdaptarSalario(Map<Long, Funcionario> funcionarios){
        this.funcionarios = funcionarios;
    }


    public void adapta(Long id){
        if(id == null){
            throw new IdInvalidoException("o id nao deve ser nulo");
        }

        if(id < 1L){
            throw new IdInvalidoException("o id deve ser maior igual a um");
        }

        Funcionario funcionario = funcionarios.get(id);

        LocalDate dataAdmissao = funcionario.getDataAdmissao();
        LocalDate hoje = LocalDate.now();
        int anos = Period
                .between(dataAdmissao, hoje)
                .getYears();

        if(anos >= 1){
            BigDecimal salario =  funcionario.getSalario();
            BigDecimal salarioComAumento = salario.multiply(new BigDecimal("1.1"));
            funcionario.setSalario(salarioComAumento);
        }

    }
}
