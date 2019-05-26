package br.com.michelmilezzi.DemoApp.service.impl;

import br.com.michelmilezzi.DemoApp.domain.Tax;
import br.com.michelmilezzi.DemoApp.repository.TaxRepository;
import br.com.michelmilezzi.DemoApp.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TaxServiceImpl implements TaxService {

    @Autowired
    private TaxRepository taxRepository;

    @Override
    public Tax findByRatioLessThanEqual(BigDecimal ratio) {
        return taxRepository.findByRatioLessThanEqual(ratio);
    }

}
