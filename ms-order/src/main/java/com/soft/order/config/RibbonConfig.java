package com.soft.order.config;


import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;

public class RibbonConfig {
    @Bean
    public IRule myRule(){
        return new BestAvailableRule();
    }

    @Bean
    public IPing myPing(){
        return new NoOpPing();
    }
}
