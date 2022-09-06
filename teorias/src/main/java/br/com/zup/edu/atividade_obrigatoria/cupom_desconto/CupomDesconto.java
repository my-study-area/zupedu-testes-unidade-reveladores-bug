package br.com.zup.edu.atividade_obrigatoria.cupom_desconto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CupomDesconto {
    private Usuario usuario;
    private Produto produto;
    private BigDecimal porcentagem;
    private LocalDateTime validoAte;

    public CupomDesconto(Usuario usuario, Produto produto, BigDecimal porcentagem, LocalDateTime validoAte) {
        this.usuario = usuario;
        this.produto = produto;
        this.porcentagem = porcentagem;
        this.validoAte = validoAte;
    }

    public boolean isValido() {
        return LocalDateTime.now().compareTo(validoAte) <= 0;
    }

    public boolean pertence(Usuario usuario) {
        return this.usuario.equals(usuario);
    }

    public boolean pertence(Produto produto) {
        return this.produto.equals(produto);
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }
}
