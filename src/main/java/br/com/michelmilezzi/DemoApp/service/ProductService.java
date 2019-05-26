package br.com.michelmilezzi.DemoApp.service;

import br.com.michelmilezzi.DemoApp.domain.Product;

import java.util.List;

public interface ProductService {

    Product getProductByName(String name);

    Product save(Product product);

    List<Product> getAllProducts();
}
