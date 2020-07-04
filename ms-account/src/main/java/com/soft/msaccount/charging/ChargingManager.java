package com.soft.msaccount.charging;

import com.soft.msaccount.customer.Customer;
import com.soft.msaccount.order.Order;
import org.springframework.stereotype.Service;

@Service
public class ChargingManager {

    public boolean charge(final Customer customerParam,
                          final Order orderParam) {
        return true;
    }

}
