package com.example.springmvcrest.repositories;

import com.example.springmvcrest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
