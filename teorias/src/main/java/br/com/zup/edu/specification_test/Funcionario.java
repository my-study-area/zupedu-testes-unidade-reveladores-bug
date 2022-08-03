package br.com.zup.edu.specification_test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {
    private Long id;
    private String nome;
    private BigDecimal salario;
    private LocalDate dataAdmissao;

    public Funcionario(){}

    public Funcionario(Long id, String nome, BigDecimal salario, LocalDate dataAdmissao){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}
