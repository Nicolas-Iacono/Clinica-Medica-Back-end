package com.backend.clinicaOdontologicaIntegrador;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class clinicaOdontologicaIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(clinicaOdontologicaIntegradorApplication.class, args);
	}
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
