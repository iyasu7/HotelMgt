package com.iyex.hotelmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HotelMgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMgtApplication.class, args);
	}

}
