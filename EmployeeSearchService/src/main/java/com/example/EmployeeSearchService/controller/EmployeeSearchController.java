/**
 * 
 */
package com.example.EmployeeSearchService.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeSearchService.domain.model.Employee;
import com.example.EmployeeSearchService.service.AppProperties;
import com.example.EmployeeSearchService.service.EmployeeSearchService;

@RefreshScope
@RestController
public class EmployeeSearchController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeSearchController.class); 
	
    @Value("${employyesearch.name:default}")
    private String personName;
	
	@Autowired
	EmployeeSearchService employeeSearchService;
	
	AppProperties appProperties;
	
	@Autowired
    public void setApp(AppProperties app) {
        this.appProperties = app;
    }

	@RequestMapping(path="/employee/find/{id2}", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee findById(@PathVariable Long id2) {
		logger.info(appProperties.toString());
		return employeeSearchService.findById(id2);
	}

	@RequestMapping(path="/employee/findall", produces= "application/json")
	@ResponseBody
	public Collection<Employee> findAll() {
		logger.info("#FINDALL:"+appProperties.toString());
		return employeeSearchService.findAll();
	}
	
    @RequestMapping("/greeting")
    public String greet(){
    	logger.info("#GREETING"+appProperties.getCompiler().keySet().toString());
        return "hello " + personName;
    }
    
    @RequestMapping("/appProperties")
    public String greetProp(){
    	String appPropertiesVal = appProperties.toString();
    	logger.info(appPropertiesVal);
        return "hello " + appPropertiesVal;
    }
	
	
}	
