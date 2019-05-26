package br.com.michelmilezzi.DemoApp.service;


import br.com.michelmilezzi.DemoApp.exception.InvalidInvoiceException;
import br.com.michelmilezzi.DemoApp.domain.Invoice;
import br.com.michelmilezzi.DemoApp.domain.Product;
import br.com.michelmilezzi.DemoApp.domain.Tax;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceServiceImplTests {

    private static Logger logger = LoggerFactory.getLogger(InvoiceServiceImplTests.class);

    @Autowired
    private InvoiceService invoiceService;

    @MockBean
    private TaxService taxService;

    @BeforeClass
    public static void beforeAll() {
        logger.info("Called beforeAll@BeforeClass");
    }

    @Before
    public void setUp() {
        logger.info("Called setUp@Before");
        Tax tax = new Tax(BigDecimal.ONE, BigDecimal.valueOf(0.2));
        when(taxService.findByRatioLessThanEqual(BigDecimal.valueOf(5))).thenReturn(tax);
    }

    @Test
    public void calculateTaxesTests() {
        Invoice invoice = new Invoice(LocalDateTime.now());
        invoice.addItem(new Product("Product1"), 5L, BigDecimal.ONE);
        invoiceService.calculateTaxes(invoice);
        assertThat(invoice.getTax()).isEqualByComparingTo(BigDecimal.ONE);
    }

    @Test
    public void validationTests() {
        try {
            invoiceService.validateInvoice(new Invoice(LocalDateTime.now()));
        } catch (Exception e) {
            assertThat(e).isInstanceOf(InvalidInvoiceException.class);
            assertThat(e).hasNoCause();
            assertThat(e).hasMessageContaining("Invalid Invoice");
        }
    }

    @Test
    public void calculateSomethingComplexEqualityTest() {
        final Double calculated = invoiceService.calculateSomethingComplex(new Invoice(LocalDateTime.now()));
        assertThat(calculated).isEqualTo(10.4D, offset(0.3D));
    }

    @Test
    public void calculateSomethingComplexWithOffsetTest() {
        final Double calculated = invoiceService.calculateSomethingComplex(new Invoice(LocalDateTime.now()));
        assertThat(calculated).isCloseTo(10.4D, within(0.3D));
        assertThat(calculated).isCloseTo(10.4D, withinPercentage(2D));
        assertThat(calculated).isNotCloseTo(10.4D, withinPercentage(1D));
    }

    @Test
    public void calculateSomethingComplexGreaterThanTest() {
        final Double calculated = invoiceService.calculateSomethingComplex(new Invoice(LocalDateTime.now()));
        assertThat(calculated).isGreaterThan(10D);
        assertThat(calculated).isGreaterThanOrEqualTo(10.2D);
        assertThat(calculated).isPositive();
    }

    @After
    public void tearDown() {
        logger.info("Called tearDown@After");
    }

}
