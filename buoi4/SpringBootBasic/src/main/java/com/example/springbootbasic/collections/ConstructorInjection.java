package com.example.springbootbasic.collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class ConstructorInjection {

    private List<String> nameList;
    private Set<String> setName;

    private Map<String, Long> mapPhoneNames;

    @Autowired
    public ConstructorInjection(
            @Qualifier("nameList") List<String> nameList,
            @Qualifier("nameSet")Set<String> setName,
            @Qualifier("mapPhoneNames")Map<String, Long> mapPhoneNames) {
        this.nameList = nameList;
        this.setName = setName;
        this.mapPhoneNames = mapPhoneNames;
    }
}
