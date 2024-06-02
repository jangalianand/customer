package com.customer.cust.service;

import com.customer.cust.exception.CustomerNotFoundException;
import com.customer.cust.repo.CustomerRepository;
import com.customer.cust.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        log.info("getAllCustomers(-) started");
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        log.info("getCustomerById(-) started");
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    public Customer saveCustomer(Customer customer) {
        log.info("saveCustomer(-) started");
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        log.info("deleteCustomer(-) started");
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }
}

