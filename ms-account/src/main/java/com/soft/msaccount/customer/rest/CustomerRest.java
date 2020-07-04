package com.soft.msaccount.customer.rest;

import com.soft.msaccount.customer.Customer;
import com.soft.msaccount.customer.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerRest {

    @Autowired
    private CustomerManager customerManager;

    @GetMapping("/getall")
    public List<Customer> getAll() {
        return this.customerManager.getAllCustomers();
    }

}
