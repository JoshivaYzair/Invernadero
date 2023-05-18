package com.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicioSensorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioSensorApplication.class, args);
	}

}
