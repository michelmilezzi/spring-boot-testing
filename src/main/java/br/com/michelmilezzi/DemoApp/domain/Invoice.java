package br.com.michelmilezzi.DemoApp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime date;

    private BigDecimal total;

    private BigDecimal tax;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItem> items;

    public Invoice(final LocalDateTime date) {
        this.date = date;
        this.total = BigDecimal.ZERO;
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public BigDecimal addItem(final Product product, final Long quantity, final BigDecimal unitPrice) {
        this.items.add(new InvoiceItem(this, product, quantity, unitPrice));
        this.total = items.stream()
                .map(InvoiceItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return getTotal();
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

}
