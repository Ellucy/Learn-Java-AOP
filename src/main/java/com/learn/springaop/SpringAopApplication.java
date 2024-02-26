package com.learn.springaop;

import com.learn.springaop.aop.business.BusinessService1;
import com.learn.springaop.aop.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private BusinessService1 businessService1;
    private BusinessService2 businessService2;

    public SpringAopApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
        this.businessService1 = businessService1;
        this.businessService2 = businessService2;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("BusinessService1 value returned is {} 🤖", businessService1.calculateMax());
        logger.info("BusinessService2 value returned is {} 🤖", businessService2.calculateMin());
    }
}
