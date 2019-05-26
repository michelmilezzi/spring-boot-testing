package br.com.michelmilezzi.DemoApp.repository;

import br.com.michelmilezzi.DemoApp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

}
