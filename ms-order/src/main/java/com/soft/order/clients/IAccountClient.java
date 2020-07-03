package com.soft.order.clients;

import com.soft.order.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "account")
@RequestMapping("/account")
public interface IAccountClient {

    @PostMapping("/payment")
    public String payment(@RequestBody Order orderParam);

}
