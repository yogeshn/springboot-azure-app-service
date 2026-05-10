package com.amock.helloazure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloAzureApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HelloAzureApplicationTests {

	@Test
	public void contextLoads() {
		org.junit.Assert.assertNotNull(System.getProperty("java.specification.version"));
	}

}
