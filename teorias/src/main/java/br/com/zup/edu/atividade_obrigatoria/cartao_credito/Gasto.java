package br.com.zup.edu.atividade_obrigatoria.cartao_credito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Gasto {

    private UUID id;
    private BigDecimal valor;
    private final LocalDateTime criadoEm = LocalDateTime.now();

    public Gasto(BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

}


