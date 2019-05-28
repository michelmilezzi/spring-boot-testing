package br.com.michelmilezzi.DemoApp.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComissaoTests {

    @Test
    public void vendedorNaoRecebeComissaoTests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(4999));
        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void vendedorRecebeComissaoNaFaixaDe10000Tests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(9999));
        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(20));
    }

    @Test
    public void vendedorRecebeComissaoNaFaixaDe20000Tests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(19999));
        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(25));
    }

    @Test
    public void vendedorRecebeComissaoNaFaixaDe30000Tests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(29999));
        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(30));
    }

    @Test
    public void vendedorRecebeComissaoAcimaDe30000Tests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(31999));
        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(1050));
    }

    @Test
    public void percentualDeComissaoZeradoTests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(4999));
        Assertions.assertThat(comissao.getPercentualDeComissao())
                .isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void percentualDeComissaoDaFaixaDe10000Tests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(9999));
        Assertions.assertThat(comissao.getPercentualDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(0.02));
    }

    @Test
    public void percentualDeComissaoNaFaixaDe20000Tests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(19999));
        Assertions.assertThat(comissao.getPercentualDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(0.025));
    }

    @Test
    public void percentualDeComissaoNaFaixaDe30000Tests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(29999));
        Assertions.assertThat(comissao.getPercentualDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(0.03));
    }

    @Test
    public void percentualDeComissaoAcimaDe30000Tests() {
        Vendedor vendedor = new Vendedor("Vendedor 1", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(31999));
        Assertions.assertThat(comissao.getPercentualDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(0.05));
    }

}
