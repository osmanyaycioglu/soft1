package com.soft.order.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(name = "account", configuration = RibbonConfig.class)
// @RibbonClients({@RibbonClient(name = "account", configuration = RibbonConfig.class)})
public class OrderConfig {

    @Bean
    @LoadBalanced
    @Qualifier("loadbalanced")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    @Qualifier("direct")
    public RestTemplate directRestTemplate(){
        return new RestTemplate();
    }

}
