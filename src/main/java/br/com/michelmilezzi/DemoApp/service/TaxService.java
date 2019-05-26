package br.com.michelmilezzi.DemoApp.service;

import br.com.michelmilezzi.DemoApp.domain.Tax;

import java.math.BigDecimal;

public interface TaxService {
    Tax findByRatioLessThanEqual(BigDecimal ratio);
}
