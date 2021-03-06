package com.example.springmvcrest.controllers;

import com.example.springmvcrest.domain.Product;
import com.example.springmvcrest.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {

    public final static String BASE_URL = "/api/v1/product/";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "deleted successfully";
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateCustomer(id,product);
    }
}
