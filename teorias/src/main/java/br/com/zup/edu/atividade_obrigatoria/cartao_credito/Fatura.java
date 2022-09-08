package br.com.zup.edu.atividade_obrigatoria.cartao_credito;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Fatura {

    private Cartao cartao;
    private YearMonth mesAno;
    private List<Gasto> gastos = new ArrayList<>();

    public Fatura(Cartao cartao, YearMonth mesAno) {
        this.cartao = cartao;
        this.mesAno = mesAno;
    }

    public void adicionar(Gasto gasto) {
        this.gastos.add(gasto);
    }

    public BigDecimal getValor() {
        return gastos.stream()
                .map(Gasto::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public YearMonth getMesAno() {
        return mesAno;
    }

}
