package com.example.springmvcrest.services;

import com.example.springmvcrest.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    void deleteProduct(Long id);

    Product saveProduct(Product product);

    Product updateCustomer(Long id, Product product);




}
