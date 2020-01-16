package com.example.springmvcrest.controllers;

import com.example.springmvcrest.domain.Customer;
import com.example.springmvcrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getAllCustomers(){
       return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    Customer getCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customer saveCustomer(@RequestBody Customer customer){
         return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    String deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return "succcessfully deleted";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

}
