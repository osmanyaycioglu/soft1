package com.soft.msaccount.order.rest;

import com.soft.msaccount.charging.PaymentManager;
import com.soft.msaccount.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderChargingRest {

    @Autowired
    private PaymentManager payment;

    @Value("${server.port}")
    private int     port;

    @PostMapping("/pay")
    public String pay(@RequestBody final Order orderParam) {
        if (this.payment.pay(orderParam)) {
            return "OK " + this.port;
        } else {
            return "FAIL " + this.port;
        }
    }
}
