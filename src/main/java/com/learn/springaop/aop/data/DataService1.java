package com.learn.springaop.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        return new int[] {17,18,19,54};
    }
}
