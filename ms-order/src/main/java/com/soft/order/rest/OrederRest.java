package com.soft.order.rest;

import com.soft.order.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrederRest {

    @PostMapping("/meal")
    public String orderMeal(@RequestBody Order order){
        return "OK";
    }
}
