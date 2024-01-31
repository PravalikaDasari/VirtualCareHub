package com.virtualcaredoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.virtualcare")       /* ADDED HERE */

public class VirtualcareDoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualcareDoctorApplication.class, args);
	}

}
