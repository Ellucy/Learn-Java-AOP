package com.learn.springaop.aop.business;

import com.learn.springaop.aop.data.DataService1;
import com.learn.springaop.aop.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    private DataService2 dataService2;

    public BusinessService2(DataService2 dataService2) {
        this.dataService2 = dataService2;
    }

    public int calculateMin() throws InterruptedException {
        int[] data = dataService2.retrieveData();

        Thread.sleep(30);
        return Arrays.stream(data).min().orElse(0);
    }
}
