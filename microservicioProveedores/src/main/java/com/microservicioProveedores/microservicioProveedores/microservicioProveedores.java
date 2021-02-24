package com.microservicioProveedores.microservicioProveedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Si es eureka
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class microservicioProveedores {

	public static void main(String[] args) {
		SpringApplication.run(microservicioProveedores.class, args);
	}

}
