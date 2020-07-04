package com.soft.msaccount.customer.config;

import com.soft.msaccount.customer.CustomerManager;
import com.soft.msaccount.customer.dao.FileCustomerDAO;
import com.soft.msaccount.customer.dao.ICustomerDAO;
import com.soft.msaccount.customer.dao.RandomCustomerDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
public class CustomerAppConfig {


    // @Value("${customer.dao.impl}")
    private int implChooser = 1;


    @Bean
    public ICustomerDAO genCustDAO() {
        switch (this.implChooser) {
            case 1:
                return new RandomCustomerDAO();
            case 2:
                return new FileCustomerDAO();

            default:
                return new RandomCustomerDAO();
        }

    }

    @Bean
    // @Scope("prototype")
    @Qualifier("osman")
    public ICustomerDAO ranCustDAO() {
        return new FileCustomerDAO();
    }

    @Bean
    // @Primary
    public ICustomerDAO fileCustDAO() {
        return new FileCustomerDAO();
    }

    @Bean
    public CustomerManager customerManager(@Qualifier("osman") final ICustomerDAO customerDAOParam) {
        return new CustomerManager(customerDAOParam);
    }


}
