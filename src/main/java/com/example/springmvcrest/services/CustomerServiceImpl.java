package com.example.springmvcrest.services;

import com.example.springmvcrest.domain.Customer;
import com.example.springmvcrest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer( Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer newCustomer) {
        return customerRepository.findById(id).map(customer -> {
            customer.setFirstname(newCustomer.getFirstname());
            customer.setLastname(newCustomer.getLastname());
            return customerRepository.save(customer);
        }).orElseGet(() -> {
            newCustomer.setId(id);
            return customerRepository.save(newCustomer);
        });
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
