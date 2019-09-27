package org.deviceRestApi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Device {
    @Id
    private Integer id;
    private String model;

    public Device(Integer id, String model) {
        this.id = id;
        this.model = model;
    }


}
