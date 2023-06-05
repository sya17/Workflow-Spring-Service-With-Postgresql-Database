package com.service.service;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	// @Bean
	// public ModelMapper modelMapper() {
    //     ModelMapper mp = new ModelMapper();
    //     mp.getConfiguration()
	// 	.setSkipNullEnabled(true)
	// 	.setPropertyCondition(Conditions.isNotNull());
	// 	return mp;
	// }
}
