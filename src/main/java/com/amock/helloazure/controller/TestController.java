package com.amock.helloazure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amock.helloazure.model.MyName;

@RestController
@RequestMapping("/")
public class TestController {
	
	@GetMapping("test")
	public String test() {
		return "Hello Kalyan. This is version 2";
	}
	
	@GetMapping("test2")
	public String test2() {
		return "Hello Kalyan2";
	}

	@PostMapping("testpost")
	public ResponseEntity<MyName> testpost(@RequestBody MyName name) {
		return new ResponseEntity<MyName>(name, HttpStatus.OK);
	}
}
