package com.soft.order.rest;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.soft.order.Order;
import com.soft.order.clients.IAccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
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
        String sLoc = directRT.postForObject("http://" + instancesLoc.get(0).getIPAddr() + ":" + instancesLoc.get(0).getPort() + "/account/payment",
                                             order,
                                             String.class);
        return sLoc;
    }

}
