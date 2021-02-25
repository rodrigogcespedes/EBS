package com.microservicioStock.microservicioStock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Si se usa Eureka
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//@EnableEurekaClient

//@EnableHystrixDashboard
//@EnableHystrix
//@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class microservicioStock {

	public static void main(String[] args) {
		SpringApplication.run(microservicioStock.class, args);
	}

}
