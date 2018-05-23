package com.ssg.microservice.configserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssg.microservice.empeureka.EmployeeEurekaServerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeEurekaServerApplication.class)
public class ConfigServerTests {

	@Test
	public void contextLoads() {
	}

}
