package br.com.michelmilezzi.DemoApp.repository;

import br.com.michelmilezzi.DemoApp.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByNameThenReturnProduct() {

        Product product = new Product("Product1");
        entityManager.persist(product);
        entityManager.flush();

        Product found = productRepository.findByName(product.getName());

        Assertions.assertThat(found.getName())
                .isEqualTo(product.getName());

    }

}
