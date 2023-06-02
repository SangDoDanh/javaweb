package com.example.springbootbasic.collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Person {

    @Autowired
    @Qualifier("address")
    private List<String> address;

    @Autowired
    @Qualifier("jobs")
    private List<String> jobs;

    private  String name;

    public Person() {
    }

    public void setAddress(String address) {
        this.address.add(address);
    }

    public void  setJobs(String job) {
        this.jobs.add(job);
    }
}
