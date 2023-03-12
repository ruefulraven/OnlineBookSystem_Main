package com.obs.application.obs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ObsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObsApplication.class, args);
	}

}
