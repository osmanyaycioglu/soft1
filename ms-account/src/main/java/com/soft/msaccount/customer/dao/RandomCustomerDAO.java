package com.soft.msaccount.customer.dao;

import com.soft.msaccount.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomCustomerDAO implements ICustomerDAO {

    @Override
    public List<Customer> getAllCustomer() {
        Random randomLoc = new Random();
        int nextIntLoc = randomLoc.nextInt(10);
        List<Customer> customerListLoc = new ArrayList<>();
        for (int iLoc = 0; iLoc < (nextIntLoc + 1); iLoc++) {
            customerListLoc.add(new Customer().setCustomerId(iLoc)
                                              .setName("osman" + randomLoc.nextInt())
                                              .setSurname("" + randomLoc.nextInt())
                                              .setCreditCard("" + randomLoc.nextLong()));

        }
        return customerListLoc;
    }

    @Override
    public void writeCustomer(final Customer cust) {

    }

}
