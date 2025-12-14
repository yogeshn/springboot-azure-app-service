package com.amock.helloazure.controller;

import com.amock.helloazure.model.MyName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        try {
            return "Hello from TestController";
        } catch (Exception e) {
            // Log or handle exception appropriately
            return "Error occurred";
        }
    }

    @PostMapping("/name")
    public MyName handleName(@RequestBody MyName name) {
        try {
            // Preserve original logic: simply return the input for testing
            return name;
        } catch (Exception e) {
            // Log or handle exception appropriately
            return new MyName("Error", "Occurred");
        }
    }
}
