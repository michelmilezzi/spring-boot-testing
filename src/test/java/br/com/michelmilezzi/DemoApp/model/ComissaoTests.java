package br.com.michelmilezzi.DemoApp.model;

import br.com.michelmilezzi.DemoApp.domain.Comissao;
import br.com.michelmilezzi.DemoApp.domain.Vendedor;
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
    public void testarSemComissao() {

        Vendedor vendedor = new Vendedor("Juca", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(4999));

        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.ZERO);

    }

    @Test
    public void testarFaixaDe5000() {

        Vendedor vendedor = new Vendedor("Juca", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(9999));

        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(20));

    }

    @Test
    public void testarFaixaDe20000() {

        Vendedor vendedor = new Vendedor("Juca", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(19999));

        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(25));

    }

    @Test
    public void testarFaixaDe30000() {

        Vendedor vendedor = new Vendedor("Juca", BigDecimal.valueOf(1000));
        Comissao comissao = new Comissao(vendedor, BigDecimal.valueOf(29999));

        Assertions.assertThat(comissao.getValorDeComissao())
                .isEqualByComparingTo(BigDecimal.valueOf(30));

    }

}
