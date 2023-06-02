package com.example.springbootbasic.collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class FieldInjection {

    @Autowired
    private List<String> nameList;
    @Autowired
    private Set<String> setName;
    @Autowired
    private Map<String, Long> mapPhoneNames;

}
