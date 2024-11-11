package com.rancho_smart.ms_credenciales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCredencialesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCredencialesApplication.class, args);
	}

}
