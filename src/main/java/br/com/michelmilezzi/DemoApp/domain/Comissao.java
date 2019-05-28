package br.com.michelmilezzi.DemoApp.domain;

import java.math.BigDecimal;

public class Comissao {

    private static final BigDecimal VALOR_DE_VENDAS_ELEGIVEL_PARA_BONUS = BigDecimal.valueOf(30000);
    private static final BigDecimal VALOR_DE_BONUS = BigDecimal.valueOf(1000);

    private Vendedor vendedor;
    private BigDecimal valorTotalDeVendas;

    public Comissao(Vendedor vendedor, BigDecimal valorTotalDeVendas) {
        this.vendedor = vendedor;
        this.valorTotalDeVendas = valorTotalDeVendas;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public BigDecimal getValorTotalDeVendas() {
        return valorTotalDeVendas;
    }

    public BigDecimal getValorDeComissao() {

        BigDecimal comissao = getVendedor()
                .getSalario()
                .multiply(getPercentualDeComissao());

        if (getValorTotalDeVendas().compareTo(VALOR_DE_VENDAS_ELEGIVEL_PARA_BONUS) > 0) {
            return comissao.add(VALOR_DE_BONUS);
        }

        return comissao;
    }

    public BigDecimal getPercentualDeComissao() {

        if (this.valorTotalDeVendas.compareTo(BigDecimal.valueOf(5000)) < 0) {
            return BigDecimal.ZERO;
        }

        if (this.valorTotalDeVendas.compareTo(BigDecimal.valueOf(10000)) <= 0) {
            return BigDecimal.valueOf(0.02);
        }

        if (this.valorTotalDeVendas.compareTo(BigDecimal.valueOf(20000)) <= 0) {
            return BigDecimal.valueOf(0.025);
        }

        if (this.valorTotalDeVendas.compareTo(BigDecimal.valueOf(30000)) <= 0) {
            return BigDecimal.valueOf(0.03);
        }

        return BigDecimal.valueOf(0.05);
    }

}
