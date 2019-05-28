package br.com.michelmilezzi.DemoApp.domain;

import java.math.BigDecimal;

public class Comissao {

    public static final int BONUS = 1000;
    public static final int VALOR_ELEGIVEL_PARA_BONUS = 30000;
    private Vendedor vendedor;
    private BigDecimal valorTotalDeVendas;

    public Comissao(Vendedor vendedor, BigDecimal valorTotalDeVendas) {
        this.vendedor = vendedor;
        this.valorTotalDeVendas = valorTotalDeVendas;
    }

    public BigDecimal getValorDeComissao() {
        BigDecimal comissao = this.vendedor.getSalario()
                .multiply(getPercentualDeComissao());

        if (valorTotalDeVendas.compareTo(BigDecimal.valueOf(VALOR_ELEGIVEL_PARA_BONUS)) > 0) {
            comissao.add(BigDecimal.valueOf(BONUS));
        }

        return comissao;
    }

    public BigDecimal getPercentualDeComissao() {

        if (valorTotalDeVendas.compareTo(BigDecimal.valueOf(5000)) <= 0) {
            return BigDecimal.ZERO;
        }

        if (valorTotalDeVendas.compareTo(BigDecimal.valueOf(10000)) <= 0) {
            return BigDecimal.valueOf(0.02D);
        }

        if (valorTotalDeVendas.compareTo(BigDecimal.valueOf(20000)) <= 0) {
            return BigDecimal.valueOf(0.025D);
        }

        if (valorTotalDeVendas.compareTo(BigDecimal.valueOf(30000)) <= 0) {
            return BigDecimal.valueOf(0.03D);
        }

        return BigDecimal.valueOf(0.05D);

    }

}
