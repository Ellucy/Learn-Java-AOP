package com.learn.springaop.aop.data;

import com.learn.springaop.aop.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    @TrackTime
    public int[] retrieveData() {
        return new int[]{117, 118, 119, 154};
    }
}
