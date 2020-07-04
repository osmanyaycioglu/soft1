package com.soft.msaccount.customer.dao;

import com.soft.msaccount.customer.Customer;

import java.util.List;


public interface ICustomerDAO {

    List<Customer> getAllCustomer();

    void writeCustomer(Customer cust);

}
