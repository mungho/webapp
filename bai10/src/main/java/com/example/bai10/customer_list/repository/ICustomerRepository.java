package com.example.bai10.customer_list.controller.repository;

import com.example.bai10.customer_list.controller.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    public List<Customer> getAll();
}
