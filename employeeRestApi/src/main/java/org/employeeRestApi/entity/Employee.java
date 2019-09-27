package org.employeeRestApi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    private Integer id;
    private String name;
    @Transient
    private List<Device> devices;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(Integer id, String name, List<Device> devices) {
        this.id = id;
        this.name = name;
        this.devices = devices;
    }
}
