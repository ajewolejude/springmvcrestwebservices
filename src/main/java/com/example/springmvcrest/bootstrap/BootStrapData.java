package com.example.springmvcrest.bootstrap;

import com.example.springmvcrest.domain.Customer;
import com.example.springmvcrest.domain.Product;
import com.example.springmvcrest.repositories.CustomerRepository;
import com.example.springmvcrest.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private  final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    public BootStrapData(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Customer Data");

        Customer c1 = new Customer();
        c1.setFirstname("Adedamola");
        c1.setLastname("Ajewole");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstname("Oluwanifemi");
        c2.setLastname("Adewale");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setFirstname("Romman");
        c3.setLastname("Josh");
        customerRepository.save(c3);

        System.out.println("Customer saved : "+customerRepository.count());


        Product p1 = new Product();
        p1.setName("Fishes");
        p1.setPrice((long) 100);
        p1.setCategory("Foods");
        p1.setQuantity(200);
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setName("Bucket");
        p2.setPrice((long) 100);
        p2.setCategory("Tools");
        p2.setQuantity(200);
        productRepository.save(p2);

        Product p3 = new Product();
        p3.setName("Nike");
        p3.setPrice((long) 100);
        p3.setCategory("Footwear");
        p3.setQuantity(200);
        productRepository.save(p3);

        System.out.println("Products saved : "+productRepository.count());

    }
}
