package br.com.michelmilezzi.DemoApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal ratio;

    private BigDecimal value;

    public Tax() {

    }

    public Tax(BigDecimal ratio, BigDecimal value) {
        this.ratio = ratio;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public BigDecimal getValue() {
        return value;
    }
}
