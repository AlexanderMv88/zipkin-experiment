package org.deviceRestApi;

import org.deviceRestApi.entity.Device;
import org.deviceRestApi.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DeviceRestApiApplication implements CommandLineRunner {

	@Autowired
	DeviceRepository deviceRepository;

	public static void main(String[] args) {
		SpringApplication.run(DeviceRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Device> devices = new ArrayList<>();
		devices.add(new Device(1, "PC"));
		devices.add(new Device(2, "phone"));
		devices.add(new Device(3, "laptop"));
		deviceRepository.saveAll(devices);

	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}pwd").roles("USER");
	}

	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/getDevices").allowedOrigins("http://localhost:8082S");
			}
		};
	}*/
}
