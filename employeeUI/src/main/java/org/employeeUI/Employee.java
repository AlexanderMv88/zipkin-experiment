package org.employeeUI;


import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private Integer id;
    private String name;
    private List<Device> devices;

    public Employee(Integer id, String name, List<Device> devices) {
        this.id = id;
        this.name = name;
        this.devices = devices;
    }

    public Employee() {
    }
}
