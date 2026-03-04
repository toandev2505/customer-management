package com.customerproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPI {
    @GetMapping("test")
    public String greet(){
        return "hello";
    }
}
