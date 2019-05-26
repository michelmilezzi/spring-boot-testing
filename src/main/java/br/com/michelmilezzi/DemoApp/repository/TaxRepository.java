package br.com.michelmilezzi.DemoApp.repository;

import br.com.michelmilezzi.DemoApp.domain.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {

    Tax findByRatioLessThanEqual(BigDecimal ratio);

}
