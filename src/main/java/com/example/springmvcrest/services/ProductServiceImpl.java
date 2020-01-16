package com.example.springmvcrest.services;

import com.example.springmvcrest.domain.Product;
import com.example.springmvcrest.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product updateCustomer(Long id, Product newProduct) {
        return productRepository.findById(id).map(product1 -> {
            product1.setName(newProduct.getName());
            product1.setCategory(newProduct.getCategory());
            product1.setPrice(newProduct.getPrice());
            product1.setQuantity(newProduct.getQuantity());

            return productRepository.save(product1);
        }).orElseGet(() -> {
            newProduct.setId(id);
            return productRepository.save(newProduct);
        });
    }
}
