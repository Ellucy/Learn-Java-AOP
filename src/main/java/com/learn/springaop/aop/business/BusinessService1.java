package com.learn.springaop.aop.business;

import com.learn.springaop.aop.annotations.TrackTime;
import com.learn.springaop.aop.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() throws InterruptedException {
        int[] data = dataService1.retrieveData();

        Thread.sleep(30);
//        @After is called both for successful executions and for executions that throw an exception.
//        throw new RuntimeException("Something went wrong!");
        return Arrays.stream(data).max().orElse(0);
    }
}
