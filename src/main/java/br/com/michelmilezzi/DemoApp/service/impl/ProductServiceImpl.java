package br.com.michelmilezzi.DemoApp.service.impl;

import br.com.michelmilezzi.DemoApp.domain.Product;
import br.com.michelmilezzi.DemoApp.repository.ProductRepository;
import br.com.michelmilezzi.DemoApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
