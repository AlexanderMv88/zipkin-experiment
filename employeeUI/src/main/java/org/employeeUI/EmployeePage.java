package org.employeeUI;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Route
public class EmployeePage extends VerticalLayout {

    public EmployeePage(RestTemplate restTemplate) {

        ResponseEntity<List<Employee>> employeeResponse
                = restTemplate.exchange("http://localhost:3000/getEmployees",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> employees = employeeResponse.getBody();


        Grid<Employee> employeeGrid = new Grid<>(Employee.class, true);
        employeeGrid.setItems(employees);
        employeeGrid.setColumns("id", "name", "devices");


        this.add(employeeGrid);
    }
}
