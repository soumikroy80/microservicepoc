package com.ssg.microservice.configserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.EmployeeSearchService.EmployeeSearchServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=EmployeeSearchServiceApplication.class)
public class ConfigServerTests {

	@Test
	public void contextLoads() {
	}

}
