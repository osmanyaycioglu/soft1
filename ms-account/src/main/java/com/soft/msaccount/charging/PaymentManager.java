package com.soft.msaccount.charging;

import com.soft.msaccount.customer.Customer;
import com.soft.msaccount.customer.CustomerManager;
import com.soft.msaccount.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentManager {

    @Autowired
    private CustomerManager customerManager;

    @Autowired
    private ChargingManager chargingManager;

    public boolean pay(final Order orderParam) {
        Customer customerLoc = this.customerManager.getCustomer(orderParam.getCustomerId());
        return this.chargingManager.charge(customerLoc,
                                           orderParam);
    }

}
