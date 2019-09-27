package org.employeeRestApi.controller;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;
import org.employeeRestApi.entity.Device;
import org.employeeRestApi.entity.Employee;
import org.employeeRestApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class AppController {

    @Autowired
    EmployeeRepository employeeRepository;

    /*
       You have to register RestTemplate as a bean so that the interceptors will get injected.
       If you create a RestTemplate instance with a new keyword then the instrumentation WILL NOT work.
    */
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/getEmployees")
    public List<Employee> getEmployees(){
        log.info("processing request /getEmployees");

        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("user", "pwd"));
        ResponseEntity<List<Device>> devicesResponse
                = restTemplate.exchange("http://localhost:3001/getDevices",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Device>>() {
                });
        List<Device> devices = devicesResponse.getBody();

        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(employee -> employee.setDevices(devices));

        return employees;
    }



}
