package com.example.springbootbasic.collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class CollectionsConfig {


    @Bean(name = "nameList")
    public List<String> getArrNames() {
        List<String> names = new ArrayList<>();

        names.add("hello");
        names.add("hi");
        names.add("say hi");
        return names;
    }
    @Bean(name = "nameSet")
    public Set<String> getSetNames() {
        Set<String> names = new HashSet<>();

        names.add("hello");
        names.add("hi");
        names.add("say hi");
        return names;
    }

    @Bean(name = "mapPhoneNames")
    public Map<String, Long> getMapPhoneNames() {
        Map<String, Long> mapPhoneNames = new HashMap<>();

        mapPhoneNames.put("Nguyen A", 1234566L);
        mapPhoneNames.put("Nguyen B", 1234567L);
        mapPhoneNames.put("Nguyen C", 1234568L);
        return mapPhoneNames;
    }

    @Bean(name = "address")
    public List<String> getAddress() {
        List<String> addresses = new ArrayList<String>();
        addresses.add("Ha Noi");
        addresses.add("Ha Nam");
        addresses.add("Ha Tay");
        return addresses;
    }
    @Bean(name = "jobs")
    public List<String> getJobs() {
        List<String> jobs = new ArrayList<>();
        jobs.add("Ha Noi");
        jobs.add("Ha Nam");
        jobs.add("Ha Tay");
        return jobs;
    }



}
