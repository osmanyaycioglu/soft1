package com.soft.msaccount.rest;

import com.soft.msaccount.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountingRest {

    @PostMapping("/payment")
    public String payment(Order orderParam){
        return "OK";
    }

}
