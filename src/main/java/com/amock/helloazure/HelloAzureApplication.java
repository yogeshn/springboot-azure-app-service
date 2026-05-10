package com.amock.helloazure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HelloAzureApplication {

	private static final Logger logger = LoggerFactory.getLogger(HelloAzureApplication.class);

	public static void main(String[] args) {
		logger.info("Starting HelloAzureApplication on Java {}", System.getProperty("java.version"));
		SpringApplication.run(HelloAzureApplication.class, args);
	}

	@PostConstruct
	public void logJavaRuntime() {
		logger.info("Detected Java runtime: {}", System.getProperty("java.version"));
	}

	@Controller
	class WebController {
		
		@GetMapping
		public String home(){
			return "index";
		}
	}
}
