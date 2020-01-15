package com.example.springmvcrest.bootstrap;

import com.example.springmvcrest.domain.Customer;
import com.example.springmvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private  final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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

    }
}
