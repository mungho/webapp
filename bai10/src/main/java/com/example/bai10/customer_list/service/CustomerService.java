package com.example.bai10.customer_list.controller.service;

import com.example.bai10.customer_list.controller.model.Customer;
import com.example.bai10.customer_list.controller.repository.CustomerRepository;
import com.example.bai10.customer_list.controller.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.getAll();
    }
}
