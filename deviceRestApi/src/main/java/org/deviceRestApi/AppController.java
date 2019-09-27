package org.deviceRestApi;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;
import org.deviceRestApi.entity.Device;
import org.deviceRestApi.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class AppController {

    @Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Autowired
    DeviceRepository deviceRepository;

    /*@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;*/

    @RequestMapping("/getDevices")
    public List<Device> getDevices(){
        log.info("processing request /getDevices");
        return deviceRepository.findAll();
    }
}
