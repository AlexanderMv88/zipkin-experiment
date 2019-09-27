package org.employeeRestApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Device {
    private Integer id;
    private String model;

    public Device() {
    }
}
