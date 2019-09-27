package org.employeeRestApi;

import org.employeeRestApi.entity.Employee;
import org.employeeRestApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class EmployeeRestApiApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;



	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,"Вася"));
		employees.add(new Employee(2,"Коля"));
		employeeRepository.saveAll(employees);
	}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}pwd").roles("USER");
	}
}
