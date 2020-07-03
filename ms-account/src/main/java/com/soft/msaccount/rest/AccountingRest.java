package com.soft.msaccount.rest;

import com.soft.msaccount.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountingRest {

    @Value("${server.port}")
    private int port;

    @PostMapping("/payment")
    public String payment(@RequestBody Order orderParam){
        return "OK " + port;
    }

}
