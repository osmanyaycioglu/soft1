package com.soft.order.rest;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.soft.order.Order;
import com.soft.order.clients.IAccountClient;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrederRest {

    @Autowired
    @Qualifier("loadbalanced")
    private RestTemplate rt;

    @Autowired
    @Qualifier("direct")
    private RestTemplate directRT;

    @Autowired
    private EurekaClient ec;

    @Autowired
    private IAccountClient accountClient;

    private int counter = 0;

    @Autowired
    private KafkaTemplate kt;

    @Value("${my.prop.name}")
    private String myName;

    @HystrixCommand(fallbackMethod = "testFallback",
                    commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                         value = "500"))
    @GetMapping("/test")
    public String test() {
        Random randomLoc = new Random();
        String str = "hello world test " + randomLoc.nextInt(100_000);
        kt.send("xyzTopic",str );
        counter++;
        if (counter % 3 == 0) {
            throw new IllegalStateException();
        }
        if (counter % 5== 0) {
            try {
                Thread.sleep(1_000);
            }catch (Exception ex){

            }
        }

        return "Test OK " + myName;
    }


    public String testFallback() {
        return "Fallback Test OK " + myName;
    }

    @PostMapping("/meal")
    public String orderMeal(@RequestBody Order order) {
        return accountClient.payment(order);
    }

    @PostMapping("/meal2")
    public String orderMeal2(@RequestBody Order order) {
        String sLoc = rt.postForObject("http://ACCOUNT/account/payment",
                                       order,
                                       String.class);
        return sLoc;
    }

    @PostMapping("/meal3")
    public String orderMeal3(@RequestBody Order order) {
        InstanceInfo infoLoc = ec.getNextServerFromEureka("ACCOUNT",
                                                          false);
        String sLoc = directRT.postForObject("http://" + infoLoc.getIPAddr() + ":" + infoLoc.getPort() + "/account/payment",
                                             order,
                                             String.class);
        return sLoc;
    }

    @PostMapping("/meal4")
    public String orderMeal4(@RequestBody Order order) {
        Application applicationLoc = ec.getApplication("ACCOUNT");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo infoLoc : instancesLoc) {
            System.out.println(" ACCOUNT Intance : " + infoLoc);
        }
        InstanceInfo infoLoc = ec.getNextServerFromEureka("ACCOUNT",
                                                          false);
        String sLoc = directRT.postForObject("http://" + instancesLoc.get(0)
                                                                     .getIPAddr() + ":" + instancesLoc.get(0)
                                                                                                      .getPort() + "/account/payment",
                                             order,
                                             String.class);
        return sLoc;
    }

}
