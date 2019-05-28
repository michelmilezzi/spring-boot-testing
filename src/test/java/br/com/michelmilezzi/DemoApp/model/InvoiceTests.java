package br.com.michelmilezzi.DemoApp.model;


import br.com.michelmilezzi.DemoApp.domain.Invoice;
import br.com.michelmilezzi.DemoApp.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceTests {

    @Test
    public void calculaTotalTests() {
        Invoice invoice = new Invoice(LocalDateTime.now());

        invoice.addItem(new Product("Product1"), 5L, BigDecimal.ONE);
        invoice.addItem(new Product("Product2"), 10L, BigDecimal.ONE);
        invoice.addItem(new Product("Product3"), 15L, BigDecimal.ONE);

        assertThat(invoice.getTotal())
                .isEqualByComparingTo(BigDecimal.valueOf(30));
    }

}
