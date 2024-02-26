package com.learn.springaop.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    public int[] retrieveData() {
        return new int[]{117, 118, 119, 154};
    }
}
