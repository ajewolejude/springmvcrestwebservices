package com.example.springmvcrest.services;

import com.example.springmvcrest.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    Customer findCustomerById(Long id);

    List<Customer> getAllCustomer();

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}
